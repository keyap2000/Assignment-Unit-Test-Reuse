package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 * Update to Java 8
 */

public class Hacs{

	static Facade theFacade = new Facade();

	public Hacs() {
	}

	public static void main(String[] args) {
		UserInfoItem userinfoitem = new UserInfoItem();
		theFacade.CreateCourseList();
		while (true) {
			boolean bExit = false;
			bExit = theFacade.Login(userinfoitem);
			if (bExit)
				break;
			theFacade.CreateUser(userinfoitem);
			theFacade.AttachCourseToUser();
			if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student)
				theFacade.Remind();
			boolean blogout = false;
			while (!blogout) {
				blogout = theFacade.SelectCourse();
				if (blogout)
					break;
				blogout = theFacade.CourseOperation();
			}
		}
	}
}