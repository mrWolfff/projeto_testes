package Main;

public class ConstNameEval {
	public boolean isValid(String varName) {
		for(int i = 0; i < varName.length(); i++) {
			if(!Character.isUpperCase(varName.charAt(i)))
				return false;
		
		}	
		if(!varName.matches("[a-zA-Z0-9_]+"))
			return false;			
			
		return true;
	}
}
