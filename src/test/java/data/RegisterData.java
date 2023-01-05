package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RegisterData {
    public String firstName, lastName, email, password;

    public void userData() throws IOException, ParseException {
        String src = System.getProperty("user.dir")+"/src/test/java/data/RegisterData.json";
        File file = new File(src);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object jsonObj : JArray){
            JSONObject person = (JSONObject) jsonObj;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            email = (String) person.get("email");
            password = (String) person.get("password");
        }
    }
}
