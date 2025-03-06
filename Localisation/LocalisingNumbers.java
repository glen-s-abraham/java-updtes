package Localisation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class LocalisingNumbers {
    public static void main(String[] args) {
        formatNumbers();
        formatCurrencies();
        parseNumbers();
        parseCurrencies();
        customFormat();
    }

    public static void formatNumbers() {
        double n = 77_000.11;
        System.out.println(NumberFormat.getInstance().format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).format(n));
    }

    public static void formatCurrencies() {
        double n = 23.22;
        System.out.println(NumberFormat.getCurrencyInstance().format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(n));
    }

    public static void parseNumbers() {
        String unitedStatesNumber = "77,000.11", italianNumber = "77,000,11", frenchNumber = "77 000,11";
        try {
            System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber));
            System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
            System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void parseCurrencies() {
        String irishCurrency = "£23.22", unitedStatesCurrency = "$23.22", italianCurrecy = "£23.22",
                uniteKingdomCurrency = "£23.22";
        try {
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(unitedStatesCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).parse(italianCurrecy));
            System.out.println(NumberFormat.getCurrencyInstance().parse(irishCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(uniteKingdomCurrency));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void customFormat(){
        double n = 77_000.17;

        System.out.println(new DecimalFormat("£#,###,###.#").format(n));
        System.out.println(new DecimalFormat("£0,000,000.00").format(n));
    }

}