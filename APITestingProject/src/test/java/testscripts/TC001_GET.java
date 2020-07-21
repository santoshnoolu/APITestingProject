package testscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET {
	@Test
	public void test()
	{
		RestAssured.baseURI="http://parabank.parasoft.com/parabank/services/bank/customers/12212/";
		RequestSpecification req= RestAssured.given();
		Response rs=req.request(Method.GET);
		String RespBody=rs.body().asString();
		System.out.println(RespBody);
		String strRes=rs.asString();
		System.out.println(strRes);
		Assert.assertEquals(rs.getStatusCode(), 200);
		Assert.assertEquals(rs.getStatusLine(), "HTTP/1.1 200 ");
		Assert.assertEquals(rs.getContentType(), "application/xml");
		
	}

}
