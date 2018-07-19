package ru.job4j.calculate.loop;

/**
 * @author Oleg
 * @since  07.2018
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * тест вычисления суммы всех четных чисел в диапазоне от 1 до 10
 */
public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}
