package testscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_UserNotFound {
	@Test
	public void test()
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req= RestAssured.given();
		Response res=req.request(Method.GET,"/api/users/23");
		System.out.println(res.body().asString());
		Assert.assertEquals(res.getStatusCode(),404);
	}

}
