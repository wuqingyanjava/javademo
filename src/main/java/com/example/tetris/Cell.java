package com.example.tetris;


import java.awt.image.BufferedImage;

/**
 * ??????????��???��??��??????(???)
 * ????(????)??
 *  row --?��?
 *  col--?��?
 *  image--???????
 * 
 * ???(????)
 *   left()
 *   right()
 *   drop();
 */
public class Cell {
	private int row;
	private int col;
	private BufferedImage image;
	public Cell() {}
	public Cell(int row, int col, BufferedImage image) {
		super();
		this.row = row;
		this.col = col;
		this.image = image;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
	
	/**???????*/
	public void left() {
		col--;
	}
	public void right() {
		col++;
	}
	public void drop() {
		row++;
	}
}




