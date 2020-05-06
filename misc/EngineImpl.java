package misc;


import entities.MenuLayout;
import interfaces.Controller;
import interfaces.Engine;

import java.io.IOException;
import java.util.Scanner;

public class EngineImpl implements Engine {
    Scanner scn;
    Controller controller;
//    DataRepository dataRepository;
//    Connection connection;


    public EngineImpl(Controller controller){
        this.controller = controller;
        this.scn = new Scanner(System.in);
    }


    @Override
    public void run() {
        String userChoice = null;

        while(true){
            System.out.println(MenuLayout.mainMenuLayout());
            userChoice = scn.nextLine();
            String result = "";

            try {
                result = processUserInput(userChoice);

                if (result.equals("Exit")) {
                    break;
                }
            }catch (Exception e){
                result = e.getMessage();
                e.printStackTrace();
            }

            System.out.println(result);
        }

    }

    private String processUserInput(String userChoice) throws IOException {

            String result = null;

            switch (userChoice){
                case "1" : {
                    System.out.println(MenuLayout.convertMenu());
                    String[] tokens = scn.nextLine().split("\\s+");
                    Double amount = Double.parseDouble(tokens[0]);
                    String quotedCurrency = tokens[1];
                    String baseCurrency = tokens[2];

                    result = controller.convertCurrency(amount,quotedCurrency,baseCurrency);
                } break;

                default: result = "Exit";
            }

            return result;
        }



}
