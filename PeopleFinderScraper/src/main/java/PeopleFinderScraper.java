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
//        final HttpResponse<String> response = Unirest.get("https://www.peoplefinders.com/peoplesearch/searchresults?showAnimatedLoadingBar=true&search=People&fn=&ln=Smith&city=New+York&state=NY").asString();

        // Extract query string parameters
        final String lastName = "Smith";
        final String city = "New York";
        final String state = "NY";

        final HttpResponse<String> response = Unirest.get("https://www.peoplefinders.com/GetResults?Latitude=0&Longitude=0&BoundSize=0&MaxRowsSpecified=True&" +
                "MaxRows=80&Rows=10&Start=1&SearchEngineID=4&SearchEngineIDSpecified=True&SearchType=Peoplefinders.Services.Web.PAWebService.PeopleNameSearchCriteria&search=People&" +
                "StateDropDownPlaceholder=State&LogMe=True&InvalidPhone=False&IsOptOutRequest=False&Widgets=System.Collections.Generic.Dictionary%602%5BSystem.String%2CSystem.Int32%5D&isVoucher=False&" +
                "mobileAnimated=False&isBackgroundReport=False&isPhoneReport=False&isPaidSearch=False&poSearch=False")
                .queryString("ln", lastName)
                .queryString("LastName", lastName)
                .queryString("city", city)
                .queryString("state", state)
                .asString();

        System.out.println(response.getBody());

    }
}
