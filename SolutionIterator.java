package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionIterator implements Iterator
{
  SolutionList solutionlist;

  int CurrentSolutionNumber=-1;

  public SolutionIterator(SolutionList thesolutionlist)
  {
    solutionlist=thesolutionlist;
    MoveToHead();
  }

  public void MoveToHead()
  {
    CurrentSolutionNumber=-1;
  }

  public boolean hasNext()
  {
    return CurrentSolutionNumber < solutionlist.size() - 1;
  }

  public Object next()
  {
    if (hasNext())
    {
      CurrentSolutionNumber ++;
      return solutionlist.get(CurrentSolutionNumber);
    }
    else
    {
      return null;
    }
  }

  public Object next(String UserName)
  {
    Solution theSolution;
    theSolution=(Solution)next();
    while(theSolution!=null)
    {
      if(UserName.compareTo(theSolution.theAuthor)==0)
      {
        return theSolution;
      }
      theSolution=(Solution)next();
    }
    return null;
  }

  public void remove()
  {
    solutionlist.remove(CurrentSolutionNumber);
  }
}