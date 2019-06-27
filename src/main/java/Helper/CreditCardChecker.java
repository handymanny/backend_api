package Helper;

public class CreditCardChecker {

    private String creditCard;

    public CreditCardChecker(String card) {
        this.creditCard = card;
    }

    // Getters and Setter
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    // Helper methods
    private boolean checkLuhn() {
        // When all of the credit card numbers are added up they should equal (number mod 10) = 0
        int sum = 0;

        // Check through all numbers
        for (int i = 0; i < creditCard.length(); i++) {
            int temp = Integer.valueOf(creditCard.substring(i, i+1));
            sum += temp;
        }

        System.out.println(sum);
        // Return true if mod 10 is 0
        return (sum % 10) == 0;
    }

    public boolean isValidCard() {
        return checkLuhn();
    }

}
