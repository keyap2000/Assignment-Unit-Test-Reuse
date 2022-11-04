package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class CourseSelectDlg extends JDialog {
	// 0 HighLevel presentation 1 LowLevel Experiment
	ClassCourseList theCourseList;
	Course selectedCourse;
	int nCourseLevel = 0;
	boolean m_bLogout = false;
	JComboBox courseNameCom = new JComboBox();
	JRadioButton highLevelRadio = new JRadioButton();
	JRadioButton lowLevelRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton okButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();
	int x, y, width, height;

	public CourseSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		x = 155;
		y = 41;
		width = 203;
		height = 22;
		courseNameCom.setBounds(new Rectangle(x, y, width, height));
		highLevelRadio.setText("HighLevel");
		x = 50;
		y = 87;
		width = 103;
		height = 26;
		highLevelRadio.setBounds(new Rectangle(x, y, width, height));
		lowLevelRadio.setToolTipText("");
		lowLevelRadio.setSelected(true);
		lowLevelRadio.setText("LowLevel");
		x = 236;
		y = 88;
		width = 103;
		height = 26;
		lowLevelRadio.setBounds(new Rectangle(x, y, width, height));
		jLabel1.setText("CourseName");
		x = 39;
		y = 44;
		width = 85;
		height = 18;
		jLabel1.setBounds(new Rectangle(x, y, width, height));
		okButton.setText("OK");
		x = 78;
		y = 139;
		width = 79;
		height = 29;
		okButton.setBounds(new Rectangle(x, y, width, height));
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okButton_actionPerformed(e);
			}
		});
		buttonLogout.setText("Logout");
		x = 224;
		y = 140;
		width = 73;
		height = 31;
		buttonLogout.setBounds(new Rectangle(x, y, width, height));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(courseNameCom, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(highLevelRadio, null);
		this.getContentPane().add(lowLevelRadio, null);
		this.getContentPane().add(okButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(highLevelRadio);
		buttonGroup1.add(lowLevelRadio);
	}

	/*
	 * show the theCourseList in a combox Show the Course type selection button
	 * return the pointer pointing to the Course object return the Course Type
	 */

	public Course showDlg(ClassCourseList courseList) {

		theCourseList = courseList;
		CourseIterator theIterator = new CourseIterator(theCourseList);
		Course theCourse;
		while ((theCourse = (Course) theIterator.next()) != null) /// end of the list
		{
			courseNameCom.addItem(theCourse);
		}
		setVisible(true);
		return selectedCourse;
	}

	void okButton_actionPerformed(ActionEvent e) {
		selectedCourse = (Course) courseNameCom.getSelectedItem();
		if (highLevelRadio.isSelected())
			nCourseLevel = 0;
		else
			nCourseLevel = 1;
		dispose();
	}

	public boolean isLogout() {
		return m_bLogout;
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		m_bLogout = true;
		dispose();
	}
}
