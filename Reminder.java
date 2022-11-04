package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class Reminder extends JDialog {
	ClassCourseList courseList;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	java.awt.List listUpcoming = new java.awt.List();
	java.awt.List listOverdue = new java.awt.List();
	Button buttonOK = new Button();

	int x, y, width, height;

	public Reminder() {
		try {
			jbInit();
			setModal(true);
			width = 400;
			height = 386;
			setSize(width, height);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Upcoming assignments");
		x = 38;
		y = 40;
		width = 159;
		height = 17;
		jLabel1.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().setLayout(null);
		jLabel2.setText("OverDue Assignments");
		x = 39;
		y = 160;
		width = 161;
		height = 17;
		jLabel2.setBounds(new Rectangle(x, y, width, height));
		x = 29;
		y = 65;
		width = 340;
		height = 79;
		listUpcoming.setBounds(new Rectangle(x, y, width, height));
		x = 31;
		y = 187;
		width = 337;
		height = 85;
		listOverdue.setBounds(new Rectangle(x, y, width, height));
		buttonOK.setLabel("OK");
		x = 149;
		y = 308;
		width = 67;
		height = 37;
		buttonOK.setBounds(new Rectangle(x, y, width, height));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOK_actionPerformed(e);
			}
		});
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(listUpcoming, null);
		this.getContentPane().add(listOverdue, null);
		this.getContentPane().add(buttonOK, null);
	}

	void showReminder(ClassCourseList courseList) {
		Assignment assignment;
		ReminderVisitor visitor = new ReminderVisitor(this);
		visitor.visitFacade(Hacs.theFacade);
		setVisible(true);
	}

	void buttonOK_actionPerformed(ActionEvent e) {
		dispose();
	}
}
