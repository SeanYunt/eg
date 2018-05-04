package net.yunt;

public class Q4 {
	
	public String itoa(int value, int base) {
		if(value == 0) return "0";
        StringBuilder buffer = new StringBuilder();
        while (value > 0){
        	buffer.append(value % base);
            value = value/base;
        }
        return buffer.reverse().toString();
	}

}
