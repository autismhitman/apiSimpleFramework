package apiframework;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apis.CreateCustomerApis;
import io.restassured.response.Response;
import utils.dataImport;
 
public class CreateCustomerTest extends BaseTest {
	
	
	@Test(dataProviderClass=dataImport.class,dataProvider="getData")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> table, ITestContext con)  {
	
		//validateCreateCustomerAPIWithValidSecretKey
		
		Response response= CreateCustomerApis.sendPostrequestToCreateCustomerWithValidSecretKey(table);
		System.out.println(response.asPrettyString());
		test.log(Status.INFO, " Response is captured: " + response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		con.setAttribute("ID", response.jsonPath().get("id"));
		String id = (String)con.getAttribute("ID");
		test.log(Status.INFO, " ID is captured as : " + id);
		System.out.println(" This is on create Test , id is : " + id);
		  
	}
	
	



	
	@Test(dataProviderClass=dataImport.class,dataProvider="getData")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> table)  {
		
		//validateCreateCustomerAPIWithInValidSecretKey
		
		Response response= CreateCustomerApis.sendPostrequestToCreateCustomerWithInValidSecretKey(table);
		System.out.println(response.asPrettyString());
		test.log(Status.INFO, "INvalid token was sent so expecting 401");
		Assert.assertEquals(response.getStatusCode(), 401);
	} 

}
