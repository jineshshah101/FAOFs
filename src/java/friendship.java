// Jinesh Shah
// CSI 403 Algorithms and Data Structures
// Proj 5 FOAFs

package csi403;
// import
import java.util.Arrays;

// Friendship is the object which is in the inList Object
public class friendship 
{
	
	// Creating a string for friends which returns friends
	public String toString() 
	{
		return "friends [friends=" + Arrays.toString(friends) + "]";
	}
	// Friend string
	String [] friends;

	// Getter for friends
	public String[] getFriends()
	{
		return friends;
	}

	// Setter for friends
	public void setFriends(String[] friends)
	{
		this.friends = friends;
	}
	
    // Creating a friendship constructor with friends as the parameter
	public friendship(String[] friends) 
	{
		this.friends = friends;
	}

	// empty constuctor
	public friendship() 
	{
		// empty
	}
}
