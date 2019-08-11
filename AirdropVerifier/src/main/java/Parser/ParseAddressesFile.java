package Parser;

import Models.HolderModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseAddressesFile {
    //generates the post url every 20 addresses or less

    private BufferedReader reader;
    private String prefix = "https://api.etherscan.io/api?module=account&action=balancemulti&address=";
    private String suffix = "&tag=latest&apikey=notNeeded";
    boolean hasNextSet = true;

    public ParseAddressesFile(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
     }

     public String getNextUrlString() throws IOException {

        if(!hasNextSet)return null;

        String ret = "";

         ArrayList<String> addresses = new ArrayList<String>();
         for(int t=0;t<20;t++){
             String line = reader.readLine();
             if(line==null){
                 hasNextSet = false;
                 break;}
             addresses.add(line);
         }

         ret = prefix;
         for(String address:addresses){
             ret = ret+address+",";
         }
         ret = ret.substring(0,ret.length());
         ret = ret+suffix;

        return ret;

     }





}
