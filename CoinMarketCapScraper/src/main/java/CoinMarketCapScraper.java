import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.*;

public class CoinMarketCapScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        String url = "https://coinmarketcap.com/all/views/all/";
        final Document doc = Jsoup.connect(url)
                .timeout(10000)
                .maxBodySize(0)
                .get();

        final Elements bigTable = doc.select("tbody > tr"); // gets row by row

        for (Element row : bigTable) {

            System.out.println(row.text() + "\n");

//            final Elements bigTableData = doc.getElementsByTag("tr > td");
//
//            for (Element td : bigTableData) {
//                System.out.print(td.text() + "\t");
//            }
        }

    }
}
