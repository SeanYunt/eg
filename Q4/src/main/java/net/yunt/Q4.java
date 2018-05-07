package net.yunt;

public class Q4 {
	
	public String itoa(int value, int base) {
		if(value == 0) return "0";
    	StringBuilder buffer = new StringBuilder();
		boolean negative = false;
		if(value < 0) {
			negative = true;
			value = 0 - value;
		}
		 
		while(value > 0) {
    		buffer.append(value % base);
    		value = value/base;
		}

		if(negative) {
			buffer.append('-');
		}
		return buffer.reverse().toString().trim();
	}
}