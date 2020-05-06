package entities;

import java.io.IOException;

public class MenuLayout {
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();

    public static String mainMenuLayout(){
        clearConsole();
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(30));sb.append(System.lineSeparator());
        sb.append(String.format("*%s*"," ".repeat(28)));sb.append(System.lineSeparator());
        sb.append(String.format("*   --CURRENCY CONVERTER--   *"));sb.append(System.lineSeparator());
        sb.append(String.format("*%s*"," ".repeat(28)));
        sb.append(System.lineSeparator());
        sb.append("*".repeat(30));
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());

        sb.append("1: Convert currency");
        sb.append(System.lineSeparator());
        sb.append("2: Exit");
        sb.append(System.lineSeparator());



        return sb.toString();
    }


    public static String convertMenu() {
        clearConsole();
        StringBuilder sb = new StringBuilder();
        sb.append("FROM --> TO");
        sb.append(System.lineSeparator());
        sb.append("ex: 1 USD EUR");
        sb.append(System.lineSeparator());
        sb.append("****************");
        sb.append(System.lineSeparator());


        return sb.toString();
    }

    private static void clearConsole() {
        try {
            if (OS_NAME.contains("windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch(IOException exc){
            System.out.println("clearConsole() error: ");
            System.out.println(exc.getMessage());
        }
    }

}
