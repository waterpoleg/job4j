package ru.job4j.tracker;
/**
 * @author Oleg
 * */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    /**
     * тест добавления элемента
     * */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "test1", "testDescription1", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
    /**
     * тест изменения элемента
     * */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("testId", "test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("testId", "test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * тест удаления элемента
     * */
    @Test
    public void whenDeleteThenReturnItemsMinusOne() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Id1", "name1", "description1", 123L);
        tracker.add(item1);
        Item item2 = new Item("Id2", "name2", "description2", 123L);
        tracker.add(item2);
        Item item3 = new Item("Id3", "name3", "description3", 123L);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] test = {item1, item3};
        assertThat(tracker.getAll(), is(test));
    }
    /**
     * тест получния всех элементов
     * */
    @Test
    public void whenGetAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Id", "name1", "description1", 123L);
        tracker.add(item1);
        Item item2 = new Item("Id", "name2", "description2", 123L);
        tracker.add(item2);
        Item item3 = new Item("Id", "name3", "description3", 123L);
        tracker.add(item3);
        Item[] test = {item1, item2, item3};
        assertThat(tracker.getAll(), is(test));
    }
    /**
     * тест посика элемента по имени
     */
    @Test
    public void whenFindByNameThenReturnItemsArrayWithAllItemsWithThisName() {
        Tracker tracker = new Tracker();
        //чтобы было из чего искать делаем три заявки
        Item item1 = new Item("Id1", "name1", "description1", 123L);
        tracker.add(item1);
        Item item2 = new Item("Id2", "name3", "description2", 123L);
        tracker.add(item2);
        Item item3 = new Item("Id3", "name3", "description3", 123L);
        tracker.add(item3);
        Item[] test = {item2, item3};
        assertThat(tracker.findByName("name3"), is(test));
    }
    /**
     * тест посика элемента по id
     */
    @Test
    public void whenFindByIdThenReturnItemWithId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test6Id", "test6", "testDescription6", 123L);
        tracker.add(item);
        Item anotherItem = new Item("oneMoreId", "oneMoreTest", "oneMoreDescription", 123L);
        tracker.add(anotherItem);
        assertThat(tracker.findById(anotherItem.getId()), is(anotherItem));
    }
}