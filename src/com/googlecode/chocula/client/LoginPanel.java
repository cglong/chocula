package com.googlecode.chocula.client;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel implements UIInfo {
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private JLabel lblChocula;
	private JLabel lblWelcomeTo;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBounds(0, 0, WINDOWWIDTH/2, WINDOWHEIGHT/2);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblWelcomeTo = new JLabel("Welcome to");
		lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWelcomeTo, "10, 6");
		
		lblChocula = new JLabel("CHOCULA");
		lblChocula.setHorizontalAlignment(SwingConstants.CENTER);
		lblChocula.setFont(lblChocula.getFont().deriveFont(lblChocula.getFont().getStyle() | Font.BOLD, 24f));
		add(lblChocula, "10, 8");
		
		JLabel lblUsername = new JLabel("Username:");
		add(lblUsername, "8, 14, right, default");
		
		textFieldUsername = new JTextField();
		add(textFieldUsername, "10, 14, fill, default");
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "8, 16, right, default");
		
		textFieldPassword = new JTextField();
		add(textFieldPassword, "10, 16, fill, default");
		textFieldPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		add(btnLogin, "10, 22, center, center");
	}

}
