package core;
/*
 * This code reading external log file 
 * Parsing it and saving the result in txt file
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileParsing {

	static final String inputFile = "./test_data/csv/log.txt";	//path to input file
	static final String outputFile = "./test_data/csv/ParsResult.txt";	// path to output file

	static String myDictionary(String inputText) {	//start of method
		String textResult = "";	
		String delimener = "_______________";
		String regex = "(?:.*?)\\s(.*?)(?:\\).+?)\\|\\s*(.*?)\\|\\s*(.*?)\\|\\s(.*?)\\|\\s*(.*?)"
				+ "\\|\\s(.*?)\\|\\s*(.*?)\\|\\s(.*?)\\.\\.\\.(?:.*?)\\s(.*?)(?:\\).+?)\\|\\s(.*?)\\|\\s(.*?)\\|\\s*(.*?)\\|\\s(.*?)"
				+ "\\.\\.\\.(?:.*?)\\s(.*?)(?:\\).+?)\\|\\s*(.*?)\\|\\s*(.*?)\\|\\s(.*?)\\|\\s*(.*?)\\|\\s*(.*?)\\|\\s*(.*?)\\|\\s(.*?)\\.\\.\\."
				+ "(?:.*?)\\s(.*?)(?:\\).+?)\\|\\s*(.*?)\\|\\s*(.*?)\\|\\s*(.*?)\\|\\s*(.*?)";		//regex pattern
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(inputText);
		m.find();
		String keyWord1 = m.group(1);	
		String keyWordKey1 = m.group(2);	
		String keyWordKey2 = m.group(3);
		String keyWordKey3 = m.group(4);
		String keyWordKey4 = m.group(5);
		String keyWordKey5 = m.group(6);
		String keyWordKey6 = m.group(7);
		String keyWordKey7 = m.group(8);
		String keyWord2 = m.group(9);
		String keyWordKey8 = m.group(10);	
		String keyWordKey9 = m.group(11);
		String keyWordKey10 = m.group(12);
		String keyWordKey11 = m.group(13);
		String keyWord3 = m.group(14);
		String keyWordKey12= m.group(15);
		String keyWordKey13 = m.group(16);
		String keyWordKey14 = m.group(17);
		String keyWordKey15 = m.group(18);
		String keyWordKey16 = m.group(19);
		String keyWordKey17 = m.group(20);
		String keyWordKey18 = m.group(21);
		String keyWord4 = m.group(22);
		String keyWordKey19 = m.group(23);
		String keyWordKey20 = m.group(24);
		String keyWordKey21 = m.group(25);
		String keyWordKey22 = m.group(26);
		textResult = keyWord1 + ":\n" + keyWordKey1 + "\n"+keyWordKey2+"\n"+ keyWordKey3 + "\n"
		+ keyWordKey4 + "\n"+ keyWordKey5 + "\n"+ keyWordKey6 + "\n"+ keyWordKey7 + "\n"+delimener+"\n"+keyWord2 + ":\n"+keyWordKey8 + "\n"+keyWordKey9 + "\n"+
		keyWordKey10 + "\n"+keyWordKey11 + "\n"+delimener+"\n"+keyWord3 + ":\n"+keyWordKey12 + "\n"+keyWordKey13 + "\n"+keyWordKey14 + "\n"+keyWordKey15 + "\n"
		+keyWordKey16 + "\n"+keyWordKey17 + "\n"+delimener+"\n"+keyWord4 + ":\n"+keyWordKey19 + "\n"+keyWordKey20 + "\n"+keyWordKey21 + "\n"+keyWordKey22 + "\n";
		return textResult;
	}	//end of method

	static void readFile() throws IOException {	//start of method
		File file = new File(outputFile); //Your file
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		
		String line = "";
		String cvsSplitBy = "\n";
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			while ((line = br.readLine()) != null) {
				String[] dictionaryElements = line.split(cvsSplitBy);
				for (int i = 0; i < dictionaryElements.length; i++) {
					System.setOut(ps);
					System.out.println(myDictionary(dictionaryElements[i]));	//printing result
				}	//end for loop
			}	//end while loop
		
		} catch (FileNotFoundException e){	//exception
			System.err.printf("\nFile not found: %s \n",inputFile);	//print out exception reason
		}	//close catch
		
	}	//end of method
	public static void main(String[] args) throws InterruptedException, IOException {
		new LogFileParsing();
		LogFileParsing.readFile();

	}

}
