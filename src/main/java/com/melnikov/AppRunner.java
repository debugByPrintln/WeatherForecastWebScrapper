package com.melnikov;

import com.melnikov.parser.WeatherParser;
import com.melnikov.printer.TablePrinter;
import com.melnikov.table.TableBuilder;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;
import java.util.ArrayList;

public class AppRunner {
    static TablePrinter tablePrinter = new TablePrinter();

    public static void main(String[] args) throws IOException {
        WeatherParser weatherParser = new WeatherParser();
//
//        ArrayList<String> oneDay = weatherParser.oneDayForecast();
//        System.out.println(oneDay.size() + " - " + oneDay);
//
//        System.out.println("---------------------------------------------------------------------------------------------");
//
//        ArrayList<ArrayList<String>> oneWeek = weatherParser.weekForecast();
//        System.out.println(oneWeek.size() + " - " + oneWeek);
//        for (ArrayList<String> tmp:oneWeek) {
//            System.out.println(tmp.size() + " - " + tmp);
//        }
//
//        System.out.println("---------------------------------------------------------------------------------------------");
//
//        ArrayList<ArrayList<String>> twoWeek = weatherParser.twoWeeksForecast();
//        System.out.println(twoWeek.size() + " - " + twoWeek);
//        for (ArrayList<String> tmp:twoWeek) {
//            System.out.println(tmp.size() + " - " + tmp);
//        }

        ArrayList<String> list = weatherParser.oneDayForecast();
        System.out.println(list.size() + " - " + list);

        tablePrinter.printOneDayForecastTable();
        System.out.println("=======================================================================================================");
        tablePrinter.printOneWeekForecastTable();
        System.out.println("=======================================================================================================");
        tablePrinter.printTwoWeeksForecastTable();


    }
}
