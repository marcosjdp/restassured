package restassured;

import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class get {
	
		 private static RequestSpecification requestSpec;

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
	            assertThat()
	            //.body("places.'place name'", hasItem("Beverly Hills"));
	            .body("country.'$'", hasItem("United  States"));
	           // .body("places[0].'place name'", equalTo("Beverly Hills"))
	            //.body("places[0].'state'", equalTo("California"));
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

}
