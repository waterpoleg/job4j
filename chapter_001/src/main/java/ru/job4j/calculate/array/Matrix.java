package ru.job4j.calculate.array;
/**
 * Матрица
 * массив заполненный элементами - перемноженными индексами
 */
public class Matrix {
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                result[i - 1][j - 1] = i * j;
            }
        }
        return result;
    }
}
