package ru.job4j.tracker;

/**
 *@author Oleg
 * @since 14.10.18
 *
 * */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;
public class StartUITest {
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
}