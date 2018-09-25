package ru.job4j.tracker;
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для посика заявки по id.
     */
    private static final String FINDID = "4";
    /**
     * Константа меню для вывода всех заявок с имененм name.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.fingId();
            } else if (FINDNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяе новой заявки в хранилище
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String description = this.input.ask("Введите описание заявки: ");
        long created = System.currentTimeMillis();
        Item item = new Item("id", name, description, created);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId: " + item.getId() + " -----------");
    }
    private void showAll() {
        System.out.println("------------ Заявки существующие в системе: --------------");
        Item[] items = this.tracker.getAll();
        for (Item item: items) {
            System.out.println("id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription());
        }
        System.out.println("------------ Завершение вывода всех заявок --------------");
    }
    private void editItem() {
        System.out.println("------------ Изменение заявки: --------------");
        String id = this.input.ask("Введите id заявки, которую нужно изменить: ");
        if (this.tracker.findById(id) != null) {
            String newName = this.input.ask("Введите новое имя заявки: ");
            String newDescription = this.input.ask("Введите новое описание заявки: ");
            long created = System.currentTimeMillis();
            Item newItem = new Item("id", newName, newDescription, created);
            this.tracker.replace(id, newItem);
            System.out.println("------------ Заявка изменена --------------");
        } else {
            System.out.println("--------- Такого id в системе не существует -----------");
        }
    }
    private void deleteItem() {
        System.out.println("------------ Удаление заявки: --------------");
        String id = this.input.ask("Введите id заявки, которую следует удалить: ");
        if (this.tracker.findById(id) != null) {
            this.tracker.delete(id);
            System.out.println("------------ Заявка " + id + " удалена --------------");
        } else {
            System.out.println("--------- Такого id в системе не существует -----------");
        }
    }
    private void fingId() {
        System.out.println("------------ Поиск заявки по id: --------------");
        String id = this.input.ask("Введите id: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription());
            System.out.println("------------ Заявка --------------");
        } else {
            System.out.println("--------- Такого id в системе не существует -----------");
        }

    }
    private void findName() {
        System.out.println("------------ Поик заявок по именем: --------------");
        String name = this.input.ask("Введите name заявки: ");
        Item[] items = this.tracker.findByName(name);
        if (items != null) {
            for (Item item : items) {
                System.out.println("id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription());
            }
        } else {
            System.out.println("--------- Такого name в системе не существует -----------");
        }
        System.out.println("------------ Завершение вывода заявок --------------");
    }
    private void showMenu() {
        System.out.println("Меню:\n"
                + "0 - Новая заявка\n"
                + "1 - Показать все\n"
                + "2 - Редактировать заявку\n"
                + "3 - Удалить заявку\n"
                + "4 - Поиск по id\n"
                + "5 - Поиск по имени\n"
                + "6 - Выход");
    }
    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}