import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Ngrams {
	
public String[] getString(String a,int g ) {
		int len, arrayLength = 0;
		len = a.length();
		if(g==2)
		{
			arrayLength = len-g+3;
		}
		if(g>2)
		{
			arrayLength = len-g+3;
		}
		String[] array = new String[arrayLength]; 
	    
		int x;
	    String first = "";
	    String last = "";
	    for(int i=0;i<=len-g+2;i++) {
	    	if(i==0)
	    	{
	    		array[0] = "#"+a.substring(0,g-1);
	    	}
	    	else if(i==len-g+2)
	    	{
	    		if(g==2) {x = len-g+2;}
	    		if(g==3) {x = len-g+3;}
	    		if(g==4) {x = len-g+4;}
	    		array[len-g+2] = "#"+a.substring(i-1,len);
	    	}
	    	else
	    	{
	    		array[i]=a.substring(i-1,i-1+g);
   	      	}
	    }
		return array;
		 
		}

		 

}

public class Main {
	public static void main(String[] args)
	{
			
			// File path + name for dictionary data set.
			String fileDict = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\kt\\dictionary.txt";
			
			// File path + name for miss spelled words data set.
			String fileMiss = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\kt\\misspell.txt";
			
			// File path + name for correct words corresponding to miss spelled words data set.
			//String fileCorr = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\correct.txt";
			
			// Test file to write data.
			String testFile = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\kt\\kt.txt";
			
			try 
			{
				FileInputStream   streamMisSpelled = new FileInputStream(fileMiss);
				InputStreamReader isrMis = new InputStreamReader(streamMisSpelled, Charset.forName("UTF-8"));
		        BufferedReader brMis = new BufferedReader(isrMis);
		        
		        
		        FileInputStream streamDictionary = new FileInputStream(fileDict);
				InputStreamReader isrDic = new InputStreamReader(streamDictionary, Charset.forName("UTF-8"));
		        BufferedReader brDic;
		        brDic = new BufferedReader(isrDic);
			}
			catch (IOException e) 
			{

				e.printStackTrace();
			}
			
			Ngrams obj = new Ngrams();
			String[] array1 = new String[] {}; 
		    String[] array2 = new String[] {}; 
		    
		    int strln1, strln2, nGramResult;
		    int gram=3;
		   
		    
		    // amba = 6  dumb
		    String str1 = "damb";
		    String str2 = "dumb";
		    
		    
		    
		    
		    
		    String str3 = "arts";
			
		    strln1 = str1.length(); strln2 = str2.length();
			
			array1 = obj.getString(str1,gram); array2 = obj.getString(str2,gram);
			
			ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(array1));
	        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(array2));
	        System.out.println("lists: " +list1+"   "+ list2 );
	        
	        int list1size, list2size, intersectionSize;
	        list1size = list1.size(); list2size = list2.size();
	        
	        list1.retainAll(list2);
	    	intersectionSize = list1.size();
	    	nGramResult = list1size+list2size-(2*intersectionSize);
	    	
	    	System.out.println("Common Elements"+ list1);
	    	System.out.println("|G"+gram+"("+str1+")|+|G"+gram+"("+str2+")|-2*|G"+gram+"("+str1+") intersection G"+gram+"("+str2+")| = "+nGramResult );
	    	
	}
};
