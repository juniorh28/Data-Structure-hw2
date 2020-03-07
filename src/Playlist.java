
public class Playlist {//this is my Double-ended LinkedList class
    private Song first; // Head pointer
    private Song last; // Tail pointer
    private Song currentSong = first;//first's next points to next song, current song points to first (will move if listenToSong)
    boolean firstListen = false;
    public Playlist (){
    	this.first = null;
    	this.last = null;
    }
    public void setFirst(Song first) {this.first = first;}
    
    public Song getFirst() {return first;}
    
    public boolean isEmpty() {return (first==null);}
   
    public void addSong(String s){ // Also enqueue method/insert
        Song newSong = new Song(s);
        if(isEmpty()) { // checks playlist is empty (first(head) -> null)  if true adds song to list 
                this.first = newSong;
        		this.last = newSong;
        }
        else{// else appends newSong to end of list
            this.last.next = newSong;
            this.last = this.last.next;
        last = newSong;}
    }
    public void printList() { //Playlist list
    	Song currNode = this.first; 
    	System.out.print("LinkedList: ");
    	while (currNode != null) {  // Traverse through the LinkedList 
    		System.out.print(currNode.track + " "); // Print the data at current node 
    		currNode = currNode.next; } // Go to next node 
    	}

    
    public Song listenToSong(){ // implementing dequeue with currentSong pointer
        // checks if song as been played if true moves the pointer to the next song
        // returns currentSong to be played
      	//reset the first reference to first.next
    	if(firstListen)   //if only one item
    		currentSong = currentSong.next;		//null points to last
        else 					
        	firstListen=true; //first points old next
        System.out.println(currentSong+" i ran");
        return currentSong;			//return deleted link
        
    }
}