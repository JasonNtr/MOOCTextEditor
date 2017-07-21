package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
   private TNode root;
   private int size;
   
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	public DictionaryBST(){
		
		root=new TNode(null);
		
	}
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	word=word.toLowerCase();

    	if(size==0) {
    		root.data=word;
    		size++;
    		return true;
    	}
    	else
    	{
    		TNode kappa=root;
    		while(kappa!=null) {
    			
    			if (word.equals(kappa.data))   {
    				
    				return false;
    			}
                
    			else if (kappa.data.compareTo( word )>0) {
    					if (kappa.left == null) {
    					kappa.left = new TNode(word);
    					
    					size++;
    					return true;
    				} else
    					kappa=kappa.left;
    			}
    			else if (root.data.compareTo( word )<0) {
    	            if (kappa.right == null) {
    	                  kappa.right = new TNode(word);
    	                  size++;
    	                  return true;
    	            } else
    	                  kappa=kappa.right;
    	      }
    		}
    		
    	}
    	return false;	
    }	
    	
    		
    	

    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return size;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	s=s.toLowerCase();
    	
    	if(size==0) return false;
    	TNode kappa= root;
    	if(s.equals(kappa.data)) return true;
    	while(kappa!=null) {
    		System.out.println(kappa.data);
    		if (kappa.data.compareTo( s )>0) {
				if (kappa.left == null) {
				return false;
			} else
				kappa=kappa.left;
    		}
    		else if (root.data.compareTo( s )<0) {
    			if (kappa.right == null) {
                  return false;
            } else
                  kappa=kappa.right;
            }
    		else return true;
    		
    		
    		
    	}
        return false;
    }

}


final class TNode
{
	TNode left,right;
		String data;
		
		public TNode(String data) {
			this.left=null;
			this.right=null;
			this.data=data;	
		
		}
	
		
}