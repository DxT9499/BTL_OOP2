package com.t3h.quan;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Ghost {
	private int x,y;
	private Image[] image={ new ImageIcon(getClass().getResource("/image/groudon1.png")).getImage(),
                                new ImageIcon(getClass().getResource("/image/groudon2.png")).getImage(),
                                new ImageIcon(getClass().getResource("/image/groudon1.png")).getImage(),
                                new ImageIcon(getClass().getResource("/image/groudon3.png")).getImage()};
	protected int curent = 0, timeChang = 100;
	public Ghost(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	};
        public void changImage(int time){
            if(time%timeChang == 0) curent++;
            if(curent > image.length) curent = 0;
        }
        
	public void drawMove(Graphics2D g2d){
            g2d.drawImage(image[curent], x, y, null);
	}
	public boolean move(int time){
//                if(time%timeChang==0){
//			curent++;
//                        if(curent > image.length) curent = 0;
//                        
//                }
                changImage(time);
		if(time%20==0){
			if(x<40){
				return true;
			}
			x=x-2;
		}
		return false;
	}
	public QuanDich setBoss(){
		Random random=new Random();
		int orient=random.nextInt(4);
		return new QuanDich(x, y, orient,35);
	}
}
