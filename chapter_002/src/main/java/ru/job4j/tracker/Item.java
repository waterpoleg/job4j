package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String description;
    private long created;

    public Item(String id, String name, String desc, long create) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.created = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated() {
        return this.created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "id: "
                + id
                + ", name: "
                + name
                + ", description: "
                + description;
    }
}