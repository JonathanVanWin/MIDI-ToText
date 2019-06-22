import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.*;

public class FileHandling {

	public static String readFile(String s) {
		String fileName = "C:\\Users\\grand_000\\Desktop\\"+s;
		String text = "";

		// This will reference one line at a time
		String line = null;

		try { // FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				text += line + "\n";
			}

			// System.out.println(text); // Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this: ex.printStackTrace();
		}
		return text;

	}

	public static void writeFile( String[] good) {
		String fileName = "C:\\Users\\grand_000\\Desktop\\temp.txt";

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			for(int i=0; i<good.length; i++){
				bufferedWriter.write(good[i]);
				bufferedWriter.newLine();
			}
			System.out.println("Done");
			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static void modifyFile(String filePath, String oldString, String newString) {
		File fileToBeModified = new File(filePath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}
			String x = oldContent;
			System.out.println(x);
			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			// Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String[] readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}

		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}
	
	public static String readLine(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lines = "";
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			lines+=line;
		}

		bufferedReader.close();
		return lines;
	}

	public static int lenOfGoodArr(String[] ss) {
		int c = 0;
		for (String line : ss) {
			if (line.contains("Note_on_c") || line.contains("Note_off_c")) {
				c++;
			}

		}
		return c;
	}

	//Create method that creates a list by introducing the number of channels
	public static void listOfArrays(List<int[][]> arListOfAllChannels, int numOfChan_inCsvFileHeader){
		
	}
	
	public static int getIndexOf( int toSearch, int[] tab, int beginFromIndex )
	{
	  for( int i=beginFromIndex; i< tab.length ; i ++ )
	    if( tab[ i ] == toSearch)
	     return i;

	  return -1;
	}
	
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		/*
		 * System.out.println("Insert name of file:"); String filePath =
		 * "C:\\Users\\grand_000\\Desktop\\" + in.nextLine() + ".txt";
		 * System.out.println("Enter the  you want to replace"); String
		 * oldString = in.nextLine();
		 * 
		 * System.out.println("Enter the  you want to replace"); String
		 * newString = in.nextLine();
		 */

		char[] ascii = { '∞', '⟀', '⟁', '⟂', '⟃', '⟄', '⟇', '⟈', '⟉', '⟐', '~', '⟖', '⟘', '⟕', '⟗', '✿', '☺', '✡', '✍',
				'♪', '♩', '♫', '♬', '❤', '⚛', '✈', '✎', '♀', '♂', '✉', '➫', '☎', '☜', '☞', '☝', '☟', '✌', '☮', '✔', '⦓',
				'⦔', '⦕', '⦖', '⦚', '⦛', '⦜', '⦝', '⦞', '⦟', '⦠', '⦡', '⦢', '⦤', '⦣', '⦥', '⦦', '⦧', '⦨', '⦩', '⦪', '⦫',
				'⦬', '⦭', '⦮', '⦯', '⦰', '⦱', '⦲', '⦳', '⦴', '⦵', '⦶', '⦷', '⦸', '⦹', '⦺', '⦻', '⦼', '⦽', '⦾', '⦿', '⧀',
				'⧁', '⧂', '⧅', '⧆', '⧇', '⧈', '⧉', '⧊', '⧋', '⧌', '⧍', '⧎', '⧏', '⧐', '⧑', '⧒', '⧓', '⧔', '⧕', '⧖', '⧗',
				'⧝', '⧜', '⧞', '⧟', '⧡', '⧢', '⧦', '⧧', '⧨', '⧩', '⧬', '⧮', '⧯', '⧰', '⧱', '⧲', '⧳', '⧻', '⧼', '∫', '∬',
				'∭', '∮', '∯', '⇮' };

	// System.out.println(s);
		String[] ss = readLines("C:\\Users\\grand_000\\Desktop\\a.txt");
		//String[] good = new String[lenOfGoodArr(ss)];
		int c = 0;
		String ffff= "";
		for (String line : ss) {
			if (line.contains("Note_on_c") || line.contains("Note_off_c") || line.contains("Header")) {
				//good[c] = line;
				//c++;
				ffff+=line+"\n";
				//System.out.println(line);
			}

		}
		String s=ffff.replaceAll("Note_on_c", "1").replaceAll("Note_off_c", "0");
		//writeFile( good);
		String[] temp= s.split("\n");
		String[][] arrOfCsv=new String[temp.length][];
		for(int i=0; i<arrOfCsv.length; i++){
			arrOfCsv[i]=temp[i].split(", ");
		}
		
		int nOfChannels= Integer.parseInt(arrOfCsv[0][4])-(Integer.parseInt(arrOfCsv[1][0])-1);
		int[] numOfN= new int[nOfChannels];
		int k=0;
		for(int i=Integer.parseInt(arrOfCsv[1][0]); i<Integer.parseInt(arrOfCsv[0][4])+1; i++){
			numOfN[k]=i;
			k++;
		}
		int[] t= new int[nOfChannels];
		for(int i=0; i<nOfChannels;i++){
			t[i]=i;
		}
		
		String[][] arrOfArrByChannel = new String[nOfChannels][]; 
		int[] tempArr= new int[nOfChannels];
		for(int i=1; i<arrOfCsv.length; i++){
			if(Integer.parseInt(arrOfCsv[i][0])==numOfN[0]){
				tempArr[0]++;
				
			}else for(int j=0; j<tempArr.length; j++){
				if(Integer.parseInt(arrOfCsv[i][0])==numOfN[j]){
					tempArr[j]++;
				}
			}
			
		}
		for(int i=0; i<nOfChannels; i++){
			arrOfArrByChannel[i]= new String[tempArr[i]];
			//System.out.println(arrOfArrByChannel[i][i]);
		}
		int h=0, e=0;
		String channels="";
		String[] restOfChannels= new String[nOfChannels-1];
		Arrays.fill(restOfChannels, "");
		for(int i=0; i<tempArr.length; i++){
			//System.out.println(numOfN[i]);
			//System.out.println(arrOfArrByChannel[i].length);
		}
		//System.out.println(arrOfArrByChannel[2][47]);
		for(int i=0; i<arrOfCsv.length; i++){	
			for(int j=0; j<arrOfCsv[i].length; j++){
				if(j==0){
					if(Integer.parseInt(arrOfCsv[i][j])==numOfN[0]){
						channels+=arrOfCsv[i][1]+", "+arrOfCsv[i][2]+", "+arrOfCsv[i][4]+", "+"\n";
						//System.out.println(arrOfCsv[i][0]+" ,"+arrOfCsv[i][1]+" ,"+arrOfCsv[i][2]+" ,"+arrOfCsv[i][4]);
						arrOfArrByChannel[0][h]=arrOfCsv[i][0]+" ,"+arrOfCsv[i][1]+" ,"+arrOfCsv[i][2]+" ,"+arrOfCsv[i][3]+" ,"+arrOfCsv[i][4]+" ,"+arrOfCsv[i][5];
						h++;
					}
					//arrOfArrByChannel[0][j]=;
				//if(arrOfCsv[i][j]);
					else{
						for(int q=0; q<numOfN.length; q++){
							if(Integer.parseInt(arrOfCsv[i][j])==numOfN[q]){
								restOfChannels[q-1]+=arrOfCsv[i][0]+", "+arrOfCsv[i][1]+", "+arrOfCsv[i][2]+", "+arrOfCsv[i][4]+"\n";
								arrOfArrByChannel[q][e]=arrOfCsv[i][0]+" ,"+arrOfCsv[i][1]+" ,"+arrOfCsv[i][2]+" ,"+arrOfCsv[i][3]+" ,"+arrOfCsv[i][4]+" ,"+arrOfCsv[i][5];
							}
						}
					}
					}
				
			}
		}
		//System.out.println(channels);
		for(int i=0; i<arrOfArrByChannel.length-1; i++)
		{
			
			//System.out.println(restOfChannels[i]);
		}
		int[] arrOfFirstChannelImpInfo=Stream.of(channels.split(",\\s+")).mapToInt(Integer::parseInt).toArray();

		for(int i=0; i<arrOfFirstChannelImpInfo.length; i++){
			if(i%3==0){
				if(arrOfFirstChannelImpInfo[i+1]==1)System.out.println("**"+getIndexOf(arrOfFirstChannelImpInfo[i+2], arrOfFirstChannelImpInfo, i+5)+
			" "+arrOfFirstChannelImpInfo[i]+" "+arrOfFirstChannelImpInfo[getIndexOf(arrOfFirstChannelImpInfo[i+2], arrOfFirstChannelImpInfo, i+3)-2]+" "+
						i+2);
				
			}
		}
		

	//	List<int[][]> arListOfAllChannels;
		
		
		 /*for(int i=0; i<arrOfCsv.length; i++){	
			for(int j=0; j<arrOfCsv[i].length; j++){
				if(j==0)
				System.out.print(arrOfCsv[i][j]);
				if(j==4)
				System.out.println(",   "+arrOfCsv[i][j]);
				
			}
		}*/
		
		
		/*if(s.contains("Note_off_c")){
			
		}*/
		
		
		
		
		/*
		 * System.out.println("Give a name to the file: "); String
		 * newTxtFileName=in.next();
		 */
		/*
		 * for (int i = 100; i < ascii.length; i++) {
		 * 
		 * // if() System.out.println(); } for (int i = 10; i < 100; i++) {
		 * System.out.println(); }
		 * 
		 * for (int i = 0; i < 10; i++) { System.out.println(); }
		 */

		// modifyFile(filePath, oldString, newString);

	}

}
