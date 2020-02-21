// Jinesh Shah
// CSI 403 Algorithms and Data Structures
// Proj 5 FOAFs

package csi403;

// imports
import java.util.ArrayList;

// Friend will be the inList that contains the friendship bojects
public class friend 
{	

	// Each friend will have their name and their list of friends
	String name;
	ArrayList<friend> friends = new ArrayList<friend>();
	

	// Getter for Name
	public String getName() 
	{
		return name;
	}
	
	// Setter for Name
	public void setName(String name) 
	{
		this.name = name;
	}
	
	// Getter for Friends
	public ArrayList<friend> getFriends() 
	{
		return friends;
	}
	
	// Setter for Friends
	public void setFriends(ArrayList<friend> friends) 
	{
		this.friends = friends;
	}
	
    // creating a string for friend name
	public String toString() 
	{
		return "friend [name=" + name + "]";
	}
	
	// creating friend constructor under the name and friends parameters using arrays
	public friend(String name, ArrayList<friend> friends) 
	{
		this.name = name;
		this.friends = friends;
	}
	
	// friend constructor under the name parameter
	public friend(String name)
	{
		this.name = name;
	}
	
	// empty constructor
	public friend()
	{
		// empty
	}

    // Creating boolean class used for the friend objects
	// return true after all of the if statements has been gone through
	public boolean equals(Object obj)
	{
		// if this is obj then bring true
		if (this == obj)
		{
			return true;
		}
		// if obj is null bring false
		if (obj == null)
		{
			return false;
		}
		
		// If the class getter doesn't equal object return false
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		// Now time to do the same thing except for friends now
		// friend is the object
		friend other = (friend) obj;
		// if friend is null
		if (friends == null) 
		{
			// if other friend is not null return false
			if (other.friends != null)
			{
				return false;
			}
		} 
		// if name is null
		if (name == null) 
		{
			// if other name isn't null then return falls
			if (other.name != null)
			{
				return false;
			}
		} 
		// else if the name is another name not the main name for the friend return false
		else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}
}
