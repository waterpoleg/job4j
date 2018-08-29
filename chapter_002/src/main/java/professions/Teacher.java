package professions;

public class Teacher extends Profession {
    public Teacher(String profession, String name) {
        super(profession, name);
    }

    /**
     * метод "экзаминации" Teacher-ом Student-а
     * (возвращает null - заглушка, тк в классе Exam нет реализации)
     */
    public Exam teach(Student student) {
        return null;
    }
}
