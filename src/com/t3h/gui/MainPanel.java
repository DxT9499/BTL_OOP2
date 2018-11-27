package com.t3h.gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.t3h.quan.QuanTa;

public class MainPanel extends JPanel{
	private FrameGame game;
	private PanelOption option;
	private PanelHelp help;
	private PanelMenu menu;
	private CardLayout cardLayout;
	private AudioClip auNen,auButTon,auStart;

	public MainPanel() {
		cardLayout=new CardLayout();
		setLayout(cardLayout);
		menu=new PanelMenu();
		option=new PanelOption();
		help=new PanelHelp();
		add(menu);
		add(help);
		add(option);
		auNen=Applet.newAudioClip(getClass().getResource("/sound/nen.wav"));
		auButTon=Applet.newAudioClip(getClass().getResource("/sound/enclick.wav"));
		auStart=Applet.newAudioClip(getClass().getResource("/sound/click.wav"));
		auNen.loop();
		auNen.play();
		setVisible(true);
		menu.setVisible(true);
		evenMouse();
	}

	private void evenMouse() {
		menu.getBtPlay().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				auStart.play();
				auNen.stop();
				game=new FrameGame(option.getCheck());
				game.setVisible(true);
                                menu.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				auButTon.play();
			}
		});
		menu.getBtHelp().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				auStart.play();
				help.setVisible(true);
				menu.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				auButTon.play();
			}
		});
		help.getBtOk().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				auStart.play();
				help.setVisible(false);
				menu.setVisible(true);
				auNen.play();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				auButTon.play();
			}
		});
		menu.getBtOption().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				auStart.play();
				option.setVisible(true);
				menu.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				auButTon.play();
			}
		});
		option.getBtOk().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				auStart.play();
				auNen.play();
				option.setVisible(false);
				menu.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				auButTon.play();
			}
		});
		menu.getBtExit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				auButTon.play();
			}
		});

	}
}
