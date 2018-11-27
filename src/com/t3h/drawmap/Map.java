package com.t3h.drawmap;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Map {
	private Image[] imageMap={null,
			new ImageIcon(getClass().getResource("/image/3.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/2.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/3.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/4.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/5.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/6.png")).getImage(),
			new ImageIcon(getClass().getResource("/image/heart.png")).getImage(),
        };
	private ArrayList<Diem> arrDiem;
	public Map() {
		// TODO Auto-generated constructor stub
		arrDiem=new ArrayList<>();
	}
	public void readMap() {
		int hang=0;
		try {
			BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\123456789\\Documents\\NetBeansProjects\\Bomb\\build\\classes\\map\\map.txt"));
			String line=reader.readLine();
			while(line!=null){
				loadLine(line,hang);
				hang++;
				line=reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("co loi:::::"+e.toString()+"\n");
		}
	}

	public void loadLine(String line, int dong) {
		int y=dong*45;
		for(int i=0;i<line.length();i++){
			int x = i*45;
//                        if(i == 0) x = 0;
//                        else x = i*45; 
			int bit=Integer.parseInt(""+line.charAt(i));
			Diem diem=new Diem(x, y, bit);
			arrDiem.add(diem);
		}
	}

	public void drawMap(Graphics2D g2d) {
		for(Diem  diem:arrDiem){
			g2d.drawImage(imageMap[diem.getBit()], diem.getX(), diem.getY(),45,45,null);
		}
	}
	public ArrayList<Diem> getArrDiem() {
		return arrDiem;
	}
}
