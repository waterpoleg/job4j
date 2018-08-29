package ru.job4j.calculate.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void when6Then1to36() {
        Square square = new Square();
        int[] result = square.calc(6);
        int[] test = {1, 4, 9, 16, 25, 36};
        assertThat(result, is(test));
    }
}