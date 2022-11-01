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

public class CourseIterator implements Iterator
{
  ClassCourseList theCourseList;
  int CurrentCourseNumber=-1;

  public CourseIterator(ClassCourseList courseList)
  {
    theCourseList=courseList;
  }

  public boolean hasNext()
  {
    return CurrentCourseNumber < theCourseList.size() - 1;
  }

  public Object next()
  {
    if (hasNext())
    {
      CurrentCourseNumber ++;
      return theCourseList.get(CurrentCourseNumber);
    }
    else
    {
      return null;
    }
  }
  public void remove()
  {
    theCourseList.remove(CurrentCourseNumber);
  }

// the next Course that fits the given CourseName
  public Object next(String CourseName)
  {
    Course theCourse;
    theCourse=(Course)next();
    while(theCourse!=null)
    {
      if(CourseName.compareTo(theCourse.toString())==0)
      {
        return theCourse;
      }
      theCourse=(Course)next();
    }
    return null;
  }


}