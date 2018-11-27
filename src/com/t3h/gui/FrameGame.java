package com.t3h.gui;

import javax.swing.JFrame;

public class FrameGame extends JFrame{
	public static final int W_GAME = 1350;
	public static final int H_GAME = 630;
	private PanelGame game;
	public FrameGame(int x) {
		setSize(W_GAME+18,H_GAME+45);
		game = new PanelGame();
		game.setCheckQuan(x);
		game.initGame();
		add(game);
		setLocationRelativeTo(null);
                setUndecorated(false);
                setVisible(true);
	}
}
