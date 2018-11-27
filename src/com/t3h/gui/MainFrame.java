package com.t3h.gui;

import java.awt.Frame;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public static final int W_MAINFRAME = 700;
	public static final int H_MAINFRAME = 600;

	public MainFrame() {
		// TODO Auto-generated constructor stub
		setSize(W_MAINFRAME,H_MAINFRAME);
		setLocationRelativeTo(null);
		setResizable(false);
		this.add(new PanelMenu());
		add(new MainPanel());
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
