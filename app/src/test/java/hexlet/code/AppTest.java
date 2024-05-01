package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    String filePath1 = "src/test/resources/file1.json";
    String filePath2 = "src/test/resources/file2.json";
    String filePath3 = "src/test/resources/file1.yml";
    String filePath4 = "src/test/resources/file2.yml";

    String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

    @Test
    public void testCallJSON() throws Exception {
        String actual = Differ.generate(filePath1, filePath2);
        assertEquals(expected, actual);
    }

    @Test
    public void testCallYAML() throws Exception {
        String actual = Differ.generate(filePath3, filePath4);
        assertEquals(expected, actual);
    }
}
