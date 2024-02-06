package apiframework;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import apis.DeleteCustomerApis;
import io.restassured.response.Response;
import utils.TestUtil;

public class DeleteCustomerTest extends BaseTest {
	

	@Test
	public void deleteCustomerWithValidID(ITestContext con) {
		
		String id = (String)con.getAttribute("ID");
		System.out.println("id is : " + id);
		Response response = DeleteCustomerApis.deleteCustomerWithValidIDAPI(id);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		Assert.assertTrue(TestUtil.hasKey(response.asString(), "id"), "id not present");
		Assert.assertTrue(TestUtil.hasKey(response.asString(), "object"), "object not present");
		Assert.assertTrue(TestUtil.hasKey(response.asString(), "deleted"), "deleted not present");
		
		Assert.assertEquals(TestUtil.getJsonKeyValue(response.asString(), "object"), "customer");
		Assert.assertEquals(TestUtil.getJsonKeyValue(response.asString(), "deleted"), true);
	}
	
	@Test
	public void deleteCustomerWithValidIDWithDeletedRecord(ITestContext con) {
		
		String id = (String)con.getAttribute("ID");
		System.out.println("id is : " + id);
		Response response = DeleteCustomerApis.deleteCustomerWithValidIDAPI("kkrtrtrto");
		test.log(Status.INFO,"Response is: "+ response.asPrettyString());
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
