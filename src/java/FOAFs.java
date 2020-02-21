// Jinesh Shah
// CSI 403 Algorithms and Data Structures
// Proj 5 FOAFs

package csi403;

// Imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

//Half of this code if from the code supplied from class with minor changes
//The second half is the FOAFs stuff itself

// Extend HttpServlet class
public class FOAFs extends HttpServlet {

	/**
	 * default serialversionid
	 */
	private static final long serialVersionUID = 1L;

	// Standard servlet method 
    public void init() throws ServletException { 
        // Do any required initialization here - likely none
    }
    
    // Standard servlet method - we will handle a POST operation
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        doService(request, response); 
    }

    // Standard Servlet method
    public void destroy() { 
        // Do any required tear-down here, likely nothing.
    }

    // Standard servlet method - we will not respond to GET
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        // Set response content type and return an error message
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // We can always create JSON by hand just concating a string.  
        out.println("{ 'message' : 'Use POST!'}");
    }
    
    // Our main worker method
    private void doService(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException { 
        // Get received JSON data from HTTP request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = "";
        if(br != null){
            jsonStr = br.readLine();
        }
        
        //Store discerned response from inputted JSON
        String discerned = new JsonClassDiscerner().discern(jsonStr); 
        
        // Set response content type to be JSON
        response.setContentType("application/json");
        // Send back the name of the class as a JSON message
        PrintWriter out = response.getWriter();
        
        // creating the if statement to show JSON for the inList
        if (discerned.equals("inList"))
        {
        	// Create the objectmapper for the inList and the outList
            ObjectMapper mapper = new ObjectMapper();
        	// Create the serialized needef for the inList and the outList
            JsonSerializer serializer = new JsonSerializer();

            // This reads the inList and then creates the outList 
            inList inList = mapper.readValue(jsonStr, inList.class);

            // The construct for the outList
            outList outList = new outList(inList);
            // if the outList is null then print an error message
            if (outList.getClass() == null) 
            {
            	 out.println("{\"message\" : \"unknown error\"}");
            	 return;
            } 
            else
            {
            	// else just serialize the output from the outList
                out.println(serializer.serialize(outList));
            }

        } 
        else
        {
        	// print out the message using the JSON that have been discerned 
            out.println("{\"message\" : \"" + discerned + "\"}");
        }
    }
}

