package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class CourseMenu extends JDialog
{
  Course theCourse;
  public boolean bLogout = true;

  JRadioButton assignmentRadio = new JRadioButton();
  JComboBox assignmentCombox = new JComboBox();
  JButton assignmentViewButton = new JButton();
  JButton assignmentAddButton = new JButton();
  JRadioButton optionRadio = new JRadioButton();
  JLabel assignmentContentTable = new JLabel();
  JComboBox optionCombo = new JComboBox();
  JButton optionViewButton = new JButton();
  JButton optionAddButton = new JButton();
  JButton buttonChangeCourse = new JButton();
  JButton buttonLogout = new JButton();

  int x;
  int y;
  int width;
  int height;

  public CourseMenu() {

    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    setModal(true);
    int width = 503;
    int height = 294;
    setSize(width,height);
  }

  private void jbInit() throws Exception {
    buttonChangeCourse.setText("ChangeCourse");
    x = 101;
    y = 211;
    width = 73;
    height = 37;
    buttonChangeCourse.setBounds(new Rectangle(x, y, width, height));
    buttonChangeCourse.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonChangeCourse_actionPerformed(e);
      }
    });
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("Logout");
    x = 267;
    y = 215;
    width = 73;
    height = 37;
    buttonLogout.setBounds(new Rectangle(x, y, width, height));
    buttonLogout.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonLogout_actionPerformed(e);
      }
    });
    this.getContentPane().add(buttonChangeCourse, null);
    this.getContentPane().add(buttonLogout, null);
  }

  /* when the add button is pressed, call add assignment
  function of facade, after that refresh window
  */

  /* when the add button is pressed, call ViewAssignment
  function of facade, after that refresh window
  */

  abstract void showMenu(Course theCourse);
  abstract void showAddButtons();
  abstract void showViewButtons();
  abstract void showRadios();
  abstract void showComboxes();
  abstract void showLabel();

  void assignmentAddButton_actionPerformed(ActionEvent e)
  {
    Hacs.theFacade.addAssignment(theCourse);
    refresh();
  }
  void assignmentViewButton_actionPerformed(ActionEvent e)
  {
    Assignment theAss=(Assignment)assignmentCombox.getSelectedItem() ;
    Hacs.theFacade.viewAssignment(theAss);
  }
  void refresh()
  {
    assignmentCombox.removeAllItems() ;
    for (Assignment assignment : theCourse.assignmentList) {
      assignmentCombox.addItem(assignment);
    }
  }

  void buttonChangeCourse_actionPerformed(ActionEvent e)
  {
    bLogout=false;
    dispose();
  }

  void buttonLogout_actionPerformed(ActionEvent e)
  {
    bLogout=true;
    dispose();
  }
  boolean ifLogout() {
    return bLogout;
  }
}
