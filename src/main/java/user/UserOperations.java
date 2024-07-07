package user;

import config.APIs;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserOperations {
    @Step("Регистрация пользователя")
    public static Response createUser(User user) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(APIs.REGISTER_PATH);
        return response;
    }

    @Step("Вход пользователем")
    public static Response loginUser(User user) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(APIs.LOGIN_PATH);
        return response;
    }

    @Step("Получение accessToken пользователя")
    public static String getAccessToken(User user) {
        return loginUser(user).then().extract().path("accessToken");
    }

    @Step("Удаление пользователя")
    public static void deleteUser(String accessToken) {
        if (accessToken != null)
            given()
                    .header("Authorization", accessToken)
                    .when()
                    .delete(APIs.DELETE_PATH);
    }
}
