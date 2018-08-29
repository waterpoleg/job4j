package ru.job4j.calculate.loop;
/**
 * @author Олег
 * @since 20.7.18
 */
public class Board {
    /**
     * метод рисует "шахматную" доску в псевдографике
     * Х нужно ставить там, где сумма i и j это четное число
     * @return строка вида "Х Х Х Х Х"
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
