package elementsOfProgrammingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {
	
	public static List<Integer> multiplyArray( List<Integer> num1, List<Integer> num2){
		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1; 
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));
		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() +num2.size(), 0));
		for(int i = num1.size() - 1; i >= 0; i-- ){
			for(int j = num2.size() - 1; j >= 0; j--){
				result.set(i+j+1, result.get(i+j+1) + (num1.get(i) * num2.get(j)));
				result.set(i+j, result.get(i+j) + result.get(i+j+1) / 10);
				result.set(i+j+1, result.get(i+j+1) % 10);
			}
		}
		int check_zero = 0;
		while(check_zero < result.size() && result.get(check_zero)== 0){
			check_zero++;
		}
		result = result.subList(check_zero, result.size());
		if( result.isEmpty()){
			return java.util.Arrays.asList(0);
		}
		result.set(0, result.get(0)* sign);
		return result;
	}
	public static boolean advanceThroughArray(List<Integer> num2){
		int reachedSoFar = 0, lastIndex = num2.size()-1;
		for(int i = 0; i <= reachedSoFar && reachedSoFar < lastIndex ; ++i){
			reachedSoFar = Math.max( reachedSoFar, i + num2.get(i));
			System.out.print(reachedSoFar);
		}
		return reachedSoFar >= lastIndex;
	}
	public static void main(Strings[] args){
		List<Integer> num1 = new ArrayList<>();
		List<Integer> num2 = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		num1.add(-8);
		num1.add(5);
		num2.add(3);
		num2.add(3);
		num2.add(0);
		num2.add(0);
		num2.add(2);
		num2.add(0);
		num2.add(1);
		result = multiplyArray(num1,num2 );
		for(int i = 0; i < result.size();i++){
		    System.out.print(result.get(i));
		}
		System.out.print(advanceThroughArray(num2));
		System.out.println();
	}
	
	
}

