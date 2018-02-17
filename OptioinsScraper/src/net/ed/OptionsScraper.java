package net.ed;

/**
 * OptionsScraper project
 * created by Edward Dupre
 * copyright 2018
 * scrape data from
 * https://oic.ivolatility.com/oic_adv_options.j;jsessionid=aC-rWaKSNTra
 *
 * much of this page learned from https://aboullaite.me/jsoup-html-parser-tutorial-examples/
 *
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import java.net.URLEncoder;
import java.util.regex.*;

public class OptionsScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

//    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        String url = "https://oic.ivolatility.com/oic_adv_options.j;jsessionid=aC-rWaKSNTra";
        String query = "";

        // Downloads the html from oic.volatility.com and parses it
//        final org.jsoup.nodes.Document doc = Jsoup.connect(url + URLEncoder.encode(query,"UTF-8"))
//                .userAgent(USER_AGENT)
//                .timeout(20000)
//                .maxBodySize(0)
//                .get();

        String doc = url;
        String html = Jsoup.connect(doc).get().html();
        System.out.println(html);

        try {

            Document page = Jsoup.connect(url).get();
//            String description = doc.select("meta[name=description]").first().attr("content");
//            System.out.println("Description: " + description);
//
//            String keywords = doc.select("meta[name=keywords]").first().attr("content");
//            System.out.println("Keywords: " + keywords);

            // get links on page
            Elements links = page.select("a[href]");
            for (Element link : links){
                System.out.println("link: " + link.attr("href"));
                System.out.println("text: " + link.text());
            }


        }
        catch (NullPointerException e){
            System.out.println("errr: " + e);
        }


        // sanitizing html
        boolean valid = Jsoup.isValid(doc, Whitelist.basic());

        if (valid) {

            System.out.println("\n!!!!! The document is valid");
        } else {

            System.out.println("\n!!!!! The document is not valid.");
            System.out.println("Cleaned document");

            Document dirtyDoc = Jsoup.parse(doc);
            Document cleanDoc = new Cleaner(Whitelist.basic()).clean(dirtyDoc);

            System.out.println(cleanDoc.html());
        }

        // get forms attributes
        try {

            Document docx = Jsoup.connect(url).get();
            Elements formElements = docx.getElementsByTag("form");

            for (Element formElement : formElements) {
                String key = formElement.attr("name");
                String value = formElement.attr("action");
                System.out.println("Param name: " + key + " \nParam value: " + value);
            }
        }
        catch (NullPointerException e){
            System.out.println("errr: " + e);
        }


        // get images
//        Document doc;
        try {

            //get all images
            Document doc2 = Jsoup.connect(url).get();
            Elements images = doc2.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {

                System.out.println("\nsrc : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
