package ru.job4j.tracker;
import java.util.Scanner;
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String quest) {
        System.out.print(quest);
        return scanner.nextLine();
    }
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            throw new MenuOutException("Неправильный параметр.");
        }
        return key;
    }
}