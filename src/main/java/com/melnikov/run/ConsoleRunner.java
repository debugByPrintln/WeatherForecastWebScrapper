package com.melnikov.output;

import com.melnikov.printer.TablePrinter;

import java.io.IOException;
import java.util.Scanner;

public class ConsolePrinter {
    static TablePrinter tablePrinter = new TablePrinter();
    static Scanner scanner = new Scanner(System.in);

    public static void startApp() throws IOException {
        while (true){
            System.out.println("One day forecast - type 1, one week forecast - type 2, two weeks forecast - type 3.\n" +
                    "To exit program, type q.");

            String userMove = scanner.next();

            if (userMove.equals("1")){
                tablePrinter.printOneDayForecastTable();
                System.out.println("Type q to exit app. Type anything to see other forecasts.");
                userMove = scanner.next();
                if (userMove.equals("q")){
                    break;
                }
            }

            else if (userMove.equals("2")){
                tablePrinter.printOneWeekForecastTable();
                System.out.println("Type q to exit app. Type anything to see other forecasts.");
                userMove = scanner.next();
                if (userMove.equals("q")){
                    break;
                }
            }

            else if (userMove.equals("3")){
                tablePrinter.printTwoWeeksForecastTable();
                System.out.println("Type q to exit app. Type anything to see other forecasts.");
                userMove = scanner.next();
                if (userMove.equals("q")){
                    break;
                }
            }

            else if(userMove.equals("q")){
                break;
            }

            else {
                throw new UnsupportedOperationException("Unknown userMove");
            }
        }
    }
}
