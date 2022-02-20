package com.safronov.tictactoe.model;

public class GameMap {
    private POINT[][] map;
    private int size;
    private int winSize;
    private int emptyCells;

    private final Validate validate;

    private final Move lastMove;

    public GameMap(int size, int winSize) {
        validate = new Validate();
        lastMove = new Move(-1, -1);

        initMap(size, winSize);
    }

    public void initMap(int size, int winSize) {
        map = new POINT[size][size];
        this.size = size;
        this.winSize = winSize;
        emptyCells = size * size;
    }
    public enum POINT {
        PLAYER_1, PLAYER_2, EMPTY
    }

    public static class Move {
        private int x;

        private int y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    private class Validate {


        public boolean check(int x, int y) {
            if (!(isValidRange(x) || isValidRange(y))) {
                return false;
            }
            return !isCellEmpty(x, y);
        }

        private boolean isCellEmpty(int x, int y) {
            return map[x][y].equals(POINT.EMPTY);
        }

        private boolean isValidRange(int n) {
            return n >= 0 && n <= size;
        }

    }

    public boolean makeMove(int x, int y, POINT point) {
        if (validate.check(x, y) || point.equals(POINT.EMPTY)) {
            return false;
        }
        map[x][y] = point;
        emptyCells--;
        lastMove.setXY(x, y);

        return true;
    }

    public POINT[][] getMap() {
        return map;
    }

    public int getSize() {
        return size;
    }

    public int getWinSize() {
        return winSize;
    }

    public int getEmptyCells() {
        return emptyCells;
    }

    public Move getLastMove() {
        return lastMove;
    }
}
