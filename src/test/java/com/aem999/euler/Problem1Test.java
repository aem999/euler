package com.aem999.euler;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Problem1Test {

    @Test
    public void solveProblem() {
        assertThat(new Problem1(10).solve(), is(3+5+6+9L));
        assertThat(new Problem1(1000).solve(), is(233168L));
    }

}
