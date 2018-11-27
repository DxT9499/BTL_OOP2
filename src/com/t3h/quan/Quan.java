package com.t3h.quan;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.t3h.drawmap.Diem;
import com.t3h.vukhi.Bom;

public abstract class Quan {
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	protected int x,y;
	protected int orient;
	protected Image image;
	protected Image[] imageLeft,imageRight,imageUp,imageDown;
	protected int timeMove,curent=0,timeChang;
	Image image2=new ImageIcon(getClass().getResource("/image/6.png")).getImage();
	public Quan(int x, int y,int orient,int timeMove,int timeChange) {
		super();
		this.x = x;
		this.y = y;
		this.orient = orient;
		this.timeMove=timeMove;
		this.image=image2;
		this.timeChang=timeChange;
	}
	public void changeOrient(int orient) {
		if(this.orient!=orient){
			curent=0;
			this.orient=orient;
			if(orient==RIGHT){
				image=imageRight[0];
			}
			if(orient==LEFT){
				image=imageLeft [0];
			}
			if(orient==UP){
				image=imageUp [0];
			}
			if(orient==DOWN){
				image=imageDown[0];
			}
		}
	}
	
	public void changeImages(int time){
		if(time%timeChang==0){
			curent++;
			if(curent>=imageDown.length){
				curent=0;
			}
			switch (orient) {
			case LEFT:
				image=imageLeft[curent];
				break;
			case RIGHT:
				image=imageRight[curent];
				break;
			case UP:
				image=imageUp[curent];
				break;
			case DOWN:
				image=imageDown[curent];
				break;
			default:
				break;
			}
		}

	}

	public void drawMove(Graphics2D g2d){
		if (orient==LEFT){
			g2d.drawImage(imageLeft[curent], x, y,45,45, null);
		}
		if(orient==RIGHT){
			g2d.drawImage(imageRight[curent], x, y,45,45, null);
		}
		if(orient==UP){
			g2d.drawImage(imageUp[curent], x, y,45,45, null);
		}	
		if(orient==DOWN){
			g2d.drawImage(imageDown[curent], x, y,45,45, null);
		}
	}
	
	public int move(int w,int h,int time,ArrayList<Diem> arr) {
		if(time%timeMove == 0){
			int newX=0,newY=0;
			if (x<=0 & orient==LEFT) {
				return 1;
			}
			if (x>=(w-45) && orient==RIGHT) {
				return 1;
			}
			if (y<=0 && orient==UP) {
				return 1;
			}
			if (y>=(h-image.getHeight(null)-45) && orient==DOWN) {
				return 1;
			}
			switch (orient) {
			case LEFT:
				newX -=1;
				break;
			case RIGHT:
				newX +=1;
				break;
			case UP:
				newY -=1;
				break;
			case DOWN:
				newY +=1;
				break;
			}
			x+=newX;
			y+=newY;
			int checkMap=checkMap(arr);
			if (checkMap==1) {
				x-=newX;
				y-=newY;
				return 1;
			}else{
				changeImages(time);
				if(checkMap!=2){
					int bit=arr.get(checkMap).getBit();
					arr.get(checkMap).setBit(0);
					return bit;
				}
				return 2;
			}
		}
		return 2;
	}

	public int checkMap(ArrayList<Diem> arr){
		for (int i = 0; i < arr.size(); i++) {
			Rectangle rectangle = null;
			switch (orient) {
			case LEFT:
				rectangle=getRectLeft();
				break;
			case RIGHT:
				rectangle=getRectRight();
				break;
			case UP:
				rectangle=getRectUp();
				break;
			case DOWN:
				rectangle=getRectDown();
				break;
			}
			boolean checkBound=rectangle.intersects(arr.get(i).getRec());
			if (checkBound) {
				int bit=arr.get(i).getBit();
				if (bit==3||bit==1||bit==4) {
					return 1;
				}else if(bit==5||bit==6||bit==7){
					return i;
				}
			}
		}
		return 2;
	}
	
	private Rectangle getRectLeft() {
		return new Rectangle(x,y+3,3,33);
	}
	
	private Rectangle getRectRight() {
		return new Rectangle(x+37,y,3,33);
	}
	
	private Rectangle getRectUp() {
		return new Rectangle(x+3,y,33,3);
	}
	
	private Rectangle getRectDown() {
		return new Rectangle(x+3,y+37,33,3);
	}
	
	public Rectangle getRect() {
		Rectangle rectangle=new Rectangle(x, y, 45,45);
		return rectangle;
	}
	
	public boolean checkMove(Quan d){
		if(d.getRect().intersects(getRect())){
			return true;
		}
		return false;
	}
	
	public boolean checkDie(ArrayList<Bom> arr){
		for(Bom bom:arr){
			if(getRect().intersects(bom.getRecDown())
                         ||getRect().intersects(bom.getRecLeft())
                         ||getRect().intersects(bom.getRecRight())
                         ||getRect().intersects(bom.getRecUp())){
				return true;
			}
		}
		return false;
	}
	
}
