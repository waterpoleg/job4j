package ru.job4j.calculate.condition;

/**
 * @author Oleg
 * @version 07.2018
 * @since 2018
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DummyBotTest {
    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Привет, Бот!"), is("Привет, умник!"));
    }

    @Test
    public void whenByBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Пока!"), is("До скорой встречи!"));
    }

    @Test
    public void whenUnkownBot() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Биткойны есть?"), is("Это ставит меня в тупик. Задайте другой вопрос."));
    }
}