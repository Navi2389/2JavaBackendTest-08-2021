import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public final class FileUtils {
    private FileUtils(){}
    public static String getResourceAsBase64(String resourceName) throws URISyntaxException, IOException {
        /*InputStream inputStream= FileUtils.class.getResourceAsStream(resourceName);*/
        byte[] bytes=Files.readAllBytes(Path.of(FileUtils.class.getResource(resourceName).toURI()));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] getResourceAsByteArray (String resource) throws URISyntaxException, IOException {
return Files.readAllBytes(Path.of(FileUtils.class.getResource(resource).toURI()));
    }

}
