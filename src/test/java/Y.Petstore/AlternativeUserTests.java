package Y.Petstore;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AlternativeUserTests {
	String message;
	@BeforeAll
	public static void setup() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	@Test
	@Order(1)
	public void createUsers(){
		HashMap data = new HashMap();
		data.put("id", 42);
		data.put("username", "iko_iko");
		data.put("firstName", "Denis");
		data.put("lastName", "Terekhov");
		data.put("email", "string");
		data.put("password", "string");
		data.put("phone", "string");
		data.put("userStatus", 0);
		message = String.valueOf(given()
				.contentType("application/json")
				.body(data)
				.when()
				.post("https://petstore.swagger.io/v2/user")
				.jsonPath().getInt("message"));
	}
	@Test
	@Order(2)
	public void getUsers(){
		given()
				.when()
				.get("https://petstore.swagger.io/v2/user/iko_iko")
				.then()
				.statusCode(200)
				.body("username",equalTo("iko_iko"))
				.log().all();
	}
	@Test
	@Order(3)
	public void updateUsers(){
		HashMap data = new HashMap();
		data.put("id", 24);
		data.put("username", "iko_iko");
		data.put("firstName", "Denis");
		data.put("lastName", "Terekhov");
		data.put("email", "string");
		data.put("password", "string");
		data.put("phone", "string");
		data.put("userStatus", 0);
		message= String.valueOf(given()
				.contentType("application/json")
				.body(data)
				.when()
				.post("https://petstore.swagger.io/v2/user")
				.jsonPath().getInt("message"));
	}
	@Test
	@Order(4)
	void deleteUser(){
		given()
				.when()
				.delete("https://petstore.swagger.io/v2/user/iko_iko")
				.then()
				.statusCode(200)
				.log().all();
	}
}
