package spelling;

import java.util.LinkedList;

import textgen.LLNode;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{	private Node head;
	private Node tail;
	int size;
	private LinkedList<String> dict;
	
	
    // TODO: Add a constructor
	public DictionaryLL() {
		// TODO: Implement this method
		super();
		head=new Node(null);
		tail=new Node(null);
		size=0;
		head.next=tail;
		tail.prev=head;
		
		
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	word=word.toLowerCase();
    	Node last = new Node(word);
    	last.next=tail;
		last.prev=tail.prev;
		tail.prev.next=last;
		tail.prev=last;
		last.data=word;
		size++;
    	return true;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
    	return size;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	s=s.toLowerCase();
    	Node kappa=head.next;
    	for(int i=0;i<size();i++) {
    		if(kappa.data.equals(s)) return true;
    		kappa=kappa.next;
    	}

    	return false;
}

}

@SuppressWarnings("hiding")
class Node{
	
	Node next;	
	Node prev;
	String data;
	
	public Node(String data) {
		this.data=data;
		this.next=null;
		this.prev=null;
	}
	
	
}