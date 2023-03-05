/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import javax.swing.JOptionPane;

/**
 *
 * @author brand
 */
public class CurrencyConverter {

    //Attributes
    private static double localMoney;
    private static String conversionsMenu[];
    private static String acronym[];
    private static String moneys[];
    private static double saveConversion;

    public static void main(String[] args) {
        localMoney = 0;
        saveConversion = 0;

        String countries[] = {"Currency converter",
            "Decimal to Binary Converter"};

        do {
            executeOperation(showMenu(countries));
            int exit = JOptionPane.showConfirmDialog(null, "Do you "
                    + "want to continue living?");

            if (exit == 1) {
                System.exit(0);
            }

        } while (true);

    }

    public static String showMenu(String countries[]) {
        String choose = "";

        do {
            choose = (String) (JOptionPane.showInputDialog(null, "Select a "
                    + "conversion  option: ", "Menu",
                    JOptionPane.QUESTION_MESSAGE, null, countries,
                    countries[0]));

            if (choose != null) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Error do not select "
                        + "an option please select an option!");
            }

        } while (true);

        return choose;
    }

    public static String chooseLocalCurrency() {
        String money = "";
        moneys = new String[]{
            "Argentine peso",
            "Chilean peso",
            "Colombian peso",
            "Mexican peso",
            "Costa Rican Colon",
            "Salvadoran Colon",
            "Guatemalan Quetzal",
            "Honduran Lempira",
            "Panamanian balboa",
            "Peruvian sol",
            "American dollar"};

        acronym = new String[]{
            "ARS",//0
            "CLP",//1
            "COP",//2
            "MXN",
            "CRC",//3
            "SVC",//4
            "GTQ",//5
            "HNL",//6
            "PAB",//7
            "PEN",//8
            "USD",//9
        };

        do {
            if (money.equals("")) {
                money = (String) (JOptionPane.showInputDialog(
                        null, "Select your local currency: ",
                        "Menu", JOptionPane.QUESTION_MESSAGE,
                        null, moneys, moneys[0]));
            }

            if (money != null) {
                try {
                    localMoney = Double.parseDouble(JOptionPane.showInputDialog(
                            "Enter the amount of " + money + " to convert: "));
                    break;
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Error did not "
                            + "enter any valid value of your local "
                            + "currency to convert!");
                }
            } else {
                money = "";
                JOptionPane.showMessageDialog(null, "Error did not enter "
                        + "any valid value of your local currency to "
                        + "convert");
            }

        } while (true);

        return money;
    }

    public static void executeOperation(String option) {
        switch (option) {
            case "Currency converter":
                do {
                    String localMoney = chooseLocalCurrency();

                    do {

                        currencyConversionMenu(localMoney);

                        int exit = JOptionPane.
                                showInternalConfirmDialog(null,
                                        "Do you want to continue "
                                        + "converting your "
                                        + "currency to another "
                                        + "type of currency?");

                        if (exit == 1) {
                            break;
                        }
                    } while (true);

                    int exit = JOptionPane.showConfirmDialog(null,
                            "Do you want to continue "
                            + "converting currencies?");

                    if (exit == 1) {
                        break;
                    }

                } while (true);

                break;
            case "Decimal to Binary Converter":

                do {
                    try {
                        int decimal = Integer.parseInt(
                                JOptionPane.showInputDialog("Enter the decimal "
                                        + "number you want to convert to a "
                                        + "binary number: "));

                        JOptionPane.showMessageDialog(null, "The number "
                                + decimal + " to binary is: "
                                + convertDecimalToBinario(decimal));
                        break;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error no "
                                + "digit any number please re-enter a "
                                + "number!");
                    }

                } while (true);

        }
    }

    public static void currencyConversionMenu(String coin) {
        conversionsMenu = new String[]{
            "Convert from " + coin + " to Dollar",
            "Convert from " + coin + " to Euros",
            "Convert from " + coin + " to Pounds Sterling",
            "Convert from " + coin + " to Japanese Yen",
            "Convert from " + coin + " to South Korean Won",
            "Convert from Dollar to " + coin,
            "Convert from Euros to " + coin,
            "Convert from Pounds Sterling to " + coin,
            "Convert Japanese Yen to " + coin,
            "Convert from South Korean Won to " + coin};

        String saveMovement = (String) (JOptionPane.showInputDialog(
                null, "Choose the currency you want to convert "
                + "money to", "Coins", JOptionPane.QUESTION_MESSAGE,
                null, conversionsMenu, conversionsMenu[0]));

        convertCurrency(saerchIndex(conversionsMenu, saveMovement),
                coin);
    }

    public static void convertCurrency(byte index, String coin) {
        byte index2 = saerchIndex(moneys, coin);;

        switch (index) {

            case 0:
                if (getCurrencyValue(
                        "USD", acronym[index2]).html != null) {

                    convertByDividing(
                            getCurrencyValue("USD", acronym[index2]));
                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " " + coin + " to "
                            + "Dollar is: " + saveConversion
                            + " dollars");
                }

                break;

            case 1:
                if (getCurrencyValue("EUR",
                        acronym[index2]).html != null) {

                    convertByDividing(
                            getCurrencyValue("EUR", acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " " + coin + " to "
                            + "Euros is: " + saveConversion + " Euros");
                }

                break;

            case 2:
                if (getCurrencyValue("GBP",
                        acronym[index2]).html != null) {

                    convertByDividing(getCurrencyValue("GBP",
                            acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The " + localMoney + " "
                            + coin + " to Pounds Sterling is: "
                            + saveConversion + " Pounds Sterling");
                }

                break;

            case 3:

                if (getCurrencyValue("JPY",
                        acronym[index2]).html != null) {

                    convertByDividing(getCurrencyValue("JPY",
                            acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " " + coin + " to "
                            + "Japanese Yen is: " + saveConversion
                            + " Japanese Yen ");
                }

                break;

            case 4:
                if (getCurrencyValue("KRW",
                        acronym[index2]).html != null) {

                    convertByDividing(getCurrencyValue("KRW",
                            acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " " + coin + " to "
                            + "South Korean Won is: " + saveConversion
                            + " South Korean Won ");
                }

                break;

            case 5:
                if (getCurrencyValue(
                        "USD", acronym[index2]).html != null) {

                    convertMultiplying(getCurrencyValue(
                            "USD", acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " " + "Dollars to "
                            + coin + " are: " + saveConversion + " " + coin);
                }

                break;

            case 6:
                if (getCurrencyValue(
                        "EUR", acronym[index2]).html != null) {

                    convertMultiplying(getCurrencyValue(
                            "EUR", acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " "
                            + "Euros to " + coin + " are: "
                            + saveConversion + " " + coin);
                }
                break;

            case 7:
                if (getCurrencyValue(
                        "GBP", acronym[index2]).html != null) {

                    convertMultiplying(getCurrencyValue(
                            "GBP", acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The " + localMoney
                            + " " + "Pounds Sterling to " + coin + " are: "
                            + saveConversion + " " + coin);
                }
                break;

            case 8:
                if (getCurrencyValue(
                        "JPY", acronym[index2]).html != null) {

                    convertMultiplying(getCurrencyValue(
                            "JPY", acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney + " " + "Japanese Yen to "
                            + coin + " are: " + saveConversion + " " + coin);
                }

                break;

            case 9:
                if (getCurrencyValue(
                        "KRW", acronym[index2]).html != null) {

                    convertMultiplying(getCurrencyValue(
                            "KRW", acronym[index2]));

                    JOptionPane.showMessageDialog(null, "The "
                            + localMoney
                            + " " + "South Korean Won " + coin + " are: "
                            + saveConversion + " " + coin);
                }

                break;
        }
    }

    public static void convertByDividing(Money getValue) {
        saveConversion = localMoney / getValue.
                getCurrencyValue();

        if (Math.round(saveConversion) != 0) {
            saveConversion = Math.round(saveConversion);
        }
    }

    public static void convertMultiplying(Money getValue) {
        saveConversion = localMoney * getValue.
                getCurrencyValue();

        if (Math.round(saveConversion) != 0) {
            saveConversion = Math.round(saveConversion);
        }
    }

    public static Money getCurrencyValue(String money, String money2) {
        Money getValue = new Money("https://www.xe.com/es/"
                + "currencyconverter/convert/"
                + "?Amount=1&From="
                + money + "&To=" + money2);

        getValue.getHtml();
        return getValue;
    }

    public static String convertDecimalToBinario(int decimal) {
        String binary = "";
        int division = 0;
        byte count = 0;

        for (;;) {
            count++;
            division = decimal / 2;
            binary += decimal % 2;
            decimal = division;

            if (count == 4) {
                count = 0;
                binary += " ";
            }
            if (division == 0) {
                break;
            }
        }

        binary = format(flipBinaryNumber(binary));
        return binary;
    }

    public static String flipBinaryNumber(String binaryNumber) {
        String flip = "";

        for (int i = (binaryNumber.length() - 1); i >= 0; i--) {
            flip += binaryNumber.charAt(i);
        }
        return flip;
    }

    public static String format(String binaryNumber) {
        String space = "";
        String zeros = "";
        byte count = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (Character.isDigit(binaryNumber.charAt(i)) == true) {
                count++;
            } else {
                break;
            }
        }

        if (count != 0) {
            for (int j = 0; j < 4 - count; j++) {
                zeros += "0";
            }
        }

        space = zeros + binaryNumber;

        return space;
    }

    public static byte saerchIndex(String list[], String element) {
        for (byte i = 0; i < list.length; i++) {
            if (list[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

}
