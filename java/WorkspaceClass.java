public class WorkspaceClass{
	public String normalizeDiscountCode(String discountCode) {
	    String codeUpperCase = "";
	    for (char codeDigit : discountCode.toCharArray()) {
	    	if (!Character.isLetter(codeDigit) && codeDigit != '$') {
	    		throw new IllegalArgumentException(codeDigit + " is not an authorize digit");
	    	}
	    	codeUpperCase += Character.toUpperCase(codeDigit);
	    }
    	return codeUpperCase;
	}
}