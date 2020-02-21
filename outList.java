// Jinesh Shah
// CSI 403 Algorithms and Data Structures
// Proj 5 FOAFs

package csi403;
// imports
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

// The outList will have the names of people and their friends
public class outList 
{
	// Creating ArrayList for outList that has strings
	ArrayList<ArrayList<String>> outList = new ArrayList<ArrayList<String>>();
	
	// Creating outList Constructor
		public outList(ArrayList<ArrayList<String>> outList)
		{
			this.outList = outList;
		}

		// Empty Constructor
		public outList() 
		{
			// empty
		}

		// Getter for OutList
		public ArrayList<ArrayList<String>> getOutList() 
		{
			return outList;
		}

		// Setter for Outlist
		public void setOutList(ArrayList<ArrayList<String>> outList)
		{
			this.outList = outList;
		}

		// Creating string constructor to return outList
		public String toString() 
		{
			return "outList [outList=" + outList + "]";
		}

		// Creating a friends contains method
		// Method has arrayList for friends, listoffriends, friend friend
		// Return null otherwise
		public friend contains(ArrayList<friend> listoffriends, friend friend)
		{
			// For looping to return the search of the friend
			for(friend searcher : listoffriends)
			{
				// If the search is the friend return the friend itself
				if(searcher.equals(friend)) 
				{
					return searcher;
				}
			} 	
			return null;
		}	
		
	// Creating outList constuctor using the inList parameter
	public outList(inList inList) 
	{
		// Create Arraylist that holds the new friend values
		ArrayList<friend> friends = new ArrayList<friend>();
		
		// A for loop that will loop through the inList which will create and add
		// all the people to the friends arraylist
		for(friendship searcher : inList.getInList()) 
		{
			// Creating friends objects to connect with friends and find them
			friend tempA = new friend(searcher.getFriends()[0]);
			friend tempB = new friend(searcher.getFriends()[1]);
			friend finder;
			
			// Setting up the friends for temp A and temp B
			tempA.getFriends().add(tempB);
			tempB.getFriends().add(tempA);

			// If temp A exists in friends list 
			if((finder = contains(friends, tempA)) == null) 
			{
				friends.add(tempA);
			} 
			else 
			{
				finder.getFriends().add(tempB);
			}
			
			// If temp B exists in friends list 
			if((finder = contains(friends, tempB)) == null) 
			{
				friends.add(tempB);
			} 
			else 
			{
				finder.getFriends().add(tempA);
			}
		}
		
		// Create a new array list of friends
		friend [] friendsArray = friends.toArray(new friend[friends.size()]);
		
		// The for loop for friends searching for friendship
		for(int x = 0; x < friends.size(); x++) 
		{
			// the for loop for the next set of friends in that friendship
			for(int y = 0; y < friendsArray[x].getFriends().size(); y++) 
			{
				// the for loop continuing on the next set of friendships in that friendship
				for(int z = 0; z < friendsArray[x].getFriends().get(y).getFriends().size(); z++) 
				{
					// If the current person isn't friends with another person
					if((!friendsArray[x].getFriends().get(y).getFriends().get(z).equals(friendsArray[x]))) 
					{
						// Creating a new string array list
						// Has one specific order of two friends
						ArrayList<String> origin = new ArrayList<String>();
						origin.add(friendsArray[x].getFriends().get(y).getFriends().get(z).getName());
						origin.add(friendsArray[x].getName());
				        
						// Creating a new string array list
						// This time the order is flipped of the two friends
						ArrayList<String> flipped = new ArrayList<String>();
						flipped.add(friendsArray[x].getName());
						flipped.add(friendsArray[x].getFriends().get(y).getFriends().get(z).getName());
						
						// If the ordering doesn't exist in the outList
						if(!((this.getOutList().contains(origin)) || (this.getOutList().contains(flipped))))
						{	
							// Creating another string Arraylist
							ArrayList<String> temp = new ArrayList<String>();
							// Possibility of a new friend being discovered
							temp.add(friendsArray[x].getName());
							temp.add(friendsArray[x].getFriends().get(y).getFriends().get(z).getName());
							this.getOutList().add(temp);
						}
					}
				}
			}
		}
	}
}