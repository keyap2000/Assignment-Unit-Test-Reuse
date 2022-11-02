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
  protected String strAssignmentFilename;
  protected Date dueDate = new Date();
  protected String assSpec;
  protected SolutionList theSolutionList = new SolutionList();
  public Solution suggestSolution = new Solution();

  public Assignment(){
  }

  public Assignment(String assignmentName, Date deadline, Solution suggestedSolution){

  }

  public void SetDueDate(Date theDueDate){
    this.dueDate = theDueDate;
  }

  public void SetAssSpec(String theSpec){
    this.assSpec = theSpec;
  }

  public boolean IsOverDue(){
    Date today;
    today = new Date();
    return today.after(this.dueDate);
  }

  public Solution AddSolution(){
    return new Solution();
  }

  ////add the theSolution to the Solutionlist
  public void AddSolution(Solution theSolution){
    theSolutionList.add(theSolution);
  }

  public void SubmitSolution(){
  }

  public void getSolutionList(){
  }

  public Solution getSolution(String studentname){
    SolutionIterator Iterator = (SolutionIterator)theSolutionList.iterator();
    return (Solution)Iterator.next(studentname);
  }

  public Solution getSugSolution(){
    return suggestSolution;
  }

  public SolutionIterator GetSolutionIterator(){
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