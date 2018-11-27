package com.t3h.vukhi;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.t3h.drawmap.Diem;

public class Bom {
	private ArrayList<Integer> arrDiemRemove;
	private int x,y,size;
	private int curent=-1;
        private int[] a;
        private Image[] img_left={new ImageIcon(getClass().getResource("/image/bombbang_left_1.png")).getImage(),
                                  new ImageIcon(getClass().getResource("/image/bombbang_left_2.png")).getImage()},
                        img_right={new ImageIcon(getClass().getResource("/image/bombbang_right_1.png")).getImage(),
                                   new ImageIcon(getClass().getResource("/image/bombbang_right_2.png")).getImage()},
                        img_up={new ImageIcon(getClass().getResource("/image/bombbang_up_1.png")).getImage(),
                                new ImageIcon(getClass().getResource("/image/bombbang_up_2.png")).getImage()},
                        img_down={new ImageIcon(getClass().getResource("/image/bombbang_down_1.png")).getImage(),
                                  new ImageIcon(getClass().getResource("/image/bombbang_down_2.png")).getImage()};
	private Image[] itemBom={new ImageIcon(getClass().getResource("/image/bomb.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/bomb.png")).getImage(),
			null};
        
	public Bom(int x, int y,ArrayList<Diem> arr,int sizeBom) {
		super();
                x+=22;
                y+=22;
		this.x=((x)/45)*45;
		this.y=((y)/45)*45;
                this.size=sizeBom;
		arrDiemRemove=new ArrayList<>();
		checkMap(arr,size);
		curent=0;
	}
	public boolean changImage(int timeNo){
		if(timeNo%350==0 && curent == 0){
			curent++;
		}
		if(timeNo % 300 == 0 && curent > 0){
			curent ++;
		}
		if(curent>=itemBom.length){
			curent= -1;
			return true;
		}
		return false;
	}
	public boolean checkNo(){
		if(curent==2){
			return true;
		}else{
			return false;
		}
	}
	public void draw(Graphics2D g2d,ArrayList<Diem> arr,int size){
		if(curent>=0){
			if(curent==2){
				if(checkBit(x-45*size,y,arr) != 3 && checkBit(x-45,y,arr) != 3) g2d.drawImage(img_left[size-1], x-45*size, y, null);
                                else if(checkBit(x-45,y,arr) != 3) g2d.drawImage(img_left[size-2], x-45, y, null);
                                if(checkBit(x+45*size,y,arr) != 3 && checkBit(x+45,y,arr) != 3) g2d.drawImage(img_right[size-1], x, y, null);
                                else if(checkBit(x+45,y,arr) != 3) g2d.drawImage(img_right[size-2], x, y, null);
                                if(checkBit(x,y-45*size,arr) != 3 && checkBit(x,y-45,arr) != 3) g2d.drawImage(img_up[size-1], x, y-45*size, null);
                                else if(checkBit(x,y-45,arr) != 3) g2d.drawImage(img_up[size-2], x, y-45, null);
                                if(checkBit(x,y+45*size,arr) != 3 && checkBit(x,y+45,arr) != 3) g2d.drawImage(img_down[size-1], x, y, null);
                                else if(checkBit(x,y+45,arr) != 3) g2d.drawImage(img_down[size-2], x, y, null);
				return;
			}
			g2d.drawImage(itemBom[curent], x, y, 45, 45, null);
		}

	}
	public void checkMap(ArrayList<Diem> arr, int size){
            for(int i = 1; i <=size;i++){
                if(i == 2 && x>=90 && y >= 90){
		checkBit(x,y-45*i,arr);
		checkBit(x,y+45*i,arr);
		checkBit(x-45*i,y,arr);
		checkBit(x+45*i,y,arr);
                }
            }
	}
	private int checkBit(int x, int y,ArrayList<Diem> arr) {
		int hang = y/45;
		int cot = x/45;
		int bitCen = arr.get(hang*30+cot).getBit();
		if(bitCen == 4){
			arrDiemRemove.add(hang*30+cot);
		}
                return bitCen;
	}

	public Rectangle getRecLeft(){
		return new Rectangle(x-45, y,90,45);
	}

	public Rectangle getRecRight(){
		return new Rectangle(x, y,90,45);
	}

	public Rectangle getRecUp(){
		return new Rectangle( x, y-45,45,90);
	}

	public Rectangle getRecDown(){
		return new Rectangle(x,y,45,90);
	}

	public ArrayList<Integer> getArrDiemRemove() {
		return arrDiemRemove;
	}
}
