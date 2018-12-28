package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    private final Input input;
    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Неправильный параметр. Введите только цифры [0..6]");
            } catch (MenuOutException moe) {
                System.out.println("Несуществующий пункт меню. Введите только цифры [0..6]");
            }
        } while (invalid);
        return value;
    }
}