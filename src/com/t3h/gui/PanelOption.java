package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelOption extends JPanel implements ActionListener{
        private final JButton btQuan1;
	private final JButton btQuan2;
	private JButton btOk;
	private JLabel lbHeart1,lbSpeed1,lbHeart2,lbSpeed2;
	private Image bacGroundLevel,imageBt,imageBt1,imageQuan1,imageQuan2;
	private int check;
	private AudioClip auClick,auButton,auNen;
	public PanelOption() {
		setLayout(null);
		//auClick=Applet.newAudioClip("/sound/enclick.wav");
		check=1;
		bacGroundLevel=new ImageIcon(getClass().getResource("/image/backmenu.png")).getImage();
		imageBt=new ImageIcon(getClass().getResource("/image/btback.png")).getImage();
		imageBt1=new ImageIcon(getClass().getResource("/image/btback1.png")).getImage();
		imageQuan1=new ImageIcon(getClass().getResource("/images/btQuan1.png")).getImage();
		imageQuan2=new ImageIcon(getClass().getResource("/images/btQuan2.png")).getImage();
		btOk=new JButton();
		btOk.setIcon(new ImageIcon(imageBt));	
		btOk.setBorderPainted(false);
		btOk.setContentAreaFilled(false);
		btOk.setFocusPainted(false);
		btQuan1=new JButton();
		btQuan1.setBounds(100, 200, 150, 200);
		btQuan1.setIcon(new ImageIcon(imageQuan1));
                btQuan1.setBorderPainted(false);
		btQuan1.setContentAreaFilled(false);
		btQuan1.setFocusPainted(false);

		btQuan2=new JButton();
		btQuan2.setBounds(btQuan1.getX()+btQuan1.getWidth()+200, btQuan1.getY(), btQuan1.getWidth(), btQuan1.getHeight());
		btQuan2.setIcon(new ImageIcon(imageQuan2));
                btQuan2.setBorderPainted(false);
		btQuan2.setContentAreaFilled(false);
		btQuan2.setFocusPainted(false);
		lbHeart1=new JLabel("Heart : 3");
		lbHeart1.setBounds(btQuan1.getX()+btQuan1.getWidth()+10, btQuan1.getY()+20, 100, 30);
		lbHeart2=new JLabel("Heart : 5");
		lbHeart2.setBounds(btQuan2.getX()+btQuan2.getWidth()+10, btQuan2.getY()+20, 100, 30);
		lbSpeed1=new JLabel("Speed : ");
		lbSpeed1.setBounds(lbHeart1.getX(), lbHeart1.getY()+50, 50, 50);
		lbSpeed2=new JLabel("Speed : ");
		lbSpeed2.setBounds(lbHeart2.getX(), lbHeart2.getY()+50, 50, 50);
		btOk.setBounds(30,MainFrame.H_MAINFRAME-imageBt.getHeight(null)-70,imageBt.getWidth(null),imageBt.getHeight(null));
		add(btQuan1);
		add(btQuan2);
		add(btOk);
		add(lbHeart1);
		add(lbHeart2);
		add(lbSpeed1);
		add(lbSpeed2);
		btQuan1.addActionListener(this);
		btQuan2.addActionListener(this);
		btOk.addActionListener(this);
		btQuan2.addMouseListener(evenMouse2);
		btQuan1.addMouseListener(evenMouse2);
		btOk.addMouseListener(evenMouse1);
		auClick=Applet.newAudioClip(getClass().getResource("/sound/movemouse.wav"));
		auButton=Applet.newAudioClip(getClass().getResource("/sound/movemouse.wav"));
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2d=(Graphics2D)arg0;
		g2d.drawImage(bacGroundLevel, 0, 0,MainFrame.W_MAINFRAME,MainFrame.H_MAINFRAME,null);
	}
	public MouseListener evenMouse1=new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			btOk.setIcon(new ImageIcon(imageBt1));
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			btOk.setIcon(new  ImageIcon(imageBt));
		}
	};
	public MouseListener evenMouse2=new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
		}
	};
	@Override
	public void actionPerformed(ActionEvent g) {
		if(g.getSource()==btQuan1){
			check=1;
		}else if(g.getSource()==btQuan2){
			check=2;
		}
	}
	public int getCheck() {
		return check;
	}
	public JButton getBtOk() {
		return btOk;
	}
}
