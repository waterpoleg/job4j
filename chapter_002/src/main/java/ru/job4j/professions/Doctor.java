package ru.job4j.professions;

public class Doctor extends Profession {
    public Doctor(String profession, String name) {
        super(profession, name);
    }

    /**
     * Метод диагностики заболевания Patient
     * (возвращает null - "заглушка", тк нет реализации в классе Diagnosis)
     */
    public Diagnosis heal(Patient patient) {
        return null;
    }
}
