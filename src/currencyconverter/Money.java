package currencyconverter;

import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Brandon Omar Morales Solís
 */
public class Money {

    //Attributes
    String url;
    double currencyValue;
    Document html;
    Elements article;

    //Constructor method to initialize variables with null values
    public Money() {
        url = "";
        currencyValue = 0;
        html = null;
        article = null;
    }

    //Constructor method whith two attributes
    public Money(String url) {
        this.url = url;
    }

    //Constructor method
    public Money(String url, double currencyValue,
            Document html, Elements article) {
        this.url = url;
        this.currencyValue = currencyValue;
        this.html = html;
        this.article = article;
    }

    public void getHtml() {
        try {
            html = Jsoup.connect(url).userAgent("Mozilla/5.0").
                    timeout(100000).get();

            getCurrencyValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You are not connected "
                    + "to the internet!");
        }

    }

    public double getCurrencyValue() {
        String saveValue = "";
        String saveValue2 = "";
        article = html.getElementsByClass("result"
                + "__BigRate-sc-1bsijpp-1 iGrAod");

        for (Element element : article) {
            saveValue += article.text();
        }

        for (byte i = 0; i < saveValue.length(); i++) {
            if (Character.isDigit(saveValue.charAt(i)) == true
                    || saveValue.charAt(i) == ',') {
                saveValue2 += saveValue.charAt(i);
            }
        }

        saveValue = saveValue2;
        saveValue = saveValue.replaceAll(",", ".");
        return currencyValue = Double.parseDouble(saveValue);
    }

}
