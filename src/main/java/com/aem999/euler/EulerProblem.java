package com.aem999.euler;

/**
 * A project <a href="http://projecteuler.net">Euler</a> problem.
 * @param <T> the answer type
 */
public interface EulerProblem<T> {

    /**
     * Solve the problem and return the answer
     */
    T findAnswer();
}
