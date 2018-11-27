package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.BitSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.t3h.drawmap.Diem;
import com.t3h.drawmap.Map;
import com.t3h.quan.GameManager;
import com.t3h.quan.Quan;

public class PanelGame extends JPanel implements KeyListener,Runnable{
	private GameManager gameManager;
	private boolean isRunning=true;
	private Map map;
	private ArrayList<Diem> arrDiem;
	private AudioClip soundIngame,shoot,move,auWin,auLost;
	private Image heart;
	private int checkQuan;
	private Image imageBackground;
	private BitSet bitSet;
        private int sizeBom =  1;
	public PanelGame() {
		setBackground(Color.WHITE);
	}
	public void initGame() {
		map=new Map();
		map.readMap();
		arrDiem=new ArrayList<>();
		arrDiem=map.getArrDiem();
		soundIngame=Applet.newAudioClip(getClass().getResource("/sound/ingame.wav"));
		auWin=Applet.newAudioClip(getClass().getResource("/sound/win.wav"));
		auLost=Applet.newAudioClip(getClass().getResource("/sound/lost.wav"));
		heart=new ImageIcon(getClass().getResource("/image/heart.png")).getImage();
		imageBackground=new ImageIcon(getClass().getResource("/image/backbomb.png")).getImage();
		soundIngame.loop();
		soundIngame.play();
		gameManager=new GameManager();
		gameManager.setCheckQuan(checkQuan);
		gameManager.initGame();
		bitSet=new BitSet(256);
		Thread thread=new Thread(this);
		thread.start();
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.drawImage(imageBackground, 0, 0,FrameGame.W_GAME,FrameGame.H_GAME,null);
		map.drawMap(g2d);
		try {
			gameManager.draw(g2d, arrDiem,sizeBom);
		} catch (Exception e) {

		}
		drawHeart(g2d);
	}

	private void drawHeart(Graphics2D g2d) {
		for(int i=0;i<gameManager.getMyHeart();i++){
			g2d.drawImage(heart,10+i*35, 10, 30, 30,null);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		bitSet.set(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		bitSet.clear(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private void moveMy(int orient,int time) {
		gameManager.moveMy(1400,700, orient,time,arrDiem,sizeBom);
		repaint();
	}

	private void message(String message) {
		int result=JOptionPane.showConfirmDialog(null, message,"Message",JOptionPane.YES_NO_OPTION);
		if (result==JOptionPane.YES_OPTION) {
			initGame();
		}else{
			System.exit(0);
		}
	}

	@Override
	public void run() {
		int time=0,timeNo=1;
		while (isRunning) {
			timeNo++;
			time++;
			gameManager.moveAllBoss(FrameGame.W_GAME,FrameGame.H_GAME,time,arrDiem);
			gameManager.moveGhost(FrameGame.W_GAME, time);
			gameManager.setGhost(FrameGame.W_GAME,time);
			gameManager.noBomb(arrDiem,timeNo);
			gameManager.moveQuanTank(FrameGame.W_GAME, FrameGame.H_GAME, time, arrDiem);
			gameManager.moveBomTank(FrameGame.W_GAME, FrameGame.H_GAME, arrDiem, time);
			gameManager.changAllCurentNo(time);
			gameManager.checkMyBomDich();
			gameManager.checkMyBoss();
			boolean isWin=gameManager.winGame();
			if (isWin) {
				soundIngame.stop();
				auWin.play();
				message("You win \nDo you want replay....");
				return;
			}
			boolean isGameOver=gameManager.gameOver();
			if (isGameOver) {
				soundIngame.stop();
				auLost.play();
				message("You lose \nDo you want replay....");
				return;
			}
			if (bitSet.get(KeyEvent.VK_LEFT)==true) {
				moveMy(Quan.LEFT,time);
			}else if (bitSet.get(KeyEvent.VK_RIGHT)) {
				moveMy(Quan.RIGHT,time);
			}else if (bitSet.get(KeyEvent.VK_UP)) {
				moveMy(Quan.UP,time);
			}else if (bitSet.get(KeyEvent.VK_DOWN)) {
				moveMy(Quan.DOWN,time);
			}
			if (bitSet.get(KeyEvent.VK_SPACE)) {
				if (timeNo>130) {
					timeNo=1;
					gameManager.mySetBomB(arrDiem);
				}

			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
	public void setCheckQuan(int checkQuan) {
		this.checkQuan=checkQuan;
	}
}
