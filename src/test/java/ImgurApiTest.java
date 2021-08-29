import io.restassured.RestAssured;
import io.restassured.config.MultiPartConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

class ImgurApiTest extends BaseApiTest {

    private String currentDeleteHash;

    public ImgurApiTest() throws IOException {
    }


    /*private PropertyScanner scanner;*/

    /*@BeforeEach
    void setUp() {

        scanner = new PropertyScanner();

    }*/


    @BeforeEach
    void setUp() {
        RestAssured.baseURI = getBaseUri();

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("Получение информации об аккаунте")
    void testGetAccountBase() throws IOException {
       /*String token = scanner.getProperty("imgur.auth.token");
        String baseUri = scanner.getProperty("imgur.api.url");
        String userName = scanner.getProperty("imgur.username");*/

        String response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth()
                .oauth2(getToken())
                /*.baseUri(getBaseUri())*/
                .expect()
                .body("data.url", is("IvanTestolga957"))
                .log()
                .all()
                .statusCode(200)
                .when()

                .get("3/account/{username}", getUserName())

                .body()
                .print();

        System.out.println(response);

    }

    //попробуем звгрузить картиночку
    @Test
    @DisplayName("Тест загрузки картинки")
    void testImageUpload() throws Exception {

        /*String img = FileUtils.getResourceAsBase64("res");*/
        /*var img=new String(FileUtils.getResourceAsByteArray("res.jpg"));*/
        /*MultiPartConfig.multiPartConfig().defaultBoundary()*/

        currentDeleteHash = given()
                .auth()
                .oauth2(getToken())
                .when()
                /*.contentType(ContentType.BINARY)*/
                .header(new Header("content-type", "multipart/form-data"))
                .multiPart("image",new File( "./src/main/resources/res.jpg"))
                /*.formParam("image", img)*/
                .expect()
                .statusCode(200)
                .body("data.id", is(notNullValue()))
                .body("data.deletehash", is(notNullValue()))
                .log()
                .all()
                .when()
                .post("3/upload")
                .jsonPath()
                .getString("data.deletehash"); //записываем


    }

}
