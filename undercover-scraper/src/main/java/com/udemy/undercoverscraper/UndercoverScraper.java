package com.udemy.undercoverscraper;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.udemy.undercoverscraper.dto.SearchResult;
import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UndercoverScraper {

    private static final Logger logger = LoggerFactory.getLogger(UndercoverScraper.class);

    //Chrome User Agent string
    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

    static {
        //Change the default user-agent header
        Unirest.setDefaultHeader("User-Agent", USER_AGENT);

        //Use a proxy
        //NOTE: this proxy will probably not work anymore when you try this example, just get another one here: http://proxylist.hidemyass.com/
//        Unirest.setProxy(new HttpHost("61.135.217.12", 80));
    }

    private static List<SearchResult> scrapeGoogleSearchResultsPage(String searchTerm, int page) {

        final List<SearchResult> resultList = new ArrayList<>();

        try {
            final HttpResponse<String> response = Unirest.get("https://www.google.com/search")
                    .queryString("q", searchTerm)
                    .queryString("start", page * 10)
                    .asString();

            final Document htmlPage = Jsoup.parse(response.getBody());

            for (Element searchResult : htmlPage.select("h3.r a")) {

                final String title = searchResult.text();
                final String url = searchResult.attr("href");

                resultList.add(new SearchResult(title, url));
            }

            logger.info("Scraped page {} for term: {}", page, searchTerm);
        } catch (Exception e) {
            logger.warn("Error while scraping page {} for term: {}", e);
        }

        return resultList;
    }

    public static List<SearchResult> scrapeGoogleSearchResults(String searchTerm) {

        final List<SearchResult> resultList = new ArrayList<>();

        //Scrape the first 30 results
        for (int page : Arrays.asList(0, 1, 2)) {
            resultList.addAll(scrapeGoogleSearchResultsPage(searchTerm, page));

            try {
                //Wait a random time anywhere between 3 and 10 seconds
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 10000));
            } catch (InterruptedException e) {
                logger.warn("Error while waiting: ", e);
            }
        }

        return resultList;
    }
}
