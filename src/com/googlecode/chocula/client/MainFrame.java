package com.googlecode.chocula.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class MainFrame extends JFrame implements UIInfo {
	private static final long serialVersionUID = -2615930573557561194L;
	final static String LOGINPANEL = "Login";
	
	private JPanel contentPane;
	private JPanel cards;
	private LoginPanel loginPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setTitle("Chocula");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		MainSidebarPanel sidebarPanel = new MainSidebarPanel(this);
		contentPane.add(sidebarPanel, BorderLayout.WEST);
		
		cards = new JPanel(new CardLayout(0, 0));
		
		loginPanel = new LoginPanel(sidebarPanel);
		cards.add(loginPanel, LOGINPANEL);
		contentPane.add(cards, BorderLayout.CENTER);
	}
	
	public void showNewPanel(JPanel panel, String name) {
		cards.add(panel, name);
		CardLayout c = (CardLayout)(cards.getLayout());
		c.show(cards, name);
	}
}
