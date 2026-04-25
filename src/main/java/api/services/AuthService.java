package api.services;

import api.client.ApiClient;
import api.endpoints.Endpoints;
import io.restassured.response.Response;

public class AuthService {

    public static Response generateToken(Object body) {
        return ApiClient.post(
                Endpoints.BASE_URL + Endpoints.USERS,
                body
        );
    }
    public static Response updateUser(int id, Object body) {
        return ApiClient.put(
                Endpoints.BASE_URL + Endpoints.USERS + "/" + id,
                body
        );
    }
}