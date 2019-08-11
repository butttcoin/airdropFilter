package Filter;

import Models.HolderModel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FilterHolders {

    public List<HolderModel> removeZeroHolders(HolderModel[] holderModels){

        ArrayList<HolderModel> ret = new ArrayList<HolderModel>();
        for(HolderModel hm:holderModels){
            BigInteger val = new BigInteger(hm.getBalance());
            if(val.compareTo(new BigInteger("100000"))==1){ //this way we avoid the dust holders and the zero holders
                ret.add(hm);
            }
        }
        return ret;
    }

}
