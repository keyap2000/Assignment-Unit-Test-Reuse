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

public class SolutionGradingDlg extends JDialog {
	Solution theSolution;
	JLabel jLabel1 = new JLabel();
	JTextField tfGrad = new JTextField();
	JButton buttonOK = new JButton();
	JLabel labelSolutionFileName = new JLabel();

	int x, y, width, height;

	public SolutionGradingDlg() {
		try {
			jbInit();
			width = 316;
			height = 186;
			setSize(width, height);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Solution File Name");
		x = 23;
		y = 30;
		width = 121;
		height = 18;
		jLabel1.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().setLayout(null);
		x = 25;
		y = 66;
		width = 100;
		height = 22;
		tfGrad.setBounds(new Rectangle(x, y, width, height));
		buttonOK.setText("OK");
		x = 217;
		y = 67;
		width = 79;
		height = 29;
		buttonOK.setBounds(new Rectangle(x, y, width, height));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOK_actionPerformed(e);
			}
		});
		x = 212;
		y = 34;
		width = 163;
		height = 18;
		labelSolutionFileName.setBounds(new Rectangle(x, y, width, height));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tfGrad, null);
		this.getContentPane().add(labelSolutionFileName, null);
		this.getContentPane().add(buttonOK, null);
	}

	void show(Solution solution) {
		theSolution = solution;
		tfGrad.setText("" + theSolution.getGradeInt());
		labelSolutionFileName.setText(theSolution.solutionFileName);
		setVisible(true);
	}

	void buttonOK_actionPerformed(ActionEvent e) {
		theSolution.theGrade = Integer.parseInt(tfGrad.getText());
		dispose();
	}
}
