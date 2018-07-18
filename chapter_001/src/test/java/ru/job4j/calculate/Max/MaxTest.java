package ru.job4j.calculate.Max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author Олег
 *@since 2018
 */
public class MaxTest {

    /**
     * тестируем при условии что первое число больше второго
     */
    @Test
    public void whenFirstMoreSecondThen() {
        Max maxim = new Max();
        int result = maxim.max(9, 3);
        assertThat(result, is(9));
    }

    /**
     * тестируем при условии что first меньше чем second
     */
    @Test
    public void whenFirstLessSecondThen() {
        Max less = new Max();
        int result = less.max(2, 5);
        assertThat(result, is(5));
    }

    /**
     * тестируем при условии что числа равны
     */
    @Test
    public void whenFirstEqualSecondThen() {
        Max equal = new Max();
        int result = equal.max(3, 3);
        assertThat(result, is(3));
    }

    /**
     * если первое число (first) большее
     */
    @Test
    public void whenFirstMoreSecondAndThirdThen() {
        Max max3 = new Max();
        int result = max3.maxOfThree(6, 1, 3);
        assertThat(result, is(6));
    }

    /**
     * если второе число (second) большее
     */
    @Test
    public void whenSecondMoreFirstAndThirdThen() {
        Max max3 = new Max();
        int result = max3.maxOfThree(3, 10, 3);
        assertThat(result, is(10));
    }

    /**
     * если третье число (third) большее
     */
    @Test
    public void whenThirdMoreFirstAndSecondThen() {
        Max max3 = new Max();
        int result = max3.maxOfThree(7, 33, 125);
        assertThat(result, is(125));
    }
}