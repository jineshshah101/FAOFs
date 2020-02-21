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
import java.util.Vector;
import java.util.List; 

//This file has been supplied to us from class
//There are barely any changes in this file
public class JsonSerializer {

    public JsonSerializer() {
    }

    public String serialize(Object obj) {
        String str = null; 
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_NULL);
            str = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            str = "<error>"; 
        }
        return str;
    }


    // test app 
    public static void main(String[] args) {
        
    }
    
}

