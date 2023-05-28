package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
        /*
    Given
       https://jsonplaceholder.typicode.com/todos
       {
       "userId": 55,
       "title": "Tidy your room",
       "completed": false
       }
   When
       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test
    public void name() {

        //set the url
        spec.pathParam("first", "todos");

        //set the expected data
        JsonPlaceHolderPojo expectedData= new JsonPlaceHolderPojo(55, "Tidy your room", false);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response= given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //do assertion
        JsonPlaceHolderPojo actualData= response.as(JsonPlaceHolderPojo.class);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }
}
