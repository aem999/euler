package com.aem999.euler;

/**
 *
 */
class Problem5 implements EulerProblem<Integer> {
    public Integer findAnswer() {
        return findSmallestNumberDivisibleByAllIntegers(1, 20);
    }

    public Integer findSmallestNumberDivisibleByAllIntegers(int from, int to) {
        Integer result = null;
        int maxProduct = Integer.MAX_VALUE - to + 1;
        for (int i=to; i <= maxProduct; i+=to) {
            if (isDivisibleBy(i, from, to)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private boolean isDivisibleBy(int candidate, int from, int to) {
        for (int i = from; i <= to; i++) {
            if (candidate % i != 0) {
                return false;
            }
        }
        return true;
    }
}
