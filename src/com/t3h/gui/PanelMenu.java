package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.AreaAveragingScaleFilter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class PanelMenu extends JPanel{
//	private FrameGame myFrame;
//	private FrameOption frameOption;
//	private FrameLevel frameLevel;
	private JButton btPlay,btExit,btOption,btHelp;
	private Image imagePlay,imageLevel,imageHelp,imageExit,imageOption,imagePlayC,imageLevelC,imageHelpC,imageExitC,imageOptionC;
	private AudioClip auClick;
	private Image backGround;
	public PanelMenu() {
		setLayout(null);
		btPlay=new JButton();
		btHelp=new JButton();
		btExit=new JButton();
		btOption=new JButton();
		
		imagePlay=new ImageIcon(getClass().getResource("/image/btplay.png")).getImage();
		imageLevel=new ImageIcon(getClass().getResource("/image/btplay.png")).getImage();
		imageHelp=new ImageIcon(getClass().getResource("/image/bthelp.png")).getImage();
		imageExit=new ImageIcon(getClass().getResource("/image/btexit.png")).getImage();
		imageOption=new ImageIcon(getClass().getResource("/image/btoption.png")).getImage();
		imagePlayC=new ImageIcon(getClass().getResource("/image/btplay1.png")).getImage();
		imageLevelC=new ImageIcon(getClass().getResource("/image/btplay1.png")).getImage();
		imageHelpC=new ImageIcon(getClass().getResource("/image/bthelp1.png")).getImage();
		imageExitC=new ImageIcon(getClass().getResource("/image/btexit1.png")).getImage();
		imageOptionC=new ImageIcon(getClass().getResource("/image/btoption1.png")).getImage();
		
		btPlay.setIcon(new ImageIcon(imagePlay));
		btPlay.setBorderPainted(false);
		btPlay.setContentAreaFilled(false);
		btPlay.setFocusPainted(false);
		
		btHelp.setIcon(new ImageIcon(imageHelp));
		btHelp.setBorderPainted(false);
		btHelp.setContentAreaFilled(false);
		btHelp.setFocusPainted(false);
		
		btOption.setIcon(new ImageIcon(imageOption));
		btOption.setBorderPainted(false);
		btOption.setContentAreaFilled(false);
		btOption.setFocusPainted(false);
		
		btExit.setIcon(new ImageIcon(imageExit));
		btExit.setBorderPainted(false);
		btExit.setContentAreaFilled(false);
		btExit.setFocusPainted(false);
		
		btPlay.setBounds( 50,150,300, 170);
		btHelp.setBounds(btPlay.getX()+125, btPlay.getY()+btPlay.getHeight()-20, btPlay.getWidth()/2, btPlay.getHeight()/2);
		btOption.setBounds(btHelp.getX(), btHelp.getY()+btHelp.getHeight()-20, btPlay.getWidth()/2, btPlay.getHeight()/2);
		btExit.setBounds(btOption.getX(), btOption.getY()+btHelp.getHeight()-20, btPlay.getWidth()/2, btPlay.getHeight()/2);
		
		
		auClick=Applet.newAudioClip(getClass().getResource("/sound/enclick.wav"));
		backGround=new ImageIcon(getClass().getResource("/image/backmenu.png")).getImage();
		
		add(btPlay);
		add(btExit);
		add(btHelp);
		add(btOption);
		btPlay.addMouseListener(evenMouse1);
		btHelp.addMouseListener(evenMouse2);
		btOption.addMouseListener(evenMouse4);
		btExit.addMouseListener(evenMouse5);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(backGround, 0,0,MainFrame.W_MAINFRAME,MainFrame.H_MAINFRAME,null);
	}
	private MouseAdapter evenMouse1 = new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			btPlay.setIcon(new ImageIcon(imagePlayC));
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			btPlay.setIcon(new ImageIcon(imagePlay));
		};
	};
	private MouseAdapter evenMouse2 = new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			btHelp.setIcon(new ImageIcon(imageHelpC));
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			btHelp.setIcon(new ImageIcon(imageHelp));
		};
	};
	private MouseAdapter evenMouse4 = new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			btOption.setIcon(new ImageIcon(imageOptionC));
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			btOption.setIcon(new ImageIcon(imageOption));
		};
	};
	private MouseAdapter evenMouse5 = new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			btExit.setIcon(new ImageIcon(imageExitC));
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			btExit.setIcon(new ImageIcon(imageExit));
		};
	};
	public JButton getBtPlay() {
		return btPlay;
	}
	public JButton getBtExit() {
		return btExit;
	}
	public JButton getBtOption() {
		return btOption;
	}
	public JButton getBtHelp() {
		return btHelp;
	}
	
}
