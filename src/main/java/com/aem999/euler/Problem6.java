package com.aem999.euler;

/**
 *
 */
public class Problem6 implements EulerProblem<Integer> {

    @Override
    public Integer findAnswer() {
        return findDifferenceBetweenSquareOfSumsAndSumOfSquares(100);
    }

    public Integer findDifferenceBetweenSquareOfSumsAndSumOfSquares(int max) {
        return findSquareOfSumsUsingCalculus(max) - findSumOfSquaresUsingCalculus(max);
    }

    public Integer findSquareOfSums(int max) {
        int result = 0;
        for (int i=1; i <= max; i++) {
            result += i;
        }
        return result * result;
    }

    /**
     * To find the sum of terms of an arithmetic sequence:
     *
     * <pre>
     * S<sub>n</sub> = n(a<sub>1</sub> + a<sub>n</sub>) / 2</pre>
     *
     * where:
     *
     * <pre>
     * S<sub>n</sub> is the sum of n terms (nth partial sum),
     * a<sub>1</sub> is the first term
     * a<sub>n</sub> is the nth term</pre>
     *
     * @return the square of the sum of the terms S<sub>n</sub><sup>2</sup>
     */
    public Integer findSquareOfSumsUsingCalculus(int max) {
        int sum = max * (1 + max) / 2;
        return sum * sum;
    }

    public Integer findSumOfSquares(int max) {
        int result = 0;
        for (int i=1; i <= max; i++) {
            result += i*i;
        }
        return result;
    }

    /**
     * To find the sum of the square of terms of an arithmetic sequence:
     *
     * <pre>
     *
     * S<sub>n</sub><sup>2</sup> = n / 6 (2n + 1)(n + 1)</pre>
     *
     * where:
     *
     * <pre>
     * S<sub>n</sub><sup>2</sup> is the sum of the square of n terms
     *
     * @return the square of the sum of the terms S<sub>n</sub><sup>2</sup>
     */
    public Integer findSumOfSquaresUsingCalculus(int max) {
        int result = 0;
        for (int i=1; i <= max; i++) {
            result += i*i;
        }
        return result;
    }
}
