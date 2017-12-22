import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class UnirestScraper {

    public static void main(String[] args) throws Exception {


        // Change the default user-agent header
        Unirest.setDefaultHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");

        // Use a proxy
//        Unirest.setProxy(new HttpHost("89.238.128.173", 80));

        // Dependencies http://unirest.io/java.html
        // Making a simple get request to httpbin.org
//        final HttpResponse<String> getResponse = Unirest.get("http://httpbin.org/get").asString();
        final HttpResponse<JsonNode> getResponse = Unirest.get("http://httpbin.org/get").queryString("limit", 10).asJson();
//
        System.out.println(getResponse.getBody());
        System.out.println("proxy ip:      " + getResponse.getBody().getObject().getString("origin")); // returns ip address
        System.out.println("User-Agent:    " + getResponse.getBody().getObject().getJSONObject("headers").getString("User-Agent"));

        System.out.println("\n\n -----------------------------\n\n");

        final HttpResponse<String> postResponse1 = Unirest.post("http://httpbin.org/post").field("postalcode", 12345).asString();

        System.out.println(postResponse1.getBody());

        System.out.println("\n\n -----------------------------\n\n");

        // Make a post request with body data (Json)
        final JSONObject exampleJson = new JSONObject().put("postalcode", 12345);
        final HttpResponse<String> postResponse2 = Unirest.post("http://httpbin.org/post").body(exampleJson).asString();

        System.out.println(postResponse2.getBody());
    }


}
