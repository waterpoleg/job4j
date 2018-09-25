package ru.job4j.tracker;
import java.util.Scanner;
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String quest) {
        System.out.print(quest);
        return scanner.next();
    }
}