package hacs;

/*
  Title:        HACS
  Description:  CSE870 Homework 3:  Implementing Design Patterns
  Copyright:    Copyright (c) 2002
  Company:      Department of Computer Science and Engineering, Michigan State University
  @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.util.*;
import java.text.DateFormat;

public class Assignment {

  protected String assName;
  public String strAssignmentFilename;
  public Date dueDate = new Date();
  public String assSpec;
  protected SolutionList theSolutionList = new SolutionList();
  public Solution suggestSolution = new Solution();

  public Assignment(){
  }

  public void setDueDate(Date theDueDate){
    this.dueDate = theDueDate;
  }

  public void setAssSpec(String theSpec){
    this.assSpec = theSpec;
  }

  public boolean isOverDue(){
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  public Solution addSolution(){
    return new Solution();
  }

  ////add the theSolution to the Solutionlist
  public void addSolution(Solution theSolution){
    theSolutionList.add(theSolution);
  }

  public Solution getSolution(String studentname){
    SolutionIterator Iterator = (SolutionIterator)theSolutionList.iterator();
    return (Solution)Iterator.next(studentname);
  }

  public Solution getSugSolution(){
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator(){
    return new SolutionIterator(theSolutionList);
  }

  public String toString(){
    return assName;
  }

  public String getDueDateString(){
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    return dateFormat.format(dueDate);
  }

  public void accept(NodeVisitor visitor){
    visitor.visitAssignment(this);
  }
}
