class Operator {
    private static char value;

    /**
     * Construct Operator
     * @param str String
     */
    Operator(String str) {
        value = str.charAt(0);
    }

    /**
     *
     * @return char
     */
    static char getValue() {
        return value;
    }
}
