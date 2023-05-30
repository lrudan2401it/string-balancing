import java.util.Scanner;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringBalancing{
	
	public static int[] removeDuplicates(int arr[]){
		int end = arr.length;

	    for(int i = 0; i < end; i++){
	        for(int j = i + 1; j < end; j++){
	            if(arr[i] == arr[j]){       
	                arr[j] = arr[end-1];
	                end--;
	                j--;
	            }
	        }
	    }

	    int[] whitelist = new int[end];
	    System.arraycopy(arr, 0, whitelist, 0, end);
	    return whitelist;
    }
	
	public static int[] removeNegatives(int arr[]){
		int[] output = new int[0];
	    int k = 0, j = 1;
	    for(int i = 0; i < arr.length; i++) {
	       if(arr[i] >= 0) {
	    	   output = Arrays.copyOf(output, j);
	           output[k++] = arr[i];
	           j++;
	       }
	    }
	    return output;
    }
	
	public static int[] findSymbol1(int arr[], String tekst){
		for(int i = 0; i<arr.length; i++) {
			try {
				int index2 = StringUtils.indexOf(tekst, "(", i);
				System.out.println("Pozicija:" + index2);
				arr[i] = index2;
				System.out.println(arr[i]);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return arr;
	}
	
	public static int[] findSymbol2(int arr[], String tekst){
		for(int i = 0; i<arr.length; i++) {
			try {
				int index2 = StringUtils.indexOf(tekst, ")", i);
				System.out.println("Pozicija:" + index2);
				arr[i] = index2;
				System.out.println(arr[i]);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return arr;
	}
	
	public static boolean condition1(int count1, int count2){
		boolean firstCondition;
		if(count1 == count2){
			System.out.println("Prvi uslov zadovoljen. ");
			firstCondition = true;
		}else{
			System.out.println("Prvi uslov nije zadovoljen. ");
			firstCondition = false;
		}
		return firstCondition;
	}
	
	public static boolean condition2(int withoutNegative1[], int withoutNegative2[]){
		boolean secondCondition;
		boolean condition1, condition2;
		
		int max1 = 0;
		for (int counter1 = 1; counter1 < withoutNegative1.length; counter1++){
		     if (withoutNegative1[counter1] > max1)
		     {
		           max1 = withoutNegative1[counter1];
		     }
		}
		System.out.println("maximum1 is: " + max1);
		int max2 = 0;
		for (int counter2 = 1; counter2 < withoutNegative2.length; counter2++){
		     if (withoutNegative2[counter2] > max2)
		     {
		           max2 = withoutNegative2[counter2];
		     }
		}
		System.out.println("maximum2 is: " + max2);
		
		
		//int last1 = withoutNegative1.length - 1;
		//int last2 = withoutNegative2.length - 1;
		//String.valueOf(withoutNegative1[last]).equals("(")
		if(max1 > max2) {
			condition1 = false;
			System.out.println("1 - false ");
		}else{
			condition1 = true;
			System.out.println("1 - true ");
		}
		
		//String.valueOf(withoutNegative2[0]).equals(")")
		if(withoutNegative2[0] == 0) {
			condition2 = false;
			System.out.println("2 - false ");
		}else{
			condition2 = true;
			System.out.println("2 - true ");
		}
		
		if(condition1 && condition2){
			secondCondition = true;
			System.out.println("Drugi uslov zadovoljen. ");
		}else{
			secondCondition = false;
			System.out.println("Drugi uslov nije zadovoljen. ");
		}
		
		return secondCondition;
	}

	public static void main(String[]args){
		String tekst;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Unesite tekst: ");
		tekst = input.next();
		
		System.out.println("Tekst: " + tekst);
		
		int count1 = StringUtils.countMatches(tekst, "(");
		int count2 = StringUtils.countMatches(tekst, ")");
		
		System.out.println("(: " + count1 + "): " + count2);
		
		condition1(count1, count2);
		
		int[]array1 = new int[tekst.length()];
		int[]array2 = new int[tekst.length()];
		
		array1 = findSymbol1(array1, tekst);
		array2 = findSymbol2(array2, tekst);
		
		int[]whitelist1 = removeDuplicates(array1);
		int[]whitelist2 = removeDuplicates(array2);
		
		int[]withoutNegative1 = removeNegatives(whitelist1);
		int[]withoutNegative2 = removeNegatives(whitelist2);
		
		condition2(withoutNegative1, withoutNegative2);
	
		for(int i = 0; i < withoutNegative1.length; i++){
			System.out.print(withoutNegative1[i] + " ");
		}
		System.out.println("Velicina niza: " + withoutNegative1.length);
		
		for(int i = 0; i < withoutNegative2.length; i++){
			System.out.print(withoutNegative2[i] + " ");
		}
		System.out.println("Velicina niza: " + withoutNegative2.length);
		
		input.close();
	}
}
