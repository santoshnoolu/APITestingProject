package testscripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_PUT_UpdateDetails {

	@SuppressWarnings("unchecked")
	@Test
	public void test()
	{
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req= RestAssured.given();
		JSONObject reqparam= new JSONObject();
		reqparam.put("name","morpheus");
		reqparam.put("job", "zion resident");
		req.header("Content-Type","application/json");
		req.body(reqparam.toJSONString());
		Response res=req.request(Method.PUT,"/api/users/2");
		System.out.println(res.asString());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.body().jsonPath().getBoolean("updatedAt"));
		
		
	}
}
