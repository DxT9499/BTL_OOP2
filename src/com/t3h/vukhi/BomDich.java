package com.t3h.vukhi;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.t3h.drawmap.Diem;
import com.t3h.quan.Quan;

public class BomDich {

	private int x,y;
	private Image image=new ImageIcon(getClass().getResource("/image/bom_boss.png")).getImage();
	private int orient;

	public BomDich(int x, int y, int orient) {
		super();
		this.x = x;
		this.y = y;
		this.orient = orient;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(image, x, y,45,45, null);
	}

	public boolean move(int w,int h,int time) {
			if (x<=0||x>=(w-image.getWidth(null)-22)) {
				return true;
			}
			if (y<=0||y>=(h-image.getHeight(null)-45)) {
				return true;
			}
			switch (orient) {
			case Quan.LEFT:
				x--;
				break;
			case Quan.RIGHT:
				x++;
				break;
			case Quan.UP:
				y--;
				break;
			case Quan.DOWN:
				y++;
				break;
			}
		return false;
	}
	public Rectangle getRec(){
		return new Rectangle(x, y,40, 40);
	}
	public int checkMap(ArrayList<Diem> arr) {
		for(int i=0;i<arr.size();i++){
			int bit=arr.get(i).getBit();
			if(getRec().intersects(arr.get(i).getRec())&&bit!=2&&bit!=0&&bit!=6&&bit!=7){
				return i;
			}
		}
		return 0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
