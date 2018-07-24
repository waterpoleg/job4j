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
        for (int index = 0; result && index != data[0].length - 1; index++) {
            result = data[index][index] == data[index + 1][index + 1];
        }
        return result;
    }
}
