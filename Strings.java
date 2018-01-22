package elementsOfProgrammingInterview;

public class Strings {
	public static void main(String[] args){
		String input = " ";
		char[] inputChar = input.toCharArray();
		reverseWords(inputChar);
		for(int i = 0; i < inputChar.length; i++){
			System.out.print(inputChar[i]);
		}
		lookandsay(6);
		String out = cleanSpaces(inputChar, inputChar.length);
		for(int i = 0; i < out.length(); i++){
			System.out.print(out.charAt(i));
		}
	
	}
	
	public static String convertBase(String numAsString, int b1, int b2){
		boolean isNegative = numAsString.startsWith("-");
		int numAsInt = 0;
		for (int i = (isNegative ? 1 : 0); i < numAsString.length() ; i++){
			numAsInt *= b1;
			numAsInt += Character.isDigit(numAsString.charAt(i))? numAsString.charAt(i) - '0' : numAsString.charAt(i) - 'A'+10;
		}
		
		return (isNegative ? "-": "")+(numAsInt == 0? "0":constructFromBase(numAsInt, b2));
		
	}

	private static String constructFromBase(int numAsInt, int base) {
		return numAsInt == 0? "":constructFromBase(numAsInt/base, base)+ 
				(char)(numAsInt%10 >=10 ? 'A'+ numAsInt%base -10 : '0' + numAsInt%base) ;
	}
	
	public static int spreadSheetColumnEncoding(String col){
		if(col.isEmpty()){ return 0;}
		int val = 0;
		for( int i = 0; i < col.length(); i++){
			val = val * 26 + col.charAt(i) - 'A' + 1;
		}
		return val;
	}
	// time complexity  = O(n)

	private static int replaceAndRemove(int size, char[] str){
		int writeIdx = 0, aCount = 0;
		for(int i = 0; i < size; i++){
			if(str[i] != 'b' ){
				str[writeIdx++] = str[i]; 
			}
			if(str[i] == 'a'){
				++aCount;
			}
		}
		int currIndex = writeIdx - 1;
		writeIdx = writeIdx + aCount - 1;
		final int finalSize = writeIdx + 1;
		while(currIndex >= 0){
			if(str[currIndex] == 'a'){
				str[writeIdx--] = 'd';
				str[writeIdx--] = 'd';
			}else{
				str[writeIdx--] = str[currIndex];
			}
			--currIndex;
		}
		return finalSize;
		
	}
	
	private static void reverseWords(char[] input){
		
		int n = input.length;
		
		reverse(input, 0, n-1);
		int start = 0, end = 0;
		while(start < n ){
			
			while((start <= end && start < n) && input[start] == ' '){
				++start;
			}
			while((start <= end && end < n )&& input[end] != ' '){
				++end;
			}
			reverse(input, start, end - 1);
			start = end + 1;
			end = end + 1;
		}
	}
	static void lookandsay(int n){
		String s = "1"; 
		for(int i = 0; i < n; i ++){
		    s = lookAndSayHealper(s);
		}
		for( int i = 0 ; i < s.length() ; i++){
		    System.out.print(s.charAt(i) + " " );
		}
		System.out.println();
	}
	static String lookAndSayHealper(String s){
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < s.length(); i++){
	        int count = 1;
	        while( i+1 < s.length() && s.charAt(i) == s.charAt(i+1)){
	            i = i+1;
	            count++;
	        }
	        sb.append(count);
	        sb.append(s.charAt(i));
	    }
	    return sb.toString();   
	}
	static String cleanSpaces(char[] a, int n) {
	    int i = 0, j = 0;      
		    while (j < n) {
		    	while (j < n && a[j] == ' ') j++;             // skip spaces
		    	while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
		    	while (j < n && a[j] == ' ') j++;             // skip spaces
		    	if (j < n) a[i++] = ' ';                      // keep only one space
		    }
		    return new String(a).substring(0, i);
	}
	private static void reverse(char[] input, int start, int end) {
		while(start < end){
			char tmp = input[start];
			input[start++] = input[end];
			input[end--] = tmp;
		}
	}
}