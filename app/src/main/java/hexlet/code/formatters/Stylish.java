package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    private static StringBuilder result;

    public static String stylishResult(List<Map<String, Object>> comparisonResult) throws Exception {
        result = new StringBuilder("{\n");

        for (Map<String, Object> map: comparisonResult) {
            switch ((String) map.get("status")) {
                case "unmodified" -> basicString(map, "oldValue", "    ");
                case "updated" -> {
                    basicString(map, "oldValue", "  - ");
                    basicString(map, "newValue", "  + ");
                }
                case "removed" -> basicString(map, "oldValue", "  - ");
                case "added" -> basicString(map, "newValue", "  + ");
                default -> throw new Exception("Unknown status: " + "status");
            }
        }
        result.append("}");
        return result.toString();
    }

    private static void basicString(Map<String, Object> map, String value, String diff) {
        result.append(diff)
                .append(map.get("key"))
                .append(": ")
                .append(map.get(value))
                .append("\n");
    }
}
