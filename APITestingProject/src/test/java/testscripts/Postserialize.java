package testscripts;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postserialize {

public static void main(String args[])
{
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification req=RestAssured.given();
	RequestPOJO newpo=new RequestPOJO();
	newpo.setName("Test");
	newpo.setJob("Tester");
	req.contentType("application/json");
	req.body(newpo);
	Response res=req.request(Method.POST);
	System.out.println(res.body().asString());
	System.out.println(res.body().jsonPath().get("name"));
	System.out.println(res.body().jsonPath().get("Job"));
	System.out.println(res.body().jsonPath().get("createdAt"));
}

}
