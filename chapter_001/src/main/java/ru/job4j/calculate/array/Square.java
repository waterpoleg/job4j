package ru.job4j.calculate.array;

public class Square {
    /**
     * Метод заполняет массив числами от 1 до bound (включительно)
     *
     * можно сделать через Math.pow((i+1), 2), и привести к int,
     * тк Math.pow возвращает double
     * (i+1 тк индекс массива начинается с 0, а считать нужно с 1)
     */
    public int[] calc(int bound) {
        int[] result = new int[bound];
        for (int i = 0; i < bound; i++) {
            result[i] = (i + 1) * (i + 1);
        }
        return result;
    }
}