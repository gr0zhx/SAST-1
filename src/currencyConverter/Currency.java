package currencyconverter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Currency {
    private String name;
    private String shortName;
    private Map<String, Double> exchangeValues;

    public Currency(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
        this.exchangeValues = new HashMap<>();
        defaultValues();
    }

    public void defaultValues() {
        String currency = this.name;
        switch (currency) {
            case "USD":
                exchangeValues.put("EUR", 0.85);
                exchangeValues.put("JPY", 110.0);
                break;
            case "EUR":
                exchangeValues.put("USD", 1.18);
                exchangeValues.put("JPY", 129.0);
                break;
            case "JPY":
                exchangeValues.put("USD", 0.0091);
                exchangeValues.put("EUR", 0.0078);
                break;
            default:
                // Default case to ensure maintainability
                exchangeValues.put("USD", 1.0);
                break;
        }
    }

    public static List<Currency> init() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD", "US Dollar"));
        currencies.add(new Currency("EUR", "Euro"));
        currencies.add(new Currency("JPY", "Japanese Yen"));
        return currencies;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Map<String, Double> getExchangeValues() {
        return exchangeValues;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }
}
