
public class SongHistoryList {//this is my stack class
	private Song first;
	private Song last;
	private Song tailPointer=last;
	boolean firstListen = false;
	  public void SongHistoryList(){
		  
		  }// constructor for creating a new list
	  
	  public void addSong(String s){//push
		  Song playedSong = new Song(s);
		  if(first == null) {
			  first = playedSong;
			  last = first;
		  }
		  else {
			  playedSong.next = first;
			  first.prev = playedSong;
			  first = playedSong;  
		  }  
	  }
	  
	  public Song lastListened(){//pop
		  if(firstListen) //the song was not listen to before 
			  tailPointer = tailPointer.prev;
		  else 
			firstListen = true;
			
		  return tailPointer;
	  }
	  
	 // public boolean isEmpty() {
		  //return(playlist.isEmpty());
	  //

}
