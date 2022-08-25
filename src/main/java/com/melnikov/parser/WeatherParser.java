package com.melnikov.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherParser {
    public ArrayList<String> oneDayForecast() throws IOException {
        ArrayList<String> res = new ArrayList<>();

        ArrayList<String> dates = getDates();

        Elements tBodyElements = getTBodyElements();

        for (Element e: tBodyElements) {
            Elements elementsByTag = e.getElementsByTag("tr");
            Element element = elementsByTag.get(0);
            Elements td = element.getElementsByTag("td");
            for (Element eTd: td) {
                res.add(eTd.text());
            }
        }
        res.remove(0);
        res.remove(4);
        res.add(0, dates.get(0));

        return res;
    }

    public ArrayList<ArrayList<String>> weekForecast() throws IOException {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        ArrayList<String> dates = getDates();

        Elements tBodyElements = getTBodyElements();

        for (Element e: tBodyElements) {
            Elements elementsByTag = e.getElementsByTag("tr");
            for (int i = 0; i < 7; i++) {
                addElementsByTagForLoop(res, elementsByTag, i);
            }
        }

        removeEmptySpaces(res);
        removeWindDirection(res);
        addDates(res, dates);

        return res;
    }

    public ArrayList<ArrayList<String>> twoWeeksForecast() throws IOException {
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        ArrayList<String> dates = getDates();

        Elements tBodyElements = getTBodyElements();

        for (Element e: tBodyElements) {
            Elements elementsByTag = e.getElementsByTag("tr");
            for (int i = 0; i < 14; i++) {
                addElementsByTagForLoop(res, elementsByTag, i);
            }
        }

        removeEmptySpaces(res);
        removeWindDirection(res);
        addDates(res, dates);

        return res;
    }

    private void addElementsByTagForLoop(ArrayList<ArrayList<String>> res, Elements elementsByTag, int i) {
        Element element = elementsByTag.get(i);
        Elements td = element.getElementsByTag("td");
        ArrayList<String> tmp = new ArrayList<>();
        for (Element eTd: td) {
            tmp.add(eTd.text());
        }
        res.add(tmp);
    }

    private ArrayList<String> getDates() throws IOException {
        Elements tBodyElements = getTBodyElements();

        ArrayList<String> res = new ArrayList<>();

        for (Element e: tBodyElements) {
            Elements th = e.getElementsByTag("th");
            for (Element element:th) {
               res.add(element.text());
            }
        }
        return res;
    }

    private void removeWindDirection(ArrayList<ArrayList<String>> res){
        for (ArrayList<String> tmp : res) {
            tmp.remove(4);
        }
    }

    private void removeEmptySpaces(ArrayList<ArrayList<String>> res){
        for (ArrayList<String> tmp : res) {
            tmp.remove(0);
        }
    }

    private void addDates(ArrayList<ArrayList<String>> res, ArrayList<String> dates){
        for (int i = 0; i < res.size(); i++) {
            res.get(i).add(0 ,dates.get(i));
        }
    }

    private Elements getTBodyElements() throws IOException {
        Document doc = getDocument();

        return doc.getElementsByTag("tbody");
    }

    private Document getDocument() throws IOException {
        return Jsoup.connect("https://www.timeanddate.com/weather/russia/saint-peterburg/ext")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("https://www.google.com")
                .get();
    }
}
