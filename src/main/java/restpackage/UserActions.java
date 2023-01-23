package restpackage;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserActions extends RestSettings {
    private static final String LOGIN = "auth/login/";
    private static final String REGISTER = "auth/register/";
    private static final String DEL_OR_UPD = "auth/user/";

    public Response createUser(User user){
        return (Response) given()
                .spec(getBaseSpecSettings())
                .body(user)
                .when()
                .post(REGISTER)
                .then()
                .extract();
    }

    public static Response login(UserData data){
        return (Response) given()
                .spec(getBaseSpecSettings())
                .body(data)
                .when()
                .post(LOGIN)
                .then()
                .extract();
    }

    public void delete(Response response) {
        String token = response.body().jsonPath().getString("accessToken");
        if ( token == null) {
            return;
        }
        given()
                .spec(getBaseSpecSettings())
                .header("authorization", token)
                .when()
                .delete(DEL_OR_UPD);
    }
}
