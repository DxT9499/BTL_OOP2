package com.t3h.drawmap;

import java.awt.Rectangle;

public class Diem {
	private int x,y,bit;

	public Diem(int x, int y, int bit) {
		super();
		this.x = x;
		this.y = y;
		this.bit = bit;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}
	public Rectangle getRec(){
		return new Rectangle(x, y, 40, 40);
	}
}
