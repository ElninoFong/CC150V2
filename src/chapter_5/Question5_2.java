package chapter_5;

/*
 * 5.2 
 * Given a real number between 0 and 1 (eg, 0.72) that is passed in as a double, print the binary representation. 
 * If the number cannot be represented accuratedly in binary with at most 32 characters, print "ERROR".
 */
public class Question5_2 {
	public static String printBinary(double num) {
		if (num >= 1 || num <= 0) return "ERROR";
		
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		
		while (sb.length() <= 32 && num > 0) {
			num *= 2;
			if (num >= 1) {		// err: num > 1
				sb.append(1);
				num -= 1;
			} else {
				sb.append(0);
			}
		}
		
		if (sb.length() > 32) return "ERROR";
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
        String bs = printBinary(.125);
        System.out.println(bs);
        
        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinary(num);
            String binary2 = printBinary(num);
            if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
                    System.out.println(num + " : " + binary + " " + binary2);
            }
        }
	}
}
