package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.TreeMap;


public class Parser {

    public static TreeMap<String, Object> parse(String content, String format) throws Exception {
        ObjectMapper objectMapper = chooseFormat(format);
        return objectMapper.readValue(content, new TypeReference<>() { });
    }

    public static ObjectMapper chooseFormat(String format) throws Exception {
        return switch (format) {
            case "json" -> new ObjectMapper();
            case "yml", "yaml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new Exception("Format is unknown " + format);
        };
    }
}
