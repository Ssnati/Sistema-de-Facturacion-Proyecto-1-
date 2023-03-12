package co.edu.uptc.pojo;

public class EAN13Generator {

    public static String generateBarcode(String manufacturerNumber, String productCode) {
        while (manufacturerNumber.length() < 6) {
            manufacturerNumber = "0" + manufacturerNumber;
        }
        int checkDigit = calculateCheckDigit(manufacturerNumber + productCode);
        return "0" + manufacturerNumber + productCode + checkDigit;
    }

    private static int calculateCheckDigit(String barcode) {
        int sum = 0;
        for (int i = 0; i < barcode.length(); i++) {
            int digit = Character.getNumericValue(barcode.charAt(i));
            sum += i % 2 == 0 ? digit : digit * 3;
        }
        int nextMultipleOf10 = (sum / 10 + 1) * 10;
        return nextMultipleOf10 - sum;
    }
}
