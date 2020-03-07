//Junior Hernandez
//Data Structure

import java.io.*;
import java.util.*;
public class TopStreamingArtist {
    
    public static void main(String[] args) throws IOException{
		String pathWay = "C:\\Users\\Junior\\Downloads\\regional-global-weekly-2020-01-17--2020-01-24.csv";
    	FileReader csvFile = new FileReader (pathWay);
    	BufferedReader input = new BufferedReader (csvFile);//can read in more data than Scanner
		PrintWriter output = new PrintWriter("output");
		int row = 200, column = 5;
		ArrayList<String> artistName = new ArrayList<String>();
		//creating a 2d array to show top 200 song, its artist name, number of streams and url link.
		String[][] topCharts = new String[row][column];
		
		readData(topCharts,input, artistName,output);
		
		LinkedHashSet<String> hashSet = new LinkedHashSet<>(artistName);
		ArrayList<String> artistWithoutDuplicates = new ArrayList<>(hashSet);
		artistWithoutDuplicates.sort(String::compareToIgnoreCase);
	    //System.out.println(artistWithoutDuplicates);

	    LinkedList<String> artist = new LinkedList<String>(artistWithoutDuplicates);
	    output.println("Artist name alphabetize without duplicates\n"+artist);
		input.close();
		output.close();
	}//end of main
	
	
	/**
	 * readData will take in the read in the values from the file 
	 * @param chart
	 * @param input
	 */
	public static void readData(String[][] chart, BufferedReader inputFile, ArrayList<String> artistName,PrintWriter output) {
		try{//checks if the program can read the whole file. 
			while(inputFile.readLine() != null) {
				//must initialize header so it can be used in last column (j=4)
				String position="", song="", artist="", streams="", url="";
				String line;
				//assigns the header
				output.printf("%9.40s |%-40.40s|%-20.20s  |%8.9s  |%8.40s","Position","Track Name","Artist","Streams","URL");
				
				// i is the rows, there are 200 rows
				for(int i = 0; i < 200; i++) {
					//for row i take the line from the input file
					line  = inputFile.readLine();
					//split that line by commas
					String[] lineSplit = line.split(",");
					output.println();
					
					for(int j=0; j<5;j++) {//assign each column to its proper location
						if(j==0) 
							chart[i][j]=position=lineSplit[j];
						if(j==1) 
							chart[i][j]=song=lineSplit[j];
						if(j==2) {
							chart[i][j]=artist=lineSplit[j];
							artistName.add(chart[i][2]);
						}
						if(j==3)
							chart[i][j]=streams=lineSplit[j];
						if(j==4) {
							chart[i][j]=url=lineSplit[j];
							//			   ranking|songName|artistName|streams|url
							output.printf("%9.40s |%-40.40s|%-20.20s  |%8.9s  |%8.60s",position,song,artist,streams,url);
						}
					}
				}
			}	
		}
		//if the file can not be read further, throw an error message
		catch (Exception e) {
			output.println();
			output.println("---Error file could not read anymore data---");
			output.println();
		}
	}//end of readData method
	
	
}//end of class