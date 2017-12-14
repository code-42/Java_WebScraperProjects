import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class GoogleScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

    public static void main(String[] args) throws IOException {

        // https://www.google.com/search?q=apple
        // #ires > ol > div:nth-child(1) > h3 > a
        // //*[@id="ires"]/ol/div[1]/h3/a

        final String query = "apple";


        // Downloads the html from goole
        // URLEncoder and USER_AGENT required if you get blocked
        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8"))
                .userAgent(USER_AGENT).get();

        // Print html of page
        // System.out.println(page.outerHtml());

        for (Element searchResult : page.select("h3.r a")) {

            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            System.out.println(title + " -> " + url + "\n");
        }


        // PrintWriter saves results to text file
        final PrintWriter out = new PrintWriter("results.txt");

        for (Element searchResult : page.select("h3.r a")) {

            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            out.write(title + " -> " + url + "\n");
        }

        out.close();

    }
}
