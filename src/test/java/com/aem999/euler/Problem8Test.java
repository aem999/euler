package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem8Test {

    @Test
    public void canSolveProblem() throws Exception {
        assertThat(new Problem8().findAnswer(), is(40824));
    }

    @Test
    public void canFindLargestProduct() {
        assertThat(new Problem8().findLargestProduct("1", 5), is(1));
        assertThat(new Problem8().findLargestProduct("12", 5), is(12));
        assertThat(new Problem8().findLargestProduct("123", 5), is(123));
        assertThat(new Problem8().findLargestProduct("1234", 5), is(1234));
        assertThat(new Problem8().findLargestProduct("12345", 5), is(12345));
        assertThat(new Problem8().findLargestProduct("123456", 5), is(2*3*4*5*6));
    }

}

