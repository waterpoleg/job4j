package ru.job4j.tracker;
/**
 * @author Олег
 * @since 31.10.2018
 * */

/**
 * внешний класс редактировние элемента
 * */
class EditItem extends BaseAction {
    EditItem(int key, String name) {
        super(key, name);
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
}
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int menuPosition = 0;
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions(StartUI ui) {
        this.actions[menuPosition++] = this.new AddItem(0, "- Новая заявка");
        this.actions[menuPosition++] = new MenuTracker.ShowAll(1, "- Показать все");
        this.actions[menuPosition++] = new EditItem(2, "- Редактировать заявку");
        this.actions[menuPosition++] = new MenuTracker.DeleteItem(3, "- Удалить заявку");
        this.actions[menuPosition++] = new FindItemId(4, "- Поиск по id");
        this.actions[menuPosition++] = new FindItemName(5, "- Поиск по имени");
        this.actions[menuPosition++] = new Exit(6, "- Выход", ui);
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
    private class AddItem extends BaseAction {
        AddItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter name: ");
            String desc = input.ask("Please enter description: ");
            tracker.add(new Item("id", name, desc, 123L));
        }
    }
    /**
     * статический класс Вывод всех элементов
     * */
    private static class ShowAll extends BaseAction {
        ShowAll(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Заявки существующие в системе: --------------");
            for (Item item : tracker.getAll()) {
                System.out.println(
                        String.format("id: %s, name: %s, description: %s", item.getId(), item.getName(), item.getDescription()));
            }
            System.out.println("------------ Завершение вывода всех заявок --------------");
        }
    }
    /**
     * статический класс Удаление элемента
     * */
    private static class DeleteItem extends BaseAction {
        DeleteItem(int key, String name) {
            super(key, name);
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
    }
    /**
     * Поиск по ID
     * */
    private class FindItemId extends BaseAction {
        FindItemId(int key, String name) {
            super(key, name);
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
    }
    /**
     * Посик по имени. Пеачтает все эелеенты, если они с одинаковым имененм
     * */
    private class FindItemName extends BaseAction {
        FindItemName(int key, String name) {
            super(key, name);
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
    }
    private class Exit extends BaseAction {
        Exit(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }
        private final StartUI ui;
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }
}