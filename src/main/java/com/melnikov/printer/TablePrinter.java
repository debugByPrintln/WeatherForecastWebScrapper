package com.melnikov.printer;

import com.melnikov.table.TableBuilder;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.io.IOException;

public class TablePrinter {
    private final TableBuilder tableBuilder = new TableBuilder();

    public void printTwoWeeksForecastTable() throws IOException {
        AsciiTable table = tableBuilder.buildTwoWeeksForecastTable();

        String render = renderTable(table);
        printTable(render);
    }

    public void printOneWeekForecastTable() throws IOException {
        AsciiTable table = tableBuilder.buildOneWeekForecastTable();

        String render = renderTable(table);
        printTable(render);
    }

    public void printOneDayForecastTable() throws IOException {
        AsciiTable table = tableBuilder.buildOneDayForecastTable();

        String render = renderTable(table);
        printTable(render);
    }

    private void printTable(String renderedTable){
        System.out.println(renderedTable);
    }

    private String renderTable(AsciiTable table){
        table.setTextAlignment(TextAlignment.CENTER);
        return table.render(175);
    }
}
