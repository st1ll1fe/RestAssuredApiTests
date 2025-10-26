package services;


import assertions.AssertableResponse;
import io.restassured.http.ContentType;
import models.swagger.FullUser;
import models.swagger.JwtAuthData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserService {
    public AssertableResponse register(FullUser user){
        return new AssertableResponse(given().contentType(ContentType.JSON)
                .body(user)
                .post("/api/signup")
                .then());
    }

    public AssertableResponse getUserInfo(String jwt){
        return new AssertableResponse(given().auth().oauth2(jwt)
                .get("/api/user")
                .then());
    }

    public AssertableResponse getUserInfo(){
        return new AssertableResponse(given()
                .get("/api/user")
                .then());
    }

    public AssertableResponse updatePass(String newPassword, String jwt){
        Map<String, String> password = new HashMap<>();
        password.put("password", newPassword);

        return new AssertableResponse(given().contentType(ContentType.JSON)
                .auth().oauth2(jwt)
                .body(password)
                .put("/api/user")
                .then());
    }

    public AssertableResponse deleteUser(String jwt){
        return new AssertableResponse(given().auth().oauth2(jwt)
                .delete("/api/user")
                .then());
    }

    public AssertableResponse auth(FullUser fullUser){
        JwtAuthData data = new JwtAuthData(fullUser.getLogin(), fullUser.getPass());
        return new AssertableResponse(given().contentType(ContentType.JSON)
                .body(data)
                .post("/api/login")
                .then());
    }

    public AssertableResponse getAllUsers(){
        return new AssertableResponse(given()
                .get("/api/users")
                .then());
    }
}