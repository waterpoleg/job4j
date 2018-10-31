package ru.job4j.tracker;

/**
 *@author Oleg
 * @since 14.10.18
 *
 * */
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    String menu = "Меню:" + System.lineSeparator()
            + "0 - Новая заявка" + System.lineSeparator()
            + "1 - Показать все" + System.lineSeparator()
            + "2 - Редактировать заявку" + System.lineSeparator()
            + "3 - Удалить заявку" + System.lineSeparator()
            + "4 - Поиск по id" + System.lineSeparator()
            + "5 - Поиск по имени" + System.lineSeparator()
            + "6 - Выход";
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOut() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    /**
     * тест добавления новой заявки (команда в меню - 0)
     * */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithThatName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "first name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("first name"));
    }

    /**
     * метод теста редактирования элемента (команда в меню - 2)
     * */
    @Test
    public void whenEditThenTrackerHasEditedItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("id", "name", "desc", 123L);
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"2", id, "new name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id).getName(), is("new name"));
    }
    /**
     * метод теста удаления заявки (команда в меню - 3)
     * */
    @Test
    public void whenDeleteThenTrackerHasNoThisItemAndReturnNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("id", "name", "desc", 123L);
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"3", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(id), is(nullValue()));
    }
    /**
     * метод теста поиска заявки по id (команда в меню - 4)
     */
    @Test
    public void whenFindIdThenTrackerReturnsItemWithThatId() {
        Tracker tracker = new Tracker();
        Item item = new Item("id", "name", "desc", 1L);
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(id));
    }

    /**
     * тест поиска по имени и вывода всех элементов с искомым именем (команды меню - 5)
     * */
    @Test
    public void whenFindByNameThenReturnItemWithThatName() {
    Tracker tracker = new Tracker();
    Item item = new Item("id", "name", "desc", 123L);
    Item item2 = new Item("id", "name2", "desc2", 123L);
    Item item3 = new Item("id", "name3", "desc3", 123L);
    tracker.add(item);
    tracker.add(item2);
    tracker.add(item3);
    Input input = new StubInput(new String[]{"5", "name", "6"});
    new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append(System.lineSeparator())
                        .append("------------ Поиск заявок по имени: --------------")
                        .append(System.lineSeparator())
                        .append("id: " + item.getId() + ", name: " + item.getName() + ", description: " + item.getDescription())
                        .append(System.lineSeparator())
                        .append("------------ Завершение вывода заявок --------------")
                        .append(System.lineSeparator())
                        .append(menu)
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    /**
    * тест вывода всех элементов трекера (команда в меню - 1)
    * */
    @Test
    public void whenShoeAllThantTrackerShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("id", "name", "desc", 123L);
        tracker.add(item);
        Item item2 = new Item("id", "name2", "desc2", 123L);
        tracker.add(item2);
        Item first = tracker.getAll()[0];
        Item second = tracker.getAll()[1];
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append(System.lineSeparator())
                        .append("------------ Заявки существующие в системе: --------------")
                        .append(System.lineSeparator())
                        .append("id: " + first.getId() + ", name: " + first.getName() + ", description: " + first.getDescription())
                        .append(System.lineSeparator())
                        .append("id: " + second.getId() + ", name: " + second.getName() + ", description: " + second.getDescription())
                        .append(System.lineSeparator())
                        .append("------------ Завершение вывода всех заявок --------------")
                        .append(System.lineSeparator())
                        .append(menu)
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }
}