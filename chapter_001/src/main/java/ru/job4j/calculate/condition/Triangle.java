package ru.job4j.calculate.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Суть метода: если большая сторона меньше суммы двух других,
     * то треугольник построить можно.
     */
    private boolean isTriangleExist(double ac, double ab, double bc) {
        return (ab + bc) > ac && (ab + ac) > bc && (ac + bc) > ab;
    }

    /**
     * Вычисляем полупериметр
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * @return = площадь треугольника, если он существует, иначе -1.
     * для вычисления площади используется формула Герона
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(b);
        double ac = this.a.distanceTo(c);
        double bc = this.b.distanceTo(c);
        double p = this.period(ab, ac, bc);
        if (this.isTriangleExist(ab, ac, bc)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
}