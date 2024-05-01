package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String inputFormat) throws Exception  {
        return switch (inputFormat) {
            case "json" -> parseJson(content);
            case "yaml", "yml" -> parseYaml(content);
            default -> throw new Exception();
        };
    }

    public static Map parseJson(String content) throws Exception  {
        ObjectMapper mapper  = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {
        });
    }

    public static Map parseYaml(String content) throws Exception  {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, Map.class);
    }
}
