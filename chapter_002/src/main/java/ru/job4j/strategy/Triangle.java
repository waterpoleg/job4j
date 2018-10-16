package ru.job4j.strategy;
/**
 * треугольник
 * */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ").append(System.getProperty("line.separator"));
        pic.append("  +++  ").append(System.getProperty("line.separator"));
        pic.append(" +++++ ").append(System.getProperty("line.separator"));
        pic.append("+++++++").append(System.getProperty("line.separator"));
        return pic.toString();
    }
}