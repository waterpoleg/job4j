package ru.job4j.calculate.loop;
/**
 * @author Олег
 * @since 07.2018
 */
public class Factorial {
    /**
     * метод расчтывает и возвращает факториал для передаваемого параметра - n
     * инициализируем сразу с минимальным значением = 1, тк даже при n = 0 факториал равен 1
     **/
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}