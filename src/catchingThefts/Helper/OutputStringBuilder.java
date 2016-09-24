package catchingThefts.Helper;

public final class OutputStringBuilder{

	public static String charArrTo(char[] arr){
		String output = "";
		for (char c : arr) {
			output+=c;
		}
		return output;
	}
	
	public static String toStringWithWhitespace(String grid){
		char[] lines = grid.toCharArray();
		String output = "";
		
		for (int j = 0; j < lines.length; j++) {
			output += lines[j] + " ";
		}
		return output;
	}
}

