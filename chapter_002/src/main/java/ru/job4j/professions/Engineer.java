package ru.job4j.professions;

public class Engineer extends Profession {
    public Engineer(String profession, String name) {
        super(profession, name);
    }

    /**
     * метод строительства дома Engineer-ом
     * (метод врзвращает null как заглушку, тк в классе Building нет реализации)
     */
    public Building build(House house) {
        return null;
    }
}
