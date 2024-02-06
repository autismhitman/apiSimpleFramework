package apiframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.net.httpserver.Authenticator.Result;

import io.restassured.RestAssured;
import listeners.ExtentManager;
import utils.Xls_Reader;

public class BaseTest {

	public static Properties prop;
	public FileInputStream fis;
	public static Xls_Reader xls = new Xls_Reader(
			System.getProperty("user.dir") + "//src//test//resources//TestUtil.xlsx");
	public ExtentReports rep;
	public ExtentTest test;

	@BeforeTest(alwaysRun = true)
	public void setUp() {

		prop = new Properties();

		try {
			fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "//src//test//resources//config.properties"));
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestAssured.baseURI = prop.getProperty("url");
		RestAssured.basePath = prop.getProperty("path");
		

	}
	
	@BeforeMethod
	public void setReport(ITestContext con) {
		rep = ExtentManager.getReports();
		test = rep.createTest(con.getCurrentXmlTest().getName() );
		test.log(Status.INFO, "Starting Test : " + con.getCurrentXmlTest().getName());
		con.setAttribute("rep", rep);
		con.setAttribute("test", test);
		
	}

	
	@AfterTest(alwaysRun = true)
	public void tearDown(ITestContext con) {

		rep = (ExtentReports) con.getAttribute("rep");

		if (rep != null)
			rep.flush();
	}

}
