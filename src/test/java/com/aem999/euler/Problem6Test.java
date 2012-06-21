package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem6Test {
    @Test
    public void findAnswer() {
        assertThat(new Problem6().findAnswer(), is(25164150));
    }

    @Test
    public void canFindDifferenceBetweenSquareOfSumsAndSumOfSquares() {
        assertThat(new Problem6().findDifferenceBetweenSquareOfSumsAndSumOfSquares(10), is(2640));
    }

    @Test
    public void canFindSquareOfSums() {
        assertThat(new Problem6().findSquareOfSums(10), is(3025));
        assertThat(new Problem6().findSquareOfSumsUsingCalculus(10), is(3025));
    }

    @Test
    public void canFindSumOfSquares() throws Exception {
        assertThat(new Problem6().findSumOfSquares(10), is(385));
        assertThat(new Problem6().findSumOfSquaresUsingCalculus(10), is(385));
    }

}
