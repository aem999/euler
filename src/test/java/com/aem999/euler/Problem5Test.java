package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem5Test {

    @Test
    public void canSolveProblem() throws Exception {
        assertThat(new Problem5().findAnswer(), is(232792560));
    }

    @Test
    public void canFindSmallestNumberDivisibleByAllIntegers() throws Exception {
        assertThat(new Problem5().findSmallestNumberDivisibleByAllIntegers(1, 10), is(2520));
    }

}
