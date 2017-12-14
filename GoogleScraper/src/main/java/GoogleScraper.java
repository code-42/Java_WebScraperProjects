import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URLEncoder;

public class GoogleScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

    public static void main(String[] args) throws IOException {

        // https://www.google.com/search?q=apple
        // #ires > ol > div:nth-child(1) > h3 > a
        // //*[@id="ires"]/ol/div[1]/h3/a

        final String query = "apple";

        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8"))
                .userAgent(USER_AGENT).get();

        System.out.println(page.outerHtml());


    }
}
