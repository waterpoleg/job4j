package ru.job4j.tracker;
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int key;
        do {
            menu.showMenu();
            key = Integer.valueOf(input.ask("Выбор: "));
            menu.select(key);
        } while (key != 6);
    }
    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI(input, tracker).init();
    }
}