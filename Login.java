package hacs;

import javax.swing.*;

import hacs.UserInfoItem.USER_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Java 8
 */

public class Login extends JDialog {

	boolean m_bExit = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField userNameText = new JTextField();
	JPasswordField passwordText = new JPasswordField();
	JRadioButton studentRadio = new JRadioButton();
	JRadioButton instructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
////// Attributes Added By me
	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student;

	int x, y, width, height;

	public Login() {
		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			System.out.println("invalid");
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		x = 26;
		y = 52;
		width = 80;
		height = 18;
		jLabel1.setBounds(new Rectangle(x, y, width, height));
		jLabel2.setText("Password");
		x = 23;
		y = 119;
		width = 80;
		height = 18;
		jLabel2.setBounds(new Rectangle(x, y, width, height));
		loginButton.setText("Login");
		x = 31;
		y = 212;
		width = 85;
		height = 28;
		loginButton.setBounds(new Rectangle(x, y, width, height));
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginButton_actionPerformed(e);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}
		});
		buttonExit.setText("Exit");
		x = 180;
		y = 211;
		width = 97;
		height = 28;
		buttonExit.setBounds(new Rectangle(x, y, width, height));
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonExit_actionPerformed(e);
			}
		});
		x = 119;
		y = 52;
		width = 144;
		height = 22;
		userNameText.setBounds(new Rectangle(x, y, width, height));
		x = 118;
		y = 119;
		width = 147;
		height = 22;
		passwordText.setBounds(new Rectangle(x, y, width, height));
		studentRadio.setSelected(true);
		studentRadio.setText("Student");
		x = 37;
		y = 164;
		width = 103;
		height = 26;
		studentRadio.setBounds(new Rectangle(x, y, width, height));
		instructorRadio.setText("Instructor");
		x = 177;
		y = 162;
		width = 103;
		height = 26;
		instructorRadio.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(userNameText, null);
		this.getContentPane().add(passwordText, null);
		this.getContentPane().add(studentRadio, null);
		this.getContentPane().add(instructorRadio, null);
		buttonGroup1.add(studentRadio);
		buttonGroup1.add(instructorRadio);
	}

	void loginButton_actionPerformed(ActionEvent e) throws Exception {
		BufferedReader file;
		m_bExit = false;
		System.out.println("login clicked");
		try {
			if (studentRadio.isSelected()) {
				userType = USER_TYPE.Student;
				file = new BufferedReader(new FileReader("StuInfo.txt"));
				userBox = userNameText.getText();
				String PasswordBox = new String(passwordText.getPassword());
				String LoginName = null;
				String aline = null, UserName = null, Password = null;
				while ((aline = file.readLine()) != null) {
					UserName = getUserName(aline);
					Password = getPassword(aline);
					if (UserName.compareTo(userBox) == 0 && Password.compareTo(PasswordBox) == 0)
						LoginName = UserName;
				}
				if (LoginName != null) {
					this.dispose();
				}
			} else {
				userType = USER_TYPE.Instructor;
				try {
				file = new BufferedReader(new FileReader("InsInfor.txt"));
					userBox = userNameText.getText();
					String PasswordBox = new String(passwordText.getPassword());
					String LoginName = null;
					String aline = null, UserName = null, Password = null;
					while ((aline = file.readLine()) != null) {
						UserName = getUserName(aline);
						Password = getPassword(aline);
						if (UserName.compareTo(userBox) == 0 && Password.compareTo(PasswordBox) == 0)
							LoginName = UserName;
					}
					if (LoginName != null) {
						this.dispose();
					} else {
						m_bExit = true;
						//isExit();
						//buttonExit_actionPerformed(e);
						throw new Exception("Invalid credentials");
					}

				}
				catch (RuntimeException exception) {
					System.out.println("invalid credentials");
					dispose();
				}
				catch (FileNotFoundException ex) {
					System.out.println("file not found exception");
					dispose();
				}
			}


		} catch (Exception ee) {
			throw ee;
		}

	}

	/*
	 * get the user name from aline UserName:Password
	 */
	private String getUserName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(0, sep);
	}

	/*
	 * get the password from aline UserName:Password
	 */
	private String getPassword(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(sep + 1, aline.length());
	}

	/* after login get the UserName of the login interface */
	public String getUserName() {
		return userBox;
	}

	/* after login get the userType of the login interface */
	public USER_TYPE getUserType() {
		return userType;
	}

	public boolean isExit() {
		return m_bExit;
	}

	void buttonExit_actionPerformed(ActionEvent e) {
		m_bExit = true;
		dispose();
	}
}
