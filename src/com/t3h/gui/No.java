package com.t3h.gui;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class No {
	private int x,y,curent=-1;
	private Image image[] = {new ImageIcon(getClass().getResource("/image/no1.png")).getImage(),
                                new ImageIcon(getClass().getResource("/image/no2.png")).getImage(),
	};
	public No(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		curent=0;
	}
	public void draw(Graphics2D g2d){
		if(curent>=0){
			g2d.drawImage(image[curent], x, y,45,45,null);
		}
	}
	public boolean changCurent(int time){
		if(time%15==0){
			curent++;
			if(curent==2){
				curent=-1;
			}
		}
		return curent==-1;
	}
}
