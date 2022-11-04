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
		assignmentRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("HighLevel Presentation");
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboxes() {
		assignmentCombox.setBounds(new Rectangle(140, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(assignmentCombox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		assignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentViewButton_actionPerformed(e);
			}
		});
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentTable.setText("AssigmentContent");
		assignmentContentTable.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentTable, null);
	}
}
