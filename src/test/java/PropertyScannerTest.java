import org.codehaus.groovy.tools.shell.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertyScannerTest {

    private PropertyScanner propertyScanner;

    @BeforeEach
    void setUp() throws IOException {
        propertyScanner=new PropertyScanner();
    }

    @Test
    @DisplayName("Тест получения значения свойства")
    void testgetProperty() throws IOException {
        String expected="ololo";
        assertEquals(expected,propertyScanner.getProperty("test.prop"));

    }
}