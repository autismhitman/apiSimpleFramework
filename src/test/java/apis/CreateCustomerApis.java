package apis;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import apiframework.BaseTest;
import io.restassured.response.Response;

public class CreateCustomerApis extends BaseTest {
	
	
	
	public static Response sendPostrequestToCreateCustomerWithValidSecretKey(Hashtable<String, String> table ) {
		
		Response response=
				 given()
				.auth()
				.basic(prop.getProperty("valid_token"), "")
				.formParam("email", table.get("email"))
				.formParam("name", table.get("name"))
				.formParam("description", table.get("description"))
				.formParam("address[line1]", table.get("address[line1]"))
				.when()
				.post("/customers");
		
		return response;
	}
	
public static Response sendPostrequestToCreateCustomerWithInValidSecretKey(Hashtable<String, String> table ) {
		
	Response response=
			 given()
			.auth()
			.basic(prop.getProperty("invalid_token"), "")
			.formParam("email", table.get("email"))
			.formParam("name", table.get("name"))
			.formParam("description", table.get("description"))
			.formParam("address[line1]", table.get("address[line1]"))
			.when()
			.post("/customers");
		
		return response;
	}

}
