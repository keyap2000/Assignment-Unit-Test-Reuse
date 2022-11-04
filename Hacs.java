package hacs;

import java.io.IOException;

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

	public static void main(String[] args) throws IOException {
		UserInfoItem userinfoitem = new UserInfoItem();
		theFacade.createCourseList();
		while (true) {
			boolean bExit = false;
			bExit = theFacade.login(userinfoitem);
			if (bExit)
				break;
			theFacade.createUser(userinfoitem);
			theFacade.attachCourseToUser();
			if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student)
				theFacade.remind();
			boolean blogout = false;
			while (!blogout) {
				blogout = theFacade.selectCourse();
				if (blogout)
					break;
				blogout = theFacade.courseOperation();
			}
		}
	}
}
