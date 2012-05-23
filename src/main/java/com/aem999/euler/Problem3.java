package com.aem999.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The prime factors of 13195 are:
 *
 * <pre>5, 7, 13 and 29</pre>
 *
 * Find the largest prime factor of the number 600851475143.
 */
public class Problem3 implements EulerProblem<Integer> {
    private static final Logger LOG = LoggerFactory.getLogger(Problem3.class);

    @Override
    public Integer findAnswer() {
        List<Integer> primeFactors = findPrimeFactorsUsingOptimizedAlgorithm(600851475143L);
        return primeFactors.get(primeFactors.size()-1);
    }

    /**
     * Finds the prime factors of the supplied number
     */
    public List<Integer> findPrimeFactors(long number) {
        long start = System.nanoTime();

        List<Integer> primeFactors = new ArrayList<>();
        long n = number;

        for (int d=2; d < n; d++) {
            while (n % d == 0) {
                primeFactors.add(d);
                n /= d;
            }
        }

        assert n <= Integer.MAX_VALUE;
        primeFactors.add((int) n);

        String duration = String.format("%.2f", (System.nanoTime() - start) / 1000000.0);
        LOG.debug("Found prime factors for [{}] in [{}ms]: {}", new Object[]{number, duration, primeFactors});
        return primeFactors;
    }

    /**
     * Finds the prime factors of the supplied number using an optimized algorithm:
     * <p>
     * By ignoring prime factor 2, we know that the prime factors will be odd and so can start the loop at 3 and
     * increment by 2 instead of 1.</p>
     * <p>
     * The outer loop finds the first prime factor, and as we know that there can be at most one prime factor greater
     * than the square root of the number, then we can stop this loop when the divisor reaches the square root of the
     * number.</p>
     */
    public List<Integer> findPrimeFactorsUsingOptimizedAlgorithm(long number) {
        long start = System.nanoTime();

        List<Integer> primeFactors = new ArrayList<>();
        long n = number;

        for (int d=3; d*d < n; d+=2) {
            while (n % d == 0) {
                primeFactors.add(d);
                n /= d;
            }
        }

        assert n <= Integer.MAX_VALUE;
        primeFactors.add((int) n);

        String duration = String.format("%.2f", (System.nanoTime() - start) / 1000000.0);
        LOG.debug("Found prime factors for [{}] using optimized algorithm in [{}ms]: {}", new Object[]{number, duration, primeFactors});
        return primeFactors;
    }

    /**
     * Finds prime numbers from 2 to {@code maxValue}
     */
    public List<Integer> findPrimes(int maxValue) {
        int arraySize = maxValue + 1;
        boolean[] primeCandidates = new boolean[arraySize];
        Arrays.fill(primeCandidates, true);

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < arraySize; i++) {
            for (int j = i + i; j < arraySize; j+=i) {
                primeCandidates[j] = false;
            }
            if (primeCandidates[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Integer answer = new Problem3().findAnswer();
        LOG.info("The answer is {}", answer);
    }
}
