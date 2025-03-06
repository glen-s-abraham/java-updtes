package Localisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalisingDates {
    public static void main(String[] args) {
        Locale locUS = Locale.US;
        Locale locFrench = Locale.FRANCE;
        Locale locGerman = Locale.GERMANY;

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dateMediumStyle.withLocale(locUS).format(ldt));
        System.out.println(dateMediumStyle.withLocale(locFrench).format(ldt));

        DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(timeShortStyle.withLocale(locUS).format(ldt));
        System.out.println(timeShortStyle.withLocale(locGerman).format(ldt));

        DateTimeFormatter dateTimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateTimeShortStyle.withLocale(locUS).format(ldt));
        System.out.println(dateTimeShortStyle.withLocale(locFrench).format(ldt));

    }
}
