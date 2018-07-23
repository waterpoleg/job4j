package ru.job4j.calculate.array;

public class Check {
    /**
     * если массив заполнен только true или только false, вывести true, иначе false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
