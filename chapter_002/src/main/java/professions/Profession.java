package professions;

public class Profession {
    private String profession;
    private String name;

    public Profession(String profession, String name) {
        this.profession = profession;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }
}
