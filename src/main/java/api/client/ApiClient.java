package api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    public static Response post(String url, Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "sanmeer")
                .body(body)
                .post(url);
    }
    public static Response put(String url, Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "sanmeer")
                .body(body)
                .put(url);
    }
}