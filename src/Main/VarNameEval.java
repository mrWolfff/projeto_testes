package Main;

public class VarNameEval {
	public boolean isValid(String varName) {
				
		if(!Character.isLowerCase(varName.charAt(0)))
			return false;
		
		if(!varName.matches("[a-zA-Z0-9_]+"))
			return false;			
			
		return true;
	}
}
