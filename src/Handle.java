import exception.LimitNumbersException;
import java.util.List;

class Handle {

    private static final int LIMIT = 10;

    /**
     *
     * @param input String
     * @return String
     */
    static String request(String input) throws LimitNumbersException {

        boolean flag = false;
        List data = SplitString.split(input);
        new Operator((String) data.get(1));
        data.remove(1); // delete operator

        // Init numbers
        int firstNumber = 0, secondNumber = 0;

        if(isNumber((String) data.get(0)) && isNumber((String) data.get(1))) {
            firstNumber = Integer.parseInt((String) data.get(0));
            secondNumber = Integer.parseInt((String) data.get(1));
        } else {
            // Romans numerals
            firstNumber = RomanNumeral.romanToArabic((String) data.get(0));
            secondNumber = RomanNumeral.romanToArabic((String) data.get(1));
            flag = true;
        }
        // Limit numbers
        if (firstNumber > LIMIT || secondNumber > LIMIT)
            throw new LimitNumbersException("Enter only numbers from 1 to " + LIMIT + " inclusive. You entered: " + input);

        return switcher(firstNumber, secondNumber, flag);
    }

    /**
     *
     * @param firstNumber int
     * @param secondNumber int
     * @param flag boolean
     * @return String
     */
    private static String switcher(int firstNumber, int secondNumber, boolean flag){
        int total = 0;
        switch (Operator.getValue()) {
            case '+' :
                total = Calc.add(firstNumber, secondNumber);
                break;
            case '-' :
                total = Calc.subtract(firstNumber, secondNumber);
                break;
            case '*' :
                total = Calc.multiply(firstNumber, secondNumber);
                break;
            case '/' :
                total = Calc.divide(firstNumber, secondNumber);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Operator.getValue());
        }

        return flag ? RomanNumeral.arabicToRoman(total) : String.valueOf(total);
    }

    /**
     *
     * @param str String
     * @return boolean
     */
    private static boolean isNumber(String str)
    {
        return str != null && str.matches("^[0-9]+$");
    }
}
