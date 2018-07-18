package ru.job4j.calculate.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when1000RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(1000);
        assertThat(result, is(14.29));
    }

    @Test
    public void when1000RubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(1000);
        assertThat(result, is(16.67));
    }

    @Test
    public void when100EuroToRubleThen1() {
        Converter converter = new Converter();
        double result = converter.euroToRuble(100);
        assertThat(result, is(7000.0));
    }

    @Test
    public void when100DollarToRubleThen1() {
        Converter converter = new Converter();
        double result = converter.dollarToRuble(100);
        assertThat(result, is(6000.0));
    }
}
