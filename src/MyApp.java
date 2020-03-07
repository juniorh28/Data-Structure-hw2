import java.io.IOException;
import java.util.*;
public class MyApp {

	public static void main(String[] args) throws IOException {
		String[] fileNames = {"C:\\Users\\Junior\\Downloads\\regional-global-weekly-2020-01-17--2020-01-24.csv",
				"C:\\Users\\Junior\\Downloads\\regional-us-weekly-2020-01-17--2020-01-24.csv"};

		 ArrayList<MyQueue> allTheWeeks = new ArrayList<>();

		  for (int i=0; i < fileNames.length-1; i++){
		    MyQueue dataExtract = new MyQueue(fileNames[i]);
		    allTheWeeks.add(dataExtract);
		  }
		  //historyList example
		  //allTheWeeks.get(0).getPlaylist().printList();
		  System.out.println(allTheWeeks.get(0).getPlaylist().listenToSong());
	}
}