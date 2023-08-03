package helpers.user;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class User {
    private String email;
    private String password;
    private String name;
    private String token;
    private Faker faker = new Faker();
    public static final String ENDPOINT = "https://stellarburgers.nomoreparties.site/api/auth/register";

    public User() {
        email = faker.pokemon().name() + faker.number().digits(5) + "@mail.ru";
        password = faker.number().digits(8);
        name = faker.name().firstName();
    }

    public void createUser() {
        UserRequest user = new UserRequest(email, password, name);
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(ENDPOINT);

        response.then()
                .statusCode(200);

        token = response.as(UserResponse.class).getAccessToken();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
