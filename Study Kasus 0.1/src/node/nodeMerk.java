package node;

import java.util.ArrayList;

public class nodeMerk {
    public String merk;
    public ArrayList<nodeSepatu> sepatuList;

    public nodeMerk(String merk, ArrayList<nodeSepatu> sepatuList) {
        this.merk = merk;
        this.sepatuList = sepatuList;
    }

    public ArrayList<nodeSepatu> getSepatuList() {
        return this.sepatuList;
    }

    public void setSepatuList(ArrayList<nodeSepatu> sepatuList) {
        this.sepatuList = sepatuList;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

}
