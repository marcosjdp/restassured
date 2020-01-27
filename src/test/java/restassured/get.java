package restassured;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class get {
	
		 private static RequestSpecification requestSpec;
		 private static ResponseSpecification responseSpec;

@BeforeClass
	public static void createRequestSpecification() {

    requestSpec = new RequestSpecBuilder().
        setBaseUri("http://zippopotam.us/").
        build();
}
	
	 @Test
	    public void prueba1() {

	        given().
	        spec(requestSpec).
	        when().
	            get("us/90210").
	        then().
	        spec(responseSpec).
	        and().
	            assertThat()
	            .body("places.'place name'", hasItem("Beverly Hills"));
	            //.body("country.'$'", hasItem("United  States"));
	           // .body("places[0].'place name'", equalTo("Beverly Hills"))
	            //.body("places[0].'state'", equalTo("California"));
	    }
	 @Test
	    public void prueba2() {
	    
	        String placeName =
	        given().
	            spec(requestSpec).
	        when().
            get("http://zippopotam.us/us/90210").
	        then().
	            extract().
	            path("places[0].'Beverly Hills'");

	        Assert.assertEquals("placeName", "Beverly Hills");
	        
	      // System.out.println(placeName);
	    }
	

	/* @Test
	    public void prueba2() {

	        given()
	        .log().all().
	        when().
	            get("http://zippopotam.us/us/90210").
	        then()
	            .log().body();
	    }*/
	 


	    @BeforeClass
	    public static void createResponseSpecification() {

	        responseSpec = new ResponseSpecBuilder().
	            expectStatusCode(200).
	            expectContentType(ContentType.JSON).
	            build();
	    }

}
