package com.example.gameoflife;

import com.example.gameoflife.grid.Grid;
import com.example.gameoflife.pattern.GamePattern;

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

public class TheGameOfLife extends Application {
	static final int HEIGHT = 100;
	static final int WIDTH = 100;
	private final int CELL_SIZE = 10;
	private Canvas canvas;
	private Grid grid;
	private GamePattern gamePattern;

	static boolean gameState = true;

	@Override
	public void start(Stage stage) {
		grid = new Grid(HEIGHT, WIDTH);
		gamePattern = new GamePattern(grid, HEIGHT, WIDTH);

		gamePattern.setDiehard(25, 25);

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

	public static void main(String[] args) throws InterruptedException {
		launch();
	}
}
