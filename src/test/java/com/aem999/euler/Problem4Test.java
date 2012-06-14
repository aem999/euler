package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem4Test {

    @Test
    public void canSolveProblem() throws Exception {
        assertThat(new Problem4().findAnswer(), is(906609));
    }

    @Test
    public void canFindLargestPalindrome() {
        assertThat(new Problem4().findLargestPalindrome(2), is(9009));
        assertThat(new Problem4().findLargestPalindrome(3), is(906609));
    }

    @Test
    public void canDetermineIfNumberIsAPalindrome() {
        assertThat(new Problem4().isPalindrome(1), is(true));
        assertThat(new Problem4().isPalindrome(11), is(true));
        assertThat(new Problem4().isPalindrome(12), is(false));
        assertThat(new Problem4().isPalindrome(121), is(true));
    }
}
