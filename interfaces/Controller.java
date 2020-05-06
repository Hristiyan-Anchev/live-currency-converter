package interfaces;

import java.io.IOException;

public interface Controller {
    String convertCurrency(Double fromAmount, String quotedCurrency, String baseCurrency) throws IOException;
}
