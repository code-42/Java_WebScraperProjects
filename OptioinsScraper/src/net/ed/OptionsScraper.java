package net.ed;

import java.io.PrintWriter;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.mashape.unirest.request.GetRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.lang.model.util.ElementScanner6;
//import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.*;

public class OptionsScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36";

//    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        String url = "https://coinmarketcap.com/all/views/all/";
        String query = "";

        // Downloads the html from coinmarketcap.com and parses it
        final org.jsoup.nodes.Document doc = Jsoup.connect(url + URLEncoder.encode(query,"UTF-8"))
                .userAgent(USER_AGENT)
                .timeout(20000)
                .maxBodySize(0)
                .get();

        PrintWriter csv = new PrintWriter("results.csv");

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
                System.out.print(cols.get(c).text() + "\t");
                csv.write((cols.get(c).text() + "\t"));
            }

            // empty println is same as \n
            System.out.println();
            csv.write("\n");
        }
        csv.close();
    }
}
