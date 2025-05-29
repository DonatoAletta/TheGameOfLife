package com.example.gameoflife;

import com.example.gameoflife.cell.Cell;
import com.example.gameoflife.grid.Grid;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
	static final int HEIGHT = 150;
	static final int WIDTH = 150;
	private final int CELL_SIZE = 5;
	private Canvas canvas;
	private Grid grid;

	static boolean gameState = true;

	@Override
	public void start(Stage stage) {
		grid = new Grid(HEIGHT, WIDTH);
		Random random = new Random();
		int spawnPoint = random.nextInt((HEIGHT - 2) + 1);

		grid.setCellCurrentState(10, 10, true);
		grid.setCellCurrentState(11, 11, true);
		grid.setCellCurrentState(11, 12, true);
		grid.setCellCurrentState(10, 12, true);
		grid.setCellCurrentState(9, 12, true);
		grid.setCellCurrentState(8, 13, true);


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

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), e -> {
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
