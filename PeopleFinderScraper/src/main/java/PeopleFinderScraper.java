import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashSet;
import java.util.Set;

public class PeopleFinderScraper {

    public static void main(String[] args) throws Exception{

        // Replicate http call with Unirest.get() method
        final HttpResponse<String> response = Unirest.get("https://www.peoplefinders.com/peoplesearch/searchresults?showAnimatedLoadingBar=true&search=People&fn=&ln=Smith&city=New+York&state=NY").asString();

        System.out.println(response.getBody());

    }
}
