package ru.job4j.calculate.condition;

/**
 *@author Олег
 *@version 07.2018
 *@since 2018
 */
public class DummyBot {
    public String answer(String question) {
        String reply = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот!".equals(question)) {
            reply = "Привет, умник!";
        } else if ("Пока!".equals(question)) {
            reply = "До скорой встречи!";
        }
        return reply;
    }
}