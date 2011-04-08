package com.googlecode.chocula.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame implements UIInfo {

	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		updateLoggedInPanel();
	}
	
	private void updateLoggedInPanel() {
		if (Login.getInstance().isLoggedIn()) {
			MainSidebarPanel sidebarPanel = new MainSidebarPanel();
			contentPane.add(sidebarPanel, BorderLayout.WEST);
			
			JLabel welcomeLabel = new JLabel("Welcome to Chocula!");
			welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(welcomeLabel, BorderLayout.CENTER);
		} else {
			LoginPanel loginPanel = new LoginPanel();
			contentPane.add(loginPanel, BorderLayout.CENTER);
		}
	}
}
