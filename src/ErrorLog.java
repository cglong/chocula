import java.util.ArrayList;

public class ErrorLog {
	private static ArrayList<ErrorEntry> errors;
	
	public void unexpectedException(Exception e) {
		newException(e);
	}
	
	public void expectedException(Exception e) {
		newException(e);
		// TODO Display dialog window with message
	}
	
	private void newException(Exception e) {
		ErrorEntry errorEntry = new ErrorEntry(e);
		errors.add(errorEntry);
	}
	
	private class ErrorEntry {
		@SuppressWarnings("unused")
		private Exception e;
		
		public ErrorEntry(Exception e) {
			this.e = e;
		}
	}
}
