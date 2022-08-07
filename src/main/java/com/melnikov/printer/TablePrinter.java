package com.melnikov.printer;

import com.melnikov.table.TableBuilder;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;

public class TablePrinter {
    private final TableBuilder tableBuilder = new TableBuilder();

    public void printTwoWeeksForecastTable() throws IOException {
        AsciiTable table = tableBuilder.buildTwoWeeksForecastTable();

        table.setTextAlignment(TextAlignment.CENTER);
        String render = table.render(175);
        System.out.println(render);
    }

    public void printOneWeekForecastTable() throws IOException {
        AsciiTable table = tableBuilder.buildOneWeekForecastTable();

        table.setTextAlignment(TextAlignment.CENTER);
        String render = table.render(175);
        System.out.println(render);
    }

    public void printOneDayForecastTable() throws IOException {
        AsciiTable table = tableBuilder.buildOneDayForecastTable();

        table.setTextAlignment(TextAlignment.CENTER);
        String render = table.render(175);
        System.out.println(render);
    }
}
