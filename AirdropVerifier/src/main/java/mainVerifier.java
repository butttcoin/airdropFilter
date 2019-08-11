import Filter.FilterHolders;
import Models.HolderModel;
import Parser.MultiResponse;
import Parser.ParseAddressesFile;
import Requests.PostRequest;
import Writers.WriteHolders;

import java.util.List;

public class mainVerifier {

    //Make a list of ETH addresses in a data/data.txt delimited by the enter key

    public static void main(String[] args){

        try{

            double pauseInSeconds = 1/5; //5 posts per second
            PostRequest postRequest = new PostRequest();
            MultiResponse multiResponse = new MultiResponse();
            ParseAddressesFile parseAddressesFile = new ParseAddressesFile("data/data.txt");
            String outFile = "data/filtered.txt";
            FilterHolders filterHolders = new FilterHolders();
            WriteHolders writeHolders = new WriteHolders();


            String url = parseAddressesFile.getNextUrlString();
            while(url!=null){

                String response = postRequest.sendPost(url);
                HolderModel[] hmArr = multiResponse.getHolderModels(response);
                List<HolderModel> filtered = filterHolders.removeZeroHolders(hmArr);
                writeHolders.write(outFile,filtered);

                Thread.sleep((long) pauseInSeconds*1001);
                url = parseAddressesFile.getNextUrlString();
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
