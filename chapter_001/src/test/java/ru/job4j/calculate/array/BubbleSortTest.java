package ru.job4j.calculate.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortByBubbleThenSortedArray() {
        BubbleSort array = new BubbleSort();
        int[] data = {8, 3, 10, 7, 1, 5, 4, 9, 2, 6};
        int[] resultArray = array.sort(data);
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(resultArray, is(expectedArray));
    }
}

