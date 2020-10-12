package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_ListUsers {
	@Test
	public void test()
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req= RestAssured.given();
		Response rs= req.request(Method.GET,"/api/users?page=2");
		System.out.println(rs.asString());
		System.out.println(rs.body().asString());
		Assert.assertEquals(rs.getContentType(),"application/json; charset=utf-8");
		Assert.assertEquals(rs.getStatusCode(),200);
		Assert.assertEquals(rs.getHeader("content-encoding"),"gzip");
		System.out.println(rs.getHeaders());
		Assert.assertEquals(rs.getBody().jsonPath().get("page"),2);
		for(int i=0;i<rs.getBody().jsonPath().getList("data").size();i++)
		{
		System.out.println("Data for "+i+rs.getBody().jsonPath().getList("data").get(i));
	
		}
		}

}
