import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class jsoup_intro {

    public static void main(String[] args) throws IOException {

        // Downloads the html from wikipedia and parses it
        final Document doc = Jsoup.connect("http://en.wikipedia.org/").get();

        // Selects a bunch of a tags
        final Elements newsHeadlines = doc.select("#mp-itn b a");

        // Print to console
        for (Element headline : newsHeadlines) {
            System.out.println(headline.text());
        }
        
        System.out.println("\n\n---------------------------------------------------\n\n");

        // Print the outer html of the page
        System.out.println(doc.outerHtml());

    }
}
