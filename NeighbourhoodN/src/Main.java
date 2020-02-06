import java.io.*;
//import java.lang.reflect.Array;
import java.nio.charset.Charset;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;

public class Main {

	public static void main(String[] args) {

		
		 // File path + name for dictionary data set.
		String fileDict = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\dictionary.txt";
		
		// File path + name for miss spelled words data set.
		String fileMiss = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\misspell.txt";
		
		// File path + name for correct words corresponding to miss spelled words data set.
		//String fileCorr = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\correct.txt";
		
		// Test file to write data.
		String testFile = "C:\\Users\\Prafull\\eclipse-workspace\\testFiles\\kt.txt";
		
		String lineMisSpell = "abc";
		String lineDictionary = "abc";
		int misSpellWordLength = 0;
		String left= "";
		String right = "";
		String concat = "";
		String[] myArray = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};              
		//String[] unArray = {};
		
		try 
		{
			FileInputStream   streamMisSpelled = new FileInputStream(fileMiss);
			InputStreamReader isrMis = new InputStreamReader(streamMisSpelled, Charset.forName("UTF-8"));
	        BufferedReader brMis = new BufferedReader(isrMis);
	        
	        
	        FileInputStream streamDictionary = new FileInputStream(fileDict);
			InputStreamReader isrDic = new InputStreamReader(streamDictionary, Charset.forName("UTF-8"));
	        BufferedReader brDic;
	        brDic = new BufferedReader(isrDic);
	        
	        
	        FileWriter fileWriter =
                    new FileWriter(testFile);
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
	        String matched = "";
	        int b = 0;
	       // int matchCount = 0;
	        
	        while((lineMisSpell = brMis.readLine()) != null) // reads all miss spelled words 
	        //for(int g=0;g<2;g++)
	        {
	        	misSpellWordLength = lineMisSpell.length();
	        	//lineMisSpell = brMis.readLine();
	        	for(int k=0; k < misSpellWordLength+1; k++) // runs for length of word + 1
	        	//for(int k=0; k < 1; k++) // runs for length of word + 1
	        	{
	        		if(k==0) {
	        			b=0;
	        		}
	        		else
	        		{
	        			b=1;
	        		}
	        		for(int i =b; i<27; i++) // for inserting 26 alphabets at 1 position
            		{
	        			left = lineMisSpell.substring(0,k);
                		right = lineMisSpell.substring(k,misSpellWordLength);
                		concat = left+myArray[i]+right;
                		//System.out.println(left+"-"+myArray[i]+"-"+right);
                		//System.out.println(k+": Left : "+left+" : Right : "+right+"--"+concat+" : Matches : ");
                		while((lineDictionary = brDic.readLine()) != null) // reads all miss spelled words
                		//brDic.mark(0);
                		//for(int v=0;v<10000;v++)
                		{
                			//lineDictionary = brDic.readLine();
                			//bufferedWriter.write(i+"--"+lineMisSpell+" = "+concat+" : Matches : "+lineDictionary);
            	            //bufferedWriter.newLine();
                			//lineDictionary = brDic.readLine();
                			//System.out.println(misSpellWordLength+"  :inside while : "+concat+"--"+lineDictionary);
                			//System.out.println(concat+"--"+i);
                			if(concat.equals(lineDictionary))
                			{
                				//unArray[matchCount] = lineDictionary;
                				matched = matched+" | "+lineDictionary;
                    			//bufferedWriter.write(i+"--"+lineMisSpell+" = "+concat+" : Matches : "+lineDictionary);
                	            //bufferedWriter.newLine();
                				//System.out.println("Left : "+left+" : Right : "+right+"--"+lineMisSpell+" : Matches : "+lineDictionary);
                				//System.out.println(lineMisSpell+" => "+lineDictionary);
                				//System.out.println(lineMisSpell+" : L :"+left+" :R :"+right+"=>"+concat+" => "+lineDictionary);
                			}
                			
                		}
                		
                		streamDictionary.getChannel().position(0);
                		brDic = new BufferedReader(new InputStreamReader(streamDictionary));
                		//brDic.reset();
                		//lineDictionary = null;
                		
                		
            		}
	        		
	        	}
	        	//System.out.println(lineMisSpell);
	        	// --- re initialize values to 0
	        	
	        	
	        	//Set<String> uniqueWords = new HashSet<String>(Arrays.asList(unArray));
	    		if(matched.length()>0)
        			//System.out.println(lineMisSpell+"=>"+matched);
	    			//System.out.println(lineMisSpell+"=>"+matched.toString());
	    			bufferedWriter.write(lineMisSpell+"=>"+matched.toString());
	                bufferedWriter.newLine();
        		matched = "";
        		// here
	        }
	        brDic.close();
	        brMis.close();
            bufferedWriter.close();
	        
	        
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

}
