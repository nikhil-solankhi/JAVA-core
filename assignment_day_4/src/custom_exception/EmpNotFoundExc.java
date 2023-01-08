package custom_exception;

@SuppressWarnings("serial")
public class EmpNotFoundExc extends Exception {
	public EmpNotFoundExc(String mesg) {
		super(mesg);
	}

}
