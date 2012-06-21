package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem7Test {
    @Test
    public void findAnswer() {
        assertThat(new Problem7().findAnswer(), is(104743));
    }

    @Test
    public void canFindPrime() {
        assertThat(new Problem7().findPrime(1), is(2));
        assertThat(new Problem7().findPrime(10), is(29));
    }

}
