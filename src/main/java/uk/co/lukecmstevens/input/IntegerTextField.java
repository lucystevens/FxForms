package uk.co.lukecmstevens.input;

public class IntegerTextField extends RegexLimitedTextField<Integer>{
	
	public IntegerTextField() {
		super("\\d*");
	}
    
    @Override
    public Integer getValue(){
    	String text = getText();
    	if(text == null || text.isEmpty()) return -1;
    	else return Integer.parseInt(text);
    }

}
