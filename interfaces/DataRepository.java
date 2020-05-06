package interfaces;

import java.util.Map;

public interface DataRepository {
    void addBaseCurrency(String baseCurrency, Map<String,Double> quotedCurrencies);
    boolean removeBaseCurrency(String baseCurrency);
    Map<String,Map<String,Double>> getUnits();

}
