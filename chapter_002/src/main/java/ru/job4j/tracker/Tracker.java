package ru.job4j.tracker;
/**
 * @author Oleg
 *
 * */
import java.util.*;
public class Tracker {
    /**
     * Массив для хранения всех заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
    }
    /**
     * изменения в заявке
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(item.getId())) {
                item.setId(id);
                items[i] = item;
                break;
            }
        }
    }
    /**
     * удаление заявок
     * */
    public void delete(String id) {
        Item item2delete = findById(id);
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(item2delete.getId())) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, this.items.length - i - 1);
                this.position--;
                break;
            }
        }
    }
    /**
     * получение списка всех заявок
     * */
    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * получение списка по имени
     * */
    public Item[] findByName(String key) {
        int i = 0;
        Item[] result = new Item[this.position];
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result[i] = item;
                i++;
            }
        }
        return i > 0 ? Arrays.copyOf(result, i) : null;
    }
    /**
     * получение заявки по id
     * */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}