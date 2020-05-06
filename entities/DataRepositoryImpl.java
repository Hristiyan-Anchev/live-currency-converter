package entities;

import interfaces.DataRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataRepositoryImpl implements DataRepository {

    private Map<String, Map<String,Double>> baseCurrencies;

    public DataRepositoryImpl(){
        this.baseCurrencies  = new HashMap<>();
    }

    public void addBaseCurrency(String baseCurrency, Map<String,Double> quotedCurrencies){
        this.baseCurrencies.put(baseCurrency,quotedCurrencies);
    }

    public boolean removeBaseCurrency(String baseCurrency){
        return  this.baseCurrencies.remove(baseCurrency) == null;
    }

    public Map<String,Map<String,Double>> getUnits(){
        return Collections.unmodifiableMap(this.baseCurrencies);
    }


}
