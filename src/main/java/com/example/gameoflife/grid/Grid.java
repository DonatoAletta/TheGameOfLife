package com.example.gameoflife.grid;

import com.example.gameoflife.cell.Cell;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grid {
	private Cell[][] grid;

	public Grid(int x, int y) {
		this.grid = new Cell[x][y];
		populateGrid();
	}

	public void play() {
		for (Cell[] cells : grid) {
			for (int j = 0; j < grid.length; j++) {
                cells[j].setAlive(cells[j].isNextState());
			}
		}
	}

	public boolean isCellAliveAt(int x, int y) {
		return grid[x][y].isAlive();
	}

	public void processNextState(int x, int y) {
		try {
			int aliveNeighbours = aliveNeighboursAt(x, y);
			boolean isAlive = grid[x][y].isAlive();

			if (isAlive) {
				if (aliveNeighbours < 2 || aliveNeighbours > 3) {
					grid[x][y].setNextState(false);
				} else {
					grid[x][y].setNextState(true);
				}
			} else {
				if (aliveNeighbours == 3) {
					grid[x][y].setNextState(true);
				} else {
					grid[x][y].setNextState(false);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("PROBLEM");
		}


	}

	public void setCellCurrentState(int x, int y, boolean state) {
		grid[x][y].setAlive(state);
	}

	private void populateGrid(){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				Cell cell = new Cell(i, j, false, false);
				grid[i][j] = cell;
			}
		}
	}

	private int aliveNeighboursAt(int x, int y) {
		return getAliveCell(x, y);
	}

	private int getAliveCell(int x, int y) {
		int aliveCell = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i == x && j == y) continue;
				if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
					if (grid[i][j].isAlive()) {
						aliveCell++;
					}
				}
			}
		}
		return aliveCell;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Cell[] row : grid) {
			for (Cell cell : row) {
				sb.append(cell.toString()).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
