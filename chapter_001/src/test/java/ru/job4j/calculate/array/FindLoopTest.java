package ru.job4j.calculate.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    /**
     * ищем 9, которая стоит во 2 ячейке массива
     */
    @Test
    public void when9Then2() {
        FindLoop f = new FindLoop();
        int[] data = {1, 4, 9, 16, 25, 6};
        int i = f.indexOf(data, 9);
        assertThat(i, is(2));
    }

    /**
     * Если эелемент не найден по условию задачи возвращается значение -1
     */
    @Test
    public void when8ThenMinusOne() {
        FindLoop f = new FindLoop();
        int[] data = {1, 4, 9, 16, 25, 6};
        int i = f.indexOf(data, 8);
        assertThat(i, is(-1));
    }
}