import java.math.BigInteger;

public abstract class SmallInt {

    // Initialize the integer k.
    int k = 0;

    /**
     * Attempts to set the value of this SmallInt object by parsing an input String.
     * 
     * @param s the input String to be parsed
     * @return <code>-1</code> if the String could not be parsed, or the parsed
     *         integer is either less than <code>Integer.MIN_VALUE</code> or greater
     *         than <code>Integer.MAX_VALUE</code>.
     *         <p><code>0</code> otherwise.
     */
    int setValue(String s) {
        try {
            // Initialize a BigInteger and attempt to parse the String.
            BigInteger bigInt = new BigInteger(s);

            // Check to see if the integer parsed is less than Integer.MIN_VALUE or greater
            // than Integer.MAX_VALUE.
            if (bigInt.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0 || bigInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                // The value is not acceptable, so k = 0.
                k = 0;

                // Return -1 since the value was not acceptable.
                return -1;
            } else {
                // The value is acceptable here, so k = the value of the parsed String.
                k = bigInt.intValue();
            }
        } catch (NumberFormatException e) {
            // The parse to an integer failed, so k = 0.
            k = 0;

            // Return -1 since the parse failed.
            return -1;
        }

        // Return 0 if the program successfully made it here.
        return 0;
    }

    /**
     * Retrieves the value of a SmallInt object.
     * 
     * @return the value of the SmallInt
     */
    int getValue() {
        return k;
    }

    /**
     * Adds the value of this SmallInt with the value of another SmallInt.
     * @param sInt the SmallInt whose value is to be added to the value of this SmallInt
     * @return <code>0</code> if the sum of the two values is either less than <code>Integer.MIN_VALUE</code> or greater than <code>Integer.MAX_VALUE</code>.
     *         <p>Otherwise the sum of the two SmallInt values.
     */
    int add(SmallInt sInt) {
        // Initialize and set sum equal to the sum of the value of this SmallInt and the value of sInt.
        BigInteger sum = BigInteger.valueOf(getValue()).add(BigInteger.valueOf(sInt.getValue()));

        // Check if the sum is less than Integer.MIN_VALUE or greater than Integer.MAX_VALUE.
        if (sum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0 || sum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            // The sum is not acceptable, thus 0 is returned.
            return 0;
        }

        // Since the sum value is acceptable, it is returned.
        return sum.intValue();
    }
}
