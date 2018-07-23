package ru.job4j.calculate.array;

/**
 * @author Олег
 * @since 23.7.18
 */

public class Turn {
    /**
     * Метод переворота элементов массива
     * переменная value - промежуточный буфер для операции с переворотом массива
     */
    public int[] back(int[] array) {
        int value;
        for (int i = 0; i < array.length / 2; i++) {
            value = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = value;
        }
        return array;
    }
}
