package currency.converter;  // diperbaiki sesuai regex naming convention

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Converter {

    private String name;
    private String shortName;
    private Map<String, Double> exchangeValues;

    public Converter(String name) {
        this.name = name;
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
                exchangeValues.put("JPY", 129.53);
                break;
            // Default case ditambahkan untuk menghindari bug maintainability
            default:
                exchangeValues.put("USD", 1.0);
                exchangeValues.put("EUR", 1.0);
                exchangeValues.put("JPY", 1.0);
                break;
        }
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Map<String, Double> getExchangeValues() {
        return exchangeValues;
    }

    public static List<Currency> init() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("Dollar", "USD"));
        currencies.add(new Currency("Euro", "EUR"));
        currencies.add(new Currency("Yen", "JPY"));
        return currencies;
    }
}

class Currency {
    private String name;
    private String shortName;

    public Currency(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }
}
