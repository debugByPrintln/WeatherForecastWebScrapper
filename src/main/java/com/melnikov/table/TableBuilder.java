package com.melnikov.table;

import com.melnikov.parser.WeatherParser;
import de.vandermeer.asciitable.AsciiTable;

import java.io.IOException;
import java.util.ArrayList;

public class TableBuilder {
    private final WeatherParser parser = new WeatherParser();

    public AsciiTable buildTwoWeeksForecastTable() throws IOException{
        AsciiTable table = new AsciiTable();

        buildHeader(table);

        addTwoWeeksForecastToTable(table);

        return table;
    }

    public AsciiTable buildOneWeekForecastTable() throws IOException{
        AsciiTable table = new AsciiTable();

        buildHeader(table);

        addOneWeekForecastToTable(table);

        return table;
    }

    public  AsciiTable buildOneDayForecastTable() throws IOException {
        AsciiTable table = new AsciiTable();

        buildHeader(table);

        addOneDayForecastToTable(table);

        return table;
    }

    private void buildHeader(AsciiTable table){
        table.addRule();
        table.addRow(" ", null, "Conditions", null, null, "Comfort", null, "Precipitation", null, null, "Sun");
        table.addRule();
        table.addRow("Day", "Temperature", "Weather", "Feels like", "Wind", "Humidity", "Chance", "Amount", "UV", "Sunrise", "Sunset");
        table.addRule();
    }

    private void addTwoWeeksForecastToTable(AsciiTable table) throws IOException{
        ArrayList<ArrayList<String>> twoWeeksForecast = parser.twoWeeksForecast();

        for (ArrayList<String> dayForecast : twoWeeksForecast) {
            table.addRow(dayForecast);
            table.addRule();
        }

    }

    private void addOneWeekForecastToTable(AsciiTable table) throws IOException{
        ArrayList<ArrayList<String>> weekForecast = parser.weekForecast();

        for (ArrayList<String> dayForecast : weekForecast) {
            table.addRow(dayForecast);
            table.addRule();
        }
    }

    private void addOneDayForecastToTable(AsciiTable table) throws IOException {
        ArrayList<String> forecast = parser.oneDayForecast();

        table.addRow(forecast);
        table.addRule();
    }
}
