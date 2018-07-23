package ru.job4j.calculate.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void when2ThenMatrix2x2() {
        Matrix array = new Matrix();
        int[][] data = {{1, 2}, {2, 4}};
        int[][] resultMatrix = array.multiple(2);
        assertThat(resultMatrix, is(data));
    }

    @Test
    public void when4ThenMatrix4x4() {
        Matrix array = new Matrix();
        int[][] data = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        int[][] resultMatrix = array.multiple(4);
        assertThat(resultMatrix, is(data));
    }
}

