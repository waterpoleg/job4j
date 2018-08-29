package ru.job4j.calculate.array;

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Метод удаляет дубликаты в массиве строк.
     * @param array исходный массив
     * @return массив без дубликатов размером newLength.
     */
    public String[] remove(String[] array) {
        int newLength = array.length;
        for (int i = 0; i != newLength; i++) {
            for (int j = i + 1; j != newLength; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[newLength - 1];
                    newLength--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, newLength);
    }
}