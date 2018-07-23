package ru.job4j.calculate.array;

public class BubbleSort {
    /**
     * Метод пузырьковой сортировки
     * два цикла: внешний - проход по массиву и сокращение его длины на 1 шаг;
     * внутренний  - для перестановки элементов;
     * переменная value - временный буфер
     * */
    public int[] sort(int[] array) {
        int value;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }
            }
        }
        return array;
    }
}