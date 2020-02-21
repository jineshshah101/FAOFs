// Jinesh Shah
// CSI 403 Algorithms and Data Structures
// Proj 5 FOAFs

package csi403;
// imports
import java.util.Arrays;

// This is the inList which will have all the friendships itself for JSON
public class inList 
{
	// Have friendship be inside the inList
	friendship [] inList;

	// Creating a string for inList which will return the inList array
	public String toString() 
	{
		return "inList [inList=" + Arrays.toString(inList) + "]";
	}

	// empty constructor
	public inList() 
	{
		// empty
	}
	
	// Creating inList constructor with inList as the parameters
	public inList(friendship[] inList)
	{
		this.inList = inList;
	}

	// Getter for InList
	public friendship[] getInList()
	{
		return inList;
	}

	// Setter for inList
	public void setInList(friendship[] inList) 
	{
		this.inList = inList;
	}
}