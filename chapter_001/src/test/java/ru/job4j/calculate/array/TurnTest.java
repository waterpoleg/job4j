package ru.job4j.calculate.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Олег
 * @since 23.7.18
 */

public class TurnTest {
    /**
     * четное число элементов в массиве
     */
    @Test
    public void whenTurnEvenArrayThenBackwardArray() {
        Turn array = new Turn();
        int[] data = {1, 2, 3, 4, 5, 6};
        int[] resultArray = array.back(data);
        int[] expectArray = {6, 5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }

    /**
     * нечетное число элементов
     */
    @Test
    public void whenTrunOddArrayThenBackwardArray() {
        Turn array = new Turn();
        int[] data = {1, 2, 3, 4, 5};
        int[] resultArray = array.back(data);
        int[] expectArray = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }
}
