package Parser;

import Models.HolderModel;
import com.google.gson.Gson;

public class MultiResponse {
    private Gson gson = new Gson();

    public HolderModel[] getHolderModels(String response){
        response = "["+
                response.substring(response.indexOf("\"result\":[")+"\"result\":[".length(),response.length()-2)
                    +"]";

        return gson.fromJson(response, HolderModel[].class);
    }


}
