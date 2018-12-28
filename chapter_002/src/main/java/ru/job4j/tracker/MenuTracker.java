package ru.job4j.tracker;
/**
 * @author Олег
 * @since 31.10.2018
 * */

/**
 * внешний класс редактировние элемента
 * */
class EditItem implements UserAction {
    public int key() {
        return 2;
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(String.format("Item %s will be changed", item.getId()));
            String name = input.ask("Please enter NEW name: ");
            String desc = input.ask("Please enter NEW description: ");
            tracker.replace(String.format(item.getId()), new Item("", name, desc, 123L));
        } else {
            System.out.println("Id does not exists. Please try again.");
        }
    }
    public String info() {
        return String.format("%s - %s", this.key(), "Редактировать заявку");
    }
}
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions(StartUI ui) {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAll();
        this.actions[2] = new EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new FindItemId();
        this.actions[5] = new FindItemName();
        this.actions[6] = new Exit(ui);
    }
    /**
     * показать меню
     * */
    public void showMenu() {
        System.out.println("Меню:");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * добавление элемента
     * */
    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter name: ");
            String desc = input.ask("Please enter description: ");
            tracker.add(new Item("id", name, desc, 123L));
        }
        public String info() {
            return String.format("%s - %s", this.key(), "Новая заявка");
        }
    }
    /**
     * статический класс Вывод всех элементов
     * */
    private static class ShowAll implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Заявки существующие в системе: --------------");
            for (Item item : tracker.getAll()) {
                System.out.println(
                        String.format("id: %s, name: %s, description: %s", item.getId(), item.getName(), item.getDescription()));
            }
            System.out.println("------------ Завершение вывода всех заявок --------------");
        }
        public String info() {
            return String.format("%s - %s", this.key(), "Показать все");
        }
    }
    /**
     * статический класс Удаление элемента
     * */
    private static class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(String.format(item.getId()));
                System.out.println(String.format("Item %s deleted", item.getId()));
            } else {
                System.out.println("Id does not exists. Please try again.");
            }
        }
        public String info() {
            return String.format("%s - %s", this.key(), "Удалить заявку");
        }
    }
    /**
     * Поиск по ID
     * */
    private class FindItemId implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(
                        String.format("id: %s, name: %s, description: %s, created: %s",
                                item.getId(), item.getName(), item.getDescription(), item.getCreated()));
            } else {
                System.out.println("Id does not exists. Please try again.");
            }
        }
        public String info() {
            return String.format("%s - %s", this.key(), "Поиск по id");
        }
    }
    /**
     * Посик по имени. Пеачтает все эелеенты, если они с одинаковым имененм
     * */
    private class FindItemName implements UserAction {
        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter Item Name: ");
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                System.out.println("------------ Поиск заявок по имени: --------------");
                for (Item item : items) {
                    System.out.println(
                            String.format("id: %s, name: %s, description: %s",
                                    item.getId(), item.getName(), item.getDescription()));
                }
                System.out.println("------------ Завершение вывода заявок --------------");
            } else {
                System.out.println("Nothing was found.");
            }
        }
        public String info() {
            return String.format("%s - %s", this.key(), "Поиск по имени");
        }
    }
    private class Exit implements UserAction {
        private final StartUI ui;
        Exit(StartUI ui) {
            this.ui = ui;
        }
        public int key() {
            return 6;
        }
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
            //System.out.println("Tracker closed.");
        }
        public String info() {
            return String.format("%s - %s", this.key(), "Выход");
        }
    }
}