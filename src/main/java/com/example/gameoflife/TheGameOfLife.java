package com.example.gameoflife;

import com.example.gameoflife.grid.Grid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class TheGameOfLife extends Application {
	static final int HEIGHT = 100;
	static final int WIDTH = 100;
	private final int CELL_SIZE = 10;
	private Canvas canvas;
	private Grid grid;

	static boolean gameState = true;

	@Override
	public void start(Stage stage) {
		grid = new Grid(HEIGHT, WIDTH);
		Random random = new Random();

		setDiehard(25,25);

		canvas = new Canvas(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
		drawGrid();

		StackPane root = new StackPane(canvas);
		Scene scene = new Scene(root);
		stage.setTitle("Game of Life");
		stage.setScene(scene);
		stage.show();

		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SPACE) {
				gameState = !gameState;
			}
		});

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {
			if (gameState) {
				updateGrid();
				drawGrid();
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	private void updateGrid() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				grid.processNextState(i, j);
			}
		}
		grid.play();
	}

	private void drawGrid() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		gc.setFill(Color.LIMEGREEN);
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (grid.isCellAliveAt(i, j)) {
					gc.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				}
			}
		}
	}

	private void setGlider(int startX, int startY) {
		grid.setCellCurrentState(startX + 1, startY + 2, true);
		grid.setCellCurrentState(startX + 2, startY + 3, true);
		grid.setCellCurrentState(startX + 3, startY + 1, true);
		grid.setCellCurrentState(startX + 3, startY + 2, true);
		grid.setCellCurrentState(startX + 3, startY + 3, true);
	}

	private void setBlinker(int startX, int startY) {
		grid.setCellCurrentState(startX + 2, startY + 1, true);
		grid.setCellCurrentState(startX + 2, startY + 2, true);
		grid.setCellCurrentState(startX + 2, startY + 3, true);
	}

	private void setToad(int startX, int startY) {
		grid.setCellCurrentState(startX + 2, startY + 2, true);
		grid.setCellCurrentState(startX + 2, startY + 3, true);
		grid.setCellCurrentState(startX + 2, startY + 4, true);
		grid.setCellCurrentState(startX + 3, startY + 1, true);
		grid.setCellCurrentState(startX + 3, startY + 2, true);
		grid.setCellCurrentState(startX + 3, startY + 3, true);
	}

	private void setLightweightSpaceship(int startX, int startY) {
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

	private void setPulsar(int startX, int startY) {
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

	private void setDiehard(int startX, int startY) {
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

	private void setGosperGliderGun(int startX, int startY) {
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

	private void setPentadecathlon(int startX, int startY) {
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

	private void setLoaf(int startX, int startY) {
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

	private void setSwitchEngine(int startX, int startY) {
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

	private void setBeacon(int startX, int startY) {
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


	public static void main(String[] args) throws InterruptedException {
		launch();
	}
}
