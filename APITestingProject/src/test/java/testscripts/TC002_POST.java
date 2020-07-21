package testscripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST {
	@SuppressWarnings("unchecked")
	@Test
	public void test()
	{
		//Declaring Base URI
RestAssured.baseURI="https://reqres.in";
//Creating object for RequestSpecification Class
RequestSpecification req= RestAssured.given();
//Declaring test data through JSONObject class
JSONObject reqParam= new JSONObject();
reqParam.put("name", "morpheus");
reqParam.put("job","leader");
//Declaring content type
req.header("Content-Type","application/json");
//Adding the test data to request body
req.body(reqParam.toJSONString());
//Fetching the response of POST call
Response rs=req.request(Method.POST,"/api/users");
System.out.println(rs.asString());
System.out.println(rs.getContentType());
System.out.println(rs.getStatusCode());
System.out.println(rs.getStatusLine());
System.out.println(rs.jsonPath().get("createdAt"));
System.out.println(rs.jsonPath().get("id"));
		
	}
}
