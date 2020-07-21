package testscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Singleuser {
	@Test
	public void test()
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req= RestAssured.given();
		Response res=req.request(Method.GET,"/api/users/2");
		System.out.println(res.asString());
		System.out.println(res.body().jsonPath().getInt("data.id"));
		System.out.println(res.body().jsonPath().getString("data.email"));
	}

}
