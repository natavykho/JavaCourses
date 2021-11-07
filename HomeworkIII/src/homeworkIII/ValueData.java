package homeworkIII;

public class ValueData {
	
	private String variable;
	private double value;
	
	public ValueData( String initialVariable, double initialValue) {
		variable = initialVariable;
		value = initialValue;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double newValue) {
		value = newValue;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public void setVariable(String newVariable) {
		variable = newVariable;
	}

}
