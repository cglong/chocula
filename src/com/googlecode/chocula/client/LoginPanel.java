package com.googlecode.chocula.client;

import javax.swing.JPanel;

import com.googlecode.chocula.core.User;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class LoginPanel extends JPanel implements UIInfo {
	private static final long serialVersionUID = -8769915385635939550L;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JButton btnLogin;
	private JLabel lblChocula;
	private JLabel lblWelcomeTo;
	private MainSidebarPanel sidebar;

	/**
	 * Create the panel.
	 */
	private LoginPanel() {
		setBounds(0, 0, WINDOWWIDTH, WINDOWHEIGHT);
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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
		add(lblWelcomeTo, "28, 14");
		
		lblChocula = new JLabel("CHOCULA");
		lblChocula.setFont(lblChocula.getFont().deriveFont(lblChocula.getFont().getStyle() | Font.BOLD, 24f));
		lblChocula.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblChocula, "28, 16");
		
		JLabel lblUsername = new JLabel("Username:");
		add(lblUsername, "26, 28");
		
		textFieldUsername = new JTextField();
		add(textFieldUsername, "28, 28, fill, default");
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "26, 30, right, default");
		
		textFieldPassword = new JPasswordField();
		add(textFieldPassword, "28, 30, fill, default");
		textFieldPassword.setColumns(10);
		textFieldPassword.setEchoChar('¥');
		
		btnLogin = new JButton("Login");
		add(btnLogin, "28, 38");
		btnLogin.addActionListener(new LoginButtonListener());
	}
	
	public LoginPanel(MainSidebarPanel sidebar) {
		this();
		this.sidebar = sidebar;
	}
	
	private class LoginButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = textFieldUsername.getText();
			String password = textFieldPassword.getText();
			Login.getInstance().login(username, password);
			if (Login.getInstance().isLoggedIn()) {
				sidebar.updateButtons();
				textFieldUsername.setText("");
				textFieldPassword.setText("");
			} else if (!Login.getInstance().canTry()) {
				btnLogin.setEnabled(false);
				User user = Storage.getInstance().readUser(username, null);
				if (user != null)
					user.setSuspended(true);
			}
		}
	}
}
