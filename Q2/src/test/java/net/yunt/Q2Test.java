package net.yunt;

import com.jayway.restassured.*;
import com.jayway.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Q2Test {
	
	private String gitHubAPI = "https://api.github.com";
  
	@DataProvider(name = "userNames")
	public static Object[][] userNamesInputs() {
		return new Object[][] {{"happypeter"}, {"evilsocket"}, {"JohnSundell"},{"SeanYunt"}};
    }
	
	@DataProvider(name = "badUserNames")
	public static Object[][] badUserNamesInputs() {
		return new Object[][] {{""}, {" "}, {"___"}};
    }
	
	@DataProvider(name = "nonExistingUsers")
	public static Object[][] nonExistingUsersInputs() {
		return new Object[][] {{"99999999999999999999"}, {"QWEERTYUIOP"}, {"HisRoyalHighnessThePrincePhilip"}};
    }
	
	//test that each userName exists and has at least one project
	@Test(dataProvider = "userNames")
	public void testAcccountExists(String userName) throws Exception {
		String path = "/users/"+userName+"/repos";
		System.out.println("testing: "+gitHubAPI+path);
		RestAssured.given().
		header("Accept", "application/vnd.github.v3+json"	). 
	    when().
	        get(gitHubAPI+path).
	    then().
            contentType(ContentType.JSON).
	    	statusCode(200).
	    	body("owner.login[0]",equalTo(userName));
	}
	
	//userNames with illegal syntax
	@Test(dataProvider = "badUserNames")
	public void testBadAccount(String userName) throws Exception {
		String path = "/users/"+userName+"/repos";
		System.out.println("testing: "+gitHubAPI+path);
		RestAssured.given().
		header("Accept", "application/vnd.github.v3+json"	). 
	    when().
	        get(gitHubAPI+path).
	    then().
            contentType(ContentType.JSON).
	    	statusCode(404).
	    	body("message",equalTo("Not Found")).
	    	body("documentation_url",equalTo("https://developer.github.com/v3/repos/#list-user-repositories"));
	}
	
	//bogus userNames that do not exist in GitHub
	@Test(dataProvider = "nonExistingUsers")
	public void testNonExistingAccount(String userName) throws Exception {
		String path = "/users/"+userName+"/repos";
		System.out.println("testing: "+gitHubAPI+path);
		RestAssured.given().
		header("Accept", "application/vnd.github.v3+json").
	    when().
	        get(gitHubAPI+path).
	    then().
            contentType(ContentType.JSON).
	    	statusCode(200).
	    	body("[0]",equalTo(null));
	}
	
	@Test
	public void testSeanYuntProject() throws Exception {
		String path = "/users/SeanYunt/repos";
		System.out.println("testing: "+gitHubAPI+path);
		RestAssured.given().
		header("Accept", "application/vnd.github.v3+json"	). 
	    when().
	        get(gitHubAPI+path).
	    then().
            contentType(ContentType.JSON).
	    	statusCode(200).
	    	body("owner.login[0]",equalTo("SeanYunt")).
	    	body("name[0]", equalTo("Apex_Sandbox")).
	    	body("full_name[0]", equalTo("SeanYunt/Apex_Sandbox")).
	    	body("html_url[0]", equalTo("https://github.com/SeanYunt/Apex_Sandbox")).
	    	body("default_branch[0]", equalTo("master"));	
		}
}