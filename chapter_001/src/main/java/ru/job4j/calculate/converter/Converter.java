package ru.job4j.calculate.converter;
/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Currency rates
     */
    static final double EUR = 70;
    static final double USD = 60;

    /**
     * Конвертируем рубли в евро.
     * манипуляции с 100d - для отображения только 2-х знаков после запятой
     * @param value рубли.
     * @return Евро.
     */
    public double rubleToEuro(double value) {
        return Math.round(value / EUR * 100d) / 100d;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public double rubleToDollar(double value) {
        return Math.round(value / USD * 100d) / 100d;
    }

    /**
     * From EUR to RUB
     * @param value евро
     * @return рубли
     */
    public double euroToRuble(double value) {
        return Math.round(value * EUR * 100d) / 100d;
    }

    /**
     * from USD to RUB
     * @param value доллары
     * @return рубли
     */
    public double dollarToRuble(double value) {
        return Math.round(value * USD * 100d) / 100d;
    }
}
