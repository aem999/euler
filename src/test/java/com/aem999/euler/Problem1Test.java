package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem1Test {

    @Test
    public void solveProblem() {
        assertThat(new Problem1().solve(10), is(3+5+6+9L));
        assertThat(new Problem1().solve(1000), is(233168L));
    }

    @Test
    public void solveProblemUsingCalculus() {
        assertThat(new Problem1().solveUsingCalculus(10), is(3+5+6+9L));
        assertThat(new Problem1().solveUsingCalculus(1000), is(233168L));
    }

    @Test
    public void canFindLastTermInAnArithmeticSequence() {
        assertThat(new Problem1().findLastTerm(3, 10), is(9));
        assertThat(new Problem1().findLastTerm(3, 1000), is(999));
        assertThat(new Problem1().findLastTerm(5, 1000), is(995));
    }

    @Test
    public void canFindSumOfTermsInAnArithmeticSequence() {
        assertThat(new Problem1().findSumOfTerms(3, 9, 3), is(18L));
        assertThat(new Problem1().findSumOfTerms(3, 999, 333), is(166833L));
    }

    @Test
    public void canFindNumberOfTermsInAnArithmeticSequence() {
        assertThat(new Problem1().findNumberOfTerms(3, 10, 3), is(3));
        assertThat(new Problem1().findNumberOfTerms(3, 999, 3), is(333));
    }

}
