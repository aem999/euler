package com.aem999.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* Find the 10001st prime number.
*/
public class Problem7 implements EulerProblem<Integer> {
    public Integer findAnswer() {
        return findPrime(10001);
    }

    public Integer findPrime(int instance) {
        return findPrimes(1000000).get(instance-1);
    }

    private List<Integer> findPrimes(int maxValue) {
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
}
