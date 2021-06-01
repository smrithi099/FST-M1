package activities;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
	
  @Test(priority=1)
  public void postpet() {
	  
	  String reqbody =  "{"
			  + "\"id\": 777732,"
	
            + "\"name\": \"RileyCheck\","
	
            + " \"status\": \"alivecheck\""
	
        + "}";
	  
      Response response =  given().contentType(ContentType.JSON).body(reqbody).when().post(ROOT_URI);
  	//Assertion
      response.then().body("id", equalTo(777732));
      response.then().body("name", equalTo("RileyCheck"));
      response.then().body("status", equalTo("alivecheck"));
        
  }
      @Test(priority=2)
      public void getpet() {
    	  
    	  
    	  
          Response response =  given().contentType(ContentType.JSON).when().pathParam("petId", "777732") // Set path parameter
        			
                  .get(ROOT_URI + "/{petId}");
      	//Assertion
          response.then().body("id", equalTo(777732));
          response.then().body("name", equalTo("RileyCheck"));
          response.then().body("status", equalTo("alivecheck"));
  }
      @Test(priority=3)
  	
      public void deletePet() {
  	
          Response response = 
  	
              given().contentType(ContentType.JSON) // Set headers
  	
              .when().pathParam("petId", "777732") // Set path parameter
  	
              .delete(ROOT_URI + "/{petId}"); // Send DELETE request
  	
   
  	
          // Assertion
  	
          response.then().body("code", equalTo(200));
  	
          response.then().body("message", equalTo("777732"));
  	
      }


}
