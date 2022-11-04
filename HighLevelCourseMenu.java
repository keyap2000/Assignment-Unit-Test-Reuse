package hacs;

import java.awt.*;
import java.awt.event.*;

public class HighLevelCourseMenu extends CourseMenu {

	/*
	 * JButton assignmentAddButton = new JButton(); JRadioButton optionRadio = new
	 * JRadioButton(); JComboBox optionCombo = new JComboBox(); JButton
	 * optionViewButton = new JButton(); JButton optionAddButton = new JButton();
	 */

	public HighLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		showViewButtons();
		showRadios();
		showComboxes();
		setVisible(true);
	}

	void showAddButtons() {

		int x, y, width, height;
		assignmentAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentAddButton_actionPerformed(e);
			}
		});
		assignmentAddButton.setText("Add");
		x = 389;
		y = 54;
		width = 79;
		height = 29;
		assignmentAddButton.setBounds(new Rectangle(x, y, width, height));
		optionAddButton.setText("Add");
		x = 390;
		y = 125;
		width = 79;
		height = 29;
		optionAddButton.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		x = 21;
		y = 55;
		width = 103;
		height = 26;
		assignmentRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("HighLevel Presentation");
		x = 21;
		y = 128;
		width = 103;
		height = 26;
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboxes() {
		x = 140;
		y = 57;
		width = 126;
		height = 22;
		assignmentCombox.setBounds(new Rectangle(x, y, width, height));
		x = 137;
		y = 127;
		width = 126;
		height = 22;
		optionCombo.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().add(assignmentCombox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		x = 290;
		y = 54;
		width = 79;
		height = 29;
		assignmentViewButton.setBounds(new Rectangle(x, y, width, height));
		assignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentViewButton_actionPerformed(e);
			}
		});
		optionViewButton.setText("View");
		x = 290;
		y = 124;
		width = 79;
		height = 29;
		optionViewButton.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentTable.setText("AssigmentContent");
		x = 23;
		y = 186;
		width = 432;
		height = 99;
		assignmentContentTable.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().add(assignmentContentTable, null);
	}
}
