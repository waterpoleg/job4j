package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * тест если введеное число не попадает в диапозон
     * */
    @Test
    public void whenInvalidNumber() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"13", "1"}));
        input.ask("Enter", new int[]{1});
        assertThat(this.mem.toString(),
                is(String.format("Несуществующий пункт меню. Введите только цифры [0..6]%n")));
    }

    /**
     * тест если вместо чисел вводим буквы/слова
     * */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"}));
        input.ask("Enter", new int[] {1});
        assertThat(this.mem.toString(),
                is(String.format("Неправильный параметр. Введите только цифры [0..6]%n")));
    }
}