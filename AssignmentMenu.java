package hacs;

import javax.swing.*;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class AssignmentMenu extends JDialog
{
  abstract void showMenu(Assignment ass,Person per);
  public AssignmentMenu()
  {
    setModal(true);
    int width = 575;
    int height = 330;
    setSize(width,height);
  }
}
