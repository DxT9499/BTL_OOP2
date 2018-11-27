package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelHelp extends JPanel implements ActionListener{
	private JButton btOk;
	private Image imageBack,imageBack2,imageBackground;
	private AudioClip auClick;
	public PanelHelp() {
		setLayout(null);
		imageBack=new ImageIcon(getClass().getResource("/image/btback1.png")).getImage();
		imageBack2=new ImageIcon(getClass().getResource("/image/btback.png")).getImage();
		imageBackground=new ImageIcon(getClass().getResource("/image/backmenu.png")).getImage();
		
		auClick=Applet.newAudioClip(getClass().getResource("/sound/enclick.wav"));
		
		btOk=new JButton();
		btOk.setIcon(new ImageIcon(imageBack));	
		btOk.setBorderPainted(false);
		btOk.setContentAreaFilled(false);
		btOk.setFocusPainted(false);
		btOk.setBounds(30,MainFrame.H_MAINFRAME-imageBack.getHeight(null)-70,imageBack.getWidth(null),imageBack.getHeight(null));
		btOk.addMouseListener(evenMouse1);
		btOk.addActionListener(this);
		this.add(btOk);
	}
	public MouseListener evenMouse1=new MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent e) {
			btOk.setIcon(new ImageIcon(imageBack2));
			auClick.play();
		};

		public void mouseExited(java.awt.event.MouseEvent e) {
			btOk.setIcon(new ImageIcon(imageBack));
		}
	};
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2d=(Graphics2D )arg0;
		g2d.drawImage(imageBackground, 0, 0, MainFrame.W_MAINFRAME, MainFrame.H_MAINFRAME,null);
	}

	public JButton getBtOk() {
		return btOk;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
