package com.example.gameoflife.cell;

public class Cell {
	private final int x;
	private final int y;
	private boolean isAlive;
	private boolean nextState;

	public Cell(int x, int y, boolean isAlive, boolean nextState) {
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
		this.nextState = nextState;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean alive) {
		isAlive = alive;
	}

	public boolean isNextState() {
		return nextState;
	}

	public void setNextState(boolean nextState) {
		this.nextState = nextState;
	}

	@Override
	public String toString() {
		return isAlive ? "x" : "0";
	}
}
