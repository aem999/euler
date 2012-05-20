package com.aem999.euler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem1 {
    private static final Logger LOG = LoggerFactory.getLogger(Problem1.class);
    private final int maxNumber;

    public Problem1(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public long solve() {
        long sum = 0;
        for (int i = 3; i < maxNumber; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                LOG.debug("[{}] is a multiple of 3 or 5", i);
            }
        }
        LOG.info("sum=[{}]", sum);
        return sum;
    }
}
