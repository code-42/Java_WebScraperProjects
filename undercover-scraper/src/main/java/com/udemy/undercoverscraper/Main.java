package com.udemy.undercoverscraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.undercoverscraper.dto.SearchResult;

import java.util.List;

public class Main {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        final List<SearchResult> resultList = UndercoverScraper.scrapeGoogleSearchResults("apple");

        final String resultJson = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(resultList);

        System.out.println(resultJson);
    }
}
