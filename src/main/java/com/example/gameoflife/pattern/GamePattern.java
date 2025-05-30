package com.example.gameoflife.pattern;

import com.example.gameoflife.grid.Grid;

import java.util.Random;

public class GamePattern {
    private Grid grid;
    private int HEIGHT;
    private int WIDTH;

    public GamePattern(Grid grid, int HEIGHT, int WIDTH){
        this.grid = grid;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
    }

    public void setGlider(int startX, int startY) {
        grid.setCellCurrentState(startX + 1, startY + 2, true);
        grid.setCellCurrentState(startX + 2, startY + 3, true);
        grid.setCellCurrentState(startX + 3, startY + 1, true);
        grid.setCellCurrentState(startX + 3, startY + 2, true);
        grid.setCellCurrentState(startX + 3, startY + 3, true);
    }

    public void setBlinker(int startX, int startY) {
        grid.setCellCurrentState(startX + 2, startY + 1, true);
        grid.setCellCurrentState(startX + 2, startY + 2, true);
        grid.setCellCurrentState(startX + 2, startY + 3, true);
    }

    public void setToad(int startX, int startY) {
        grid.setCellCurrentState(startX + 2, startY + 2, true);
        grid.setCellCurrentState(startX + 2, startY + 3, true);
        grid.setCellCurrentState(startX + 2, startY + 4, true);
        grid.setCellCurrentState(startX + 3, startY + 1, true);
        grid.setCellCurrentState(startX + 3, startY + 2, true);
        grid.setCellCurrentState(startX + 3, startY + 3, true);
    }

    public void setLightweightSpaceship(int startX, int startY) {
        grid.setCellCurrentState(startX + 1, startY + 2, true);
        grid.setCellCurrentState(startX + 1, startY + 5, true);
        grid.setCellCurrentState(startX + 2, startY + 1, true);
        grid.setCellCurrentState(startX + 3, startY + 1, true);
        grid.setCellCurrentState(startX + 4, startY + 1, true);
        grid.setCellCurrentState(startX + 4, startY + 5, true);
        grid.setCellCurrentState(startX + 5, startY + 1, true);
        grid.setCellCurrentState(startX + 5, startY + 2, true);
        grid.setCellCurrentState(startX + 5, startY + 3, true);
        grid.setCellCurrentState(startX + 5, startY + 4, true);
    }

    public void setPulsar(int startX, int startY) {
        int[][] coords = {
                {2,4},{2,5},{2,6},{2,10},{2,11},{2,12},
                {4,2},{5,2},{6,2},{4,7},{5,7},{6,7},{4,9},{5,9},{6,9},{4,14},{5,14},{6,14},
                {7,4},{7,5},{7,6},{7,10},{7,11},{7,12},
                {9,4},{9,5},{9,6},{9,10},{9,11},{9,12},
                {10,2},{11,2},{12,2},{10,7},{11,7},{12,7},{10,9},{11,9},{12,9},{10,14},{11,14},{12,14},
                {14,4},{14,5},{14,6},{14,10},{14,11},{14,12}
        };

        for (int[] c : coords) {
            grid.setCellCurrentState(startX + c[0], startY + c[1], true);
        }
    }

    public void setDiehard(int startX, int startY) {
        int[][] coords = {
                {startX + 0, startY + 6},
                {startX + 1, startY + 0},
                {startX + 1, startY + 1},
                {startX + 2, startY + 1},
                {startX + 2, startY + 5},
                {startX + 2, startY + 6},
                {startX + 2, startY + 7}
        };
        for (int[] c : coords) {
            grid.setCellCurrentState(c[0], c[1], true);
        }
    }

    public void setGosperGliderGun(int startX, int startY) {
        int[][] coords = {
                {5,1},{5,2},{6,1},{6,2},
                {3,13},{3,14},{4,12},{4,16},{5,11},{5,17},{6,11},{6,15},{6,17},{6,18},
                {7,11},{7,17},{8,12},{8,16},{9,13},{9,14},
                {1,25},{2,23},{2,25},{3,21},{3,22},{4,21},{4,22},{5,21},{5,22},
                {6,23},{6,25},{7,25},
                {3,35},{3,36},{4,35},{4,36}
        };

        for (int[] c : coords) {
            grid.setCellCurrentState(startX + c[0], startY + c[1], true);
        }
    }

    public void setPentadecathlon(int startX, int startY) {
        int[] ys = {startY, startY + 1, startY + 2, startY + 3, startY + 4, startY + 5, startY + 6, startY + 7, startY + 8, startY + 9};
        int[][] coords = {
                {startX + 1, startY + 1},
                {startX + 1, startY + 2},
                {startX + 1, startY + 3},
                {startX + 1, startY + 5},
                {startX + 1, startY + 6},
                {startX + 1, startY + 7},
        };

        // Draw main line of 10 cells
        for (int y = startY; y < startY + 10; y++) {
            grid.setCellCurrentState(startX, y, true);
        }

        // Add side cells for oscillation
        for (int[] c : coords) {
            grid.setCellCurrentState(c[0], c[1], true);
        }
    }

    public void setLoaf(int startX, int startY) {
        int[][] coords = {
                {startX, startY + 1},
                {startX + 1, startY},
                {startX + 2, startY},
                {startX + 3, startY + 1},
                {startX + 1, startY + 2},
                {startX + 3, startY + 2},
                {startX + 2, startY + 3}
        };
        for (int[] c : coords) {
            grid.setCellCurrentState(c[0], c[1], true);
        }
    }

    public void setSwitchEngine(int startX, int startY) {
        int[][] coords = {
                {startX + 0, startY + 1},
                {startX + 1, startY + 0},
                {startX + 1, startY + 2},
                {startX + 2, startY + 0},
                {startX + 2, startY + 3},
                {startX + 3, startY + 0},
                {startX + 3, startY + 1},
                {startX + 3, startY + 2},
        };
        for (int[] c : coords) {
            grid.setCellCurrentState(c[0], c[1], true);
        }
    }

    public void setBeacon(int startX, int startY) {
        int[][] coords = {
                {startX, startY}, {startX, startY + 1},
                {startX + 1, startY},
                {startX + 2, startY + 3},
                {startX + 3, startY + 2}, {startX + 3, startY + 3}
        };
        for (int[] c : coords) {
            grid.setCellCurrentState(c[0], c[1], true);
        }
    }

    public void setRandomPattern(double aliveProbability) {
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                boolean alive = random.nextDouble() < aliveProbability;
                grid.setCellCurrentState(i, j, alive);
            }
        }
    }
}
