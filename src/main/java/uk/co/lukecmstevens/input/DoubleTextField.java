package uk.co.lukecmstevens.input;

public class DoubleTextField extends RegexLimitedTextField<Double>{
	
	public DoubleTextField() {
		super("(([1-9][0-9]*)|0)?(\\.[0-9]*)?");
	}
    
    @Override
    public Double getValue(){
    	String text = getText();
    	if(text == null || text.isEmpty()) return -1.0;
    	else return Double.parseDouble(text);
    }

}
