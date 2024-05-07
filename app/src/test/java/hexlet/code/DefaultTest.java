package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class DefaultTest {
    private static String expected;

    @BeforeAll
    public static void init() throws IOException {
        String expectedFile = "src/test/resources/expectedStylish.txt";
        expected = Files.readString(Paths.get(expectedFile));
    }

    @Test
    void jsonTest() throws Exception {
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        assertThat(Differ.generate(file1, file2)).isEqualTo(expected);
    }

    @Test
    void ymlTest() throws Exception {
        String file1 = "src/test/resources/file1.yml";
        String file2 = "src/test/resources/file2.yml";
        assertThat(Differ.generate(file1, file2))
                .isEqualTo(expected);
    }
}
