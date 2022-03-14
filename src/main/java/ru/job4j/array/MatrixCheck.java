package ru.job4j.array;

public class MatrixCheck {

    /**
     * Моно строка в матрице
     *
     * @param board - array
     * @param row - checking row
     * @return - result
     */
    public static boolean isMonoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int cell = 0; cell < board[row].length; cell++) {
            if (board[row][cell] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Моно столбец в матрице
     *
     * @param array - input array
     * @param column - input value of cell
     * @return - result;
     */
    public static boolean isMonoVertical(char[][] array, int column) {
        boolean result = true;
        for (char[] rows : array) {
            if (rows[column] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Массив из диагонали матрицы
     *
     * @param array - input array
     * @return - result
     */
    public static char[] extractDiagonal(char[][] array) {
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i][i];
        }
        return result;
    }

    /**
     * Проверка выигрышной ситуации в игре сокобан
     *
     * @param board - input array
     * @return - result
     */
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                if (isMonoHorizontal(board, i) || isMonoVertical(board, i)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
