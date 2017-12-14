import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestScraper {

    public static void main(String[] args) throws UnirestException {


        // Dependencies http://unirest.io/java.html
        //Making a simple get request to httpbin.org
        final HttpResponse<JsonNode> getResponse = Unirest.get("http://httpbin.org/get").queryString("limit", 10)
                .asJson();

        System.out.println(getResponse.getBody());
    }
}
