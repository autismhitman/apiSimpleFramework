package apis;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.annotations.Test;

import apiframework.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomerApis extends BaseTest {
	
	
	
	public static Response deleteCustomerWithValidIDAPI(String id ) {
		
		Response response=
				 given()
				.auth()
				.basic(prop.getProperty("valid_token"), "")
				.when()
				.delete("/customers/"+ id);
		
		return response;
	}
	

}
