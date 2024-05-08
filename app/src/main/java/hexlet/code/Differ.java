package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = read(filePath1);
        Map<String, Object> data2 = read(filePath2);

        List<Map<String, Object>> comparisonResult = Comparison.compareFiles(data1, data2);

        return Formatter.formatChoice(comparisonResult, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static Map<String, Object> read(String filePath) throws Exception {
        String content = getContent(filePath);
        String inputFormat = getInputFormat(filePath);
        return Parser.parse(content, inputFormat);
    }

    private static String getContent(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
    private static String getInputFormat(String filePath) {
        return filePath.split("\\.")[1];
    }
}
