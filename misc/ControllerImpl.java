package misc;

import entities.DataRepositoryImpl;
import interfaces.Connection;
import interfaces.Controller;
import interfaces.DataRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerImpl implements Controller {
    Connection connection;
    DataRepository dataRepository;

    public ControllerImpl(Connection connection,DataRepository dataRepository) {
        this.connection = connection;
        this.dataRepository = dataRepository;
    }

    @Override
    public String convertCurrency(Double fromAmount, String quotedCurrency, String baseCurrency) throws IOException {
        Map<String,Double> currencyConversions = dataRepository.getUnits().get(quotedCurrency);

        if(currencyConversions == null){
            currencyConversions = new HashMap<String,Double>();
        //
            connection.establishConnectionToDestination(quotedCurrency);
            String jsonResponse = readConnectionResponse(connection);

            parseResponse(jsonResponse,currencyConversions);



            this.dataRepository.addBaseCurrency(quotedCurrency,currencyConversions);

//            System.out.println();
            connection.closeConnection();
        }

        Double conversionResult =  currencyConversions.get(baseCurrency) * fromAmount;

        return String.format("%.2f %s = %.4f %s%n",fromAmount,quotedCurrency,conversionResult,baseCurrency);
    }

    private void parseResponse(String jsonResponse, Map<String, Double> currencyConversions) {
        Pattern currencyRegex = Pattern.compile("\"(?<currencyName>[A-Z]+)\":(?<currencyExchange>[\\d.]+),?");
        Matcher matcher = currencyRegex.matcher(jsonResponse);

        while(matcher.find()){
            String currencyName = matcher.group("currencyName");
            Double currencyExchange = Double.parseDouble(matcher.group("currencyExchange"));
            currencyConversions.put(currencyName,currencyExchange);
        }


    }

//    public static void main(String[] args) throws IOException {
//        ControllerImpl controller = new ControllerImpl(new ConnectionImpl(), new DataRepositoryImpl());
//
//        System.out.println(controller.convertCurrency(1., "BGN", "EUR"));
//        System.out.println(controller.convertCurrency(1., "EUR", "BGN"));
//        System.out.println(controller.convertCurrency(1., "USD", "EUR"));
//        System.out.println(controller.convertCurrency(1., "EUR", "USD"));
//
//
//    }


    private String readConnectionResponse(Connection connection) throws IOException {
        BufferedReader inputData = new BufferedReader(new InputStreamReader(connection.getConnection().getInputStream()));
        StringBuilder sb = new StringBuilder();
        String tempInputLine;

        while ((tempInputLine = inputData.readLine()) != null) {
            sb.append(tempInputLine);
        }

        return sb.toString();
    }


}


