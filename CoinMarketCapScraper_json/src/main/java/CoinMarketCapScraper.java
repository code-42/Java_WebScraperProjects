import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import javax.lang.model.util.ElementScanner6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.*;

public class CoinMarketCapScraper {

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        String url = "https://coinmarketcap.com/all/views/all/";
        String query = "";

        // Downloads the html from coinmarketcap.com and parses it
        final Document doc = Jsoup.connect(url + URLEncoder.encode(query,"UTF-8"))
                .userAgent(USER_AGENT)
                .timeout(20000)
                .maxBodySize(0)
                .get();

        final List<SearchResult> resultList = new ArrayList<SearchResult>();

        String rowNum = "";
        String name = "";
        String symbol = "";
        String marketCap = "";
        String price = "";
        String circSupply = "";
        String vol24h = "";
        String change1h = "";
        String change24h = "";
        String change7d = "";

        // tbody is first container inside of the first table
        Element table = doc.select("tbody").get(0);

        // Target each row in tbody
        Elements rows = table.select("tr");

        // Target each td inside of each row
        for (int r = 0; r < rows.size(); r++) {
            Element row = rows.get(r);
            Elements cols = row.select("td");

            // print td for each row
            for (int c = 0; c < cols.size(); c++) {

                switch (c) {
                    case 0:
                        rowNum = cols.get(c).text();
                        break;
                    case 1:
                        name = cols.get(c).text();
                        break;
                    case 2:
                        symbol = cols.get(c).text();
                        break;
                    case 3:
                        marketCap = cols.get(c).text();
                        break;
                    case 4:
                        price = cols.get(c).text();
                        break;
                    case 5:
                        circSupply = cols.get(c).text();
                        break;
                    case 6:
                        vol24h = cols.get(c).text();
                        break;
                    case 7:
                        change1h = cols.get(c).text();
                        break;
                    case 8:
                        change24h = cols.get(c).text();
                        break;
                    case 9:
                        change7d = cols.get(c).text();
                        break;
                }
            }
            resultList.add(new SearchResult(rowNum, name, symbol, marketCap, price, circSupply, vol24h, change1h, change24h, change7d));
        }
        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File("results.json"), resultList);
    }
}
