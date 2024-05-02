package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {

        Map<String, Object> data1 = Parser.parse(getContent(filePath1), getInputFormat(filePath1));
        Map<String, Object> data2 = Parser.parse(getContent(filePath2), getInputFormat(filePath2));

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        StringBuilder result = new StringBuilder("{\n");

        for (String key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
                } else {
                    result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                    result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                }
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }

    private static String getContent(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    private static String getInputFormat(String filePath) {
        return filePath.split("\\.")[1];
    }
}
