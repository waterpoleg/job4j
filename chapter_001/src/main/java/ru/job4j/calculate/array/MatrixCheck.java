package ru.job4j.calculate.array;

public class MatrixCheck {
    /**
     * цикл в методе прерывается если встречается отличный от предыдущего элемент матрицы
     * или по достижению конца счетчика
     * @param data - массив матрица из элементов boolean
     * @return true если диагональные эелементы одинаковые (true или false)
     * @return false если диагональ состоит из неоднородных элементов
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; result && i != data[0].length - 1; i++) {
            result = (data[i][i] == data[i + 1][i + 1]) && (data[i][data.length - 1 - i] == data[data.length - 1 - i][i]);
        }
        return result;
    }
}
