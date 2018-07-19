package ru.job4j.calculate.loop;

/**
 * @author Олег
 * @since 07.2018
 */
public class Counter {

    /**
     * @param start
     * @param finish
     * @return sum  - сумма четных чисел от start до finish
     * проверка четное ли число - нет остатка деления на 2
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if ((i % 2) == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
