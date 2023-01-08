package validation;

import custom_exception.EmpNotFoundExc;
import com.app.org.*;

public class ValidateEmpId {
	int retIndex;

	public static int EmpIdValidate(int id, Emp[] emp) throws EmpNotFoundExc {
		for (int i = 0; i < emp.length; i++) {
			if (id == emp[i].getId()) {
				return i;
			}
		}
		throw new EmpNotFoundExc("Employee doesn't exist");
	}

	public static boolean nameValidate(String fn, String ln, Emp[] empl) throws EmpNotFoundExc {
		for (Emp e : empl) {
			if (e instanceof Mgr) {
				Emp anotherMgr = new Mgr(fn, ln);
//				Emp.decreCount();
				if (e.equals((Emp) anotherMgr)) {
					return true;
				}
//				else
//					return false;
			} else if (e instanceof Worker) {
				Emp anotherWrk = new Worker(fn, ln);
//				Emp.decreCount();
				if (e.equals((Emp) anotherWrk)) {
					return true;
				}
//				else
//					return false;
			}
		}
		throw new EmpNotFoundExc("Employee doesn't exist");
	}
}