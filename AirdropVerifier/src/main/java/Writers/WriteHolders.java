package Writers;

import Models.HolderModel;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteHolders {

    public void write(String file, List<HolderModel> holderModels) throws IOException {

        for(HolderModel hm:holderModels) {
            FileUtils.write(new File(file),hm.getAccount()+"\n",true);
        }


    }


}
