package ru.job4j.calculate.max;

public class Max {

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int maxOfThree(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
