package ru.job4j.condition;

public class ChessBoard {
    public static int way(int x1, int y1, int x2, int y2) {
        int result = 0;
        if (isValid(x1) && isValid(x2) && isValid(y1) && isValid(y2)) {
            if (x1 == x2 || y1 == y2) {
                return result;
            }
            int distY = Math.abs(y2 - y1);
            int distX = Math.abs(x2 - x1);
            result = distY == distX ? distX : 0;
        }
        return result;
    }

    private static boolean isValid(int coordinate) {
        return coordinate >= 0 && coordinate <= 7;
    }
}
