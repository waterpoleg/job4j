package ru.job4j.strategy;
/**
 * квадрат
 * */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.getProperty("line.separator"));
        pic.append("++++").append(System.getProperty("line.separator"));
        pic.append("++++").append(System.getProperty("line.separator"));
        pic.append("++++").append(System.getProperty("line.separator"));
        return pic.toString();
    }
}