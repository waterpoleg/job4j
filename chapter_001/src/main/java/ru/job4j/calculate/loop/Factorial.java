package ru.job4j.calculate.loop;

/**
 * @author Олег
 * @since 07.2018
 */

public class Factorial {

    /**
     * метод расчтывает и возвращает факториал для передаваемого параметра - n
     **/
    public int calc(int n) {
        //инициализируем сразу с минимальным значением = 1, тк даже при n = 0 факториал равен 1
        int calculatedFactorial = 1;
        for (int i = 1; i <= n; i++) {
            calculatedFactorial *= i;
        }
        return calculatedFactorial;
    }
}