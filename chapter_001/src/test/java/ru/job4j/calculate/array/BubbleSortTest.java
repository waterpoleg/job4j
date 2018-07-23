package ru.job4j.calculate.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void whenSortByBubbleThenSortedArray() {
        BubbleSort array = new BubbleSort();

        /**
         * массив для сортировки
         */
        int[] data = {8, 3, 10, 7, 1, 5, 4, 9, 2, 6};

        /**
         * сортируем
         */
        int[] resultArray = array.sort(data);
        /**
         * ожидаемый результат - отсортированный масссив
         */
        int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        /**
         * првоеряем
         */
        assertThat(resultArray, is(expectArray));
    }
}

