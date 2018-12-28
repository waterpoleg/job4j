package ru.job4j.tracker;
public class StartUI {
    /**
     * Доступный диапозон выбора пользователя
     */
    private int[] ranges = {0, 1, 2, 3, 4, 5, 6};
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Флаг завершения работы программы
     * */
    private boolean isExit = false;
    public void stop() {
        this.isExit = true;
    }
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
        menu.fillActions(this);
        do {
            menu.showMenu();
            menu.select(input.ask("Выбор: ", this.ranges));
        } while (!this.isExit);
    }
    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI(input, tracker).init();
    }
}