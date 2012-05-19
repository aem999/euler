package com.aem999.euler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Character.getNumericValue;

public class Problem8 {
    private static final Logger LOG = LoggerFactory.getLogger(Problem8.class);
    private static int PRODUCT_SIZE = 5;

    private final String input;


    public Problem8(String input) {
        this.input = input;
    }

    public int findAnswer() {
        char[] chars = input.toCharArray();
        if (chars.length <= PRODUCT_SIZE) {
            return Integer.parseInt(input);
        }

        int largestProduct = 0;

        for (int i=PRODUCT_SIZE-1; i < chars.length; i++) {
            int product = getNumericValue(chars[i]) *
                          getNumericValue(chars[i-1]) *
                          getNumericValue(chars[i-2]) *
                          getNumericValue(chars[i-3]) *
                          getNumericValue(chars[i-4]);
            if (product > largestProduct) {
                largestProduct = product;
                LOG.debug("Found new largest product [{}] for digits [{}]", product, input.substring(i-PRODUCT_SIZE+1, i+1));
            }
        }

        return largestProduct;
    }
}
