package hacs;

import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Jave 8
 */

public class Facade {
	public int userType;
	private Course theSelectedCourse = null;
	public int nCourseLevel = 0;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
	}

	static public boolean login(UserInfoItem userinfoItem) throws RuntimeException {
		Login login;
		try{
			login = new Login();
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.userType = login.GetUserType();
		return login.isExit();
	}

//functions for CourseMenu
	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	public void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	public void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

//functions for InstructorAssignmentMenu
	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	public void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(theSolution);
	}

	public void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	public void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	public void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.GetCourseList());
	}

	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student)
		{
			thePerson = new Student();
		} else /// instructor
		{
			thePerson = new Instructor();
		}
		thePerson.userName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	public void createCourseList() throws IOException {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	public void attachCourseToUser() throws IOException {
		BufferedReader file;

		file = new BufferedReader(new FileReader("UserCourse.txt"));
		String aline, strUserName, strCourseName;
		while ((aline = file.readLine()) != null)
		{
			strUserName = getUserName(aline);
			strCourseName = getCourseName(aline);
			if (strUserName.compareTo(thePerson.userName) == 0) /// the userName matches
				{
					theSelectedCourse = findCourseByCourseName(strCourseName);
					if (theSelectedCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.AddCourse(theSelectedCourse);
					}
				}

		}
	}

	/*
	 * get the user name from aline userName:CourseName
	 */
	public String getUserName(String aline) {
		int sep = aline.lastIndexOf(':');
		int initialIndex = 0;
		return aline.substring(initialIndex, sep);
	}

	/*
	 * get the CourseName from aline userName:CourseName
	 */
	public String getCourseName(String aline) {
		int sep = aline.lastIndexOf(':');
		int nextIndex = 1;
		return aline.substring(sep + nextIndex, aline.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelectedCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelectedCourse = theDlg.showDlg(thePerson.courseList);
		thePerson.currentCourse = theSelectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		thePerson.CreateCourseMenu(theSelectedCourse, nCourseLevel);
		return thePerson.ShowMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	public Course findCourseByCourseName(String strCourseName) {
		CourseIterator iterator = new CourseIterator(theCourseList);
		return (Course) iterator.next(strCourseName);
	}
}
