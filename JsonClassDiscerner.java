// Jinesh Shah
// CSI 403 Algorithms and Data Structures
// Proj 5 FOAFs

package csi403; 

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List; 

//This part of the code was supplied in class 
//It's pretty much the same with minor changes

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {

    	//Some error checking
    	if(jsonStr.contains("{}") || jsonStr.isEmpty()) {
    		return "Malformed JSON";
        }
        
        ObjectMapper mapper = new ObjectMapper();
        //mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
        	inList inList = mapper.readValue(jsonStr, inList.class); 
        	        	
        	//JsonNode jsonNode = mapper.readTree(jsonStr);
        	// This is one of the changes for this project
        	// Creating an error check now that data is being supplied
        	
        	// if the inList length is 0 return empty the inList
        	if (inList.getInList().length == 0)
        	{
        		return "Empty inList";
        	}
        	
        	// for loop for x being the number of friends using the inList
        	for(int x = 0; x < inList.getInList().length; x ++) 
        	{
        		// If the number of friends isn't 2 then return invalid number of friends
        		if(inList.getInList()[x].getFriends().length != 2) 
        		{
                	return "Invalid # of friends";
        		}
        	}
        	// return inList
        	return "inList";
        	
        } catch(Exception e) {
            //e.printStackTrace();
        	return "Malformed JSON";
        }
    }


    // test app 
    // putting in the different outputs required here for this project
    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();
        
        msg = "{\"inList\":[]}";  
        System.out.println(msg);
        testingFunction(discerner.discern(msg));  
        
        msg = "{\"inList\":}";  
        System.out.println(msg);
        testingFunction(discerner.discern(msg)); 
        
        msg = "{\"inList\":[{\"friends\":[\"Albert\", \"Luke\", \"Betty\"]},{\"friends\":[\"Betty\", \"Cathy\"]},{\"friends\":[\"Cathy\", \"Denis\"]},{\"friends\":[\"Denis\", \"Albert\"]},{\"friends\":[\"Tony\", \"Bruce\"]}]}";  
        System.out.println(msg);
        testingFunction(discerner.discern(msg)); 
        
        msg = "{\"inList\":[{ },{\"friends\":[\"Betty\", \"Cathy\"]},{\"friends\":[\"Cathy\", \"Denis\"]},{\"friends\":[\"Denis\", \"Albert\"]},{\"friends\":[\"Tony\", \"Bruce\"]}]}";  
        System.out.println(msg);
        testingFunction(discerner.discern(msg)); 
        
        msg = "{\"inList\":[{\"friends\":[\"Albert\", \"Betty\"]},{\"friends\":[\"Betty\", \"Cathy\"]},{\"friends\":[\"Cathy\", \"Denis\"]},{\"friends\":[\"Denis\", \"Albert\"]},{\"friends\":[\"Tony\", \"Bruce\"]}]}";  
        System.out.println(msg);
        testingFunction(discerner.discern(msg));  
    }
}