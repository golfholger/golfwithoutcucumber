package de.itagile.golf;

import java.util.HashMap;
import java.util.Map;

public class GolfPlatz {

    private final Map<Integer, Integer> parForLoch = new HashMap<>();

    public GolfPlatz() {
        parForLoch.put(1, 4);
        parForLoch.put(2, 5);
        parForLoch.put(3, 3);
        parForLoch.put(4, 4);
        parForLoch.put(5, 3);
        parForLoch.put(6, 4);
        parForLoch.put(7, 5);
        parForLoch.put(8, 4);
        parForLoch.put(9, 3);
        parForLoch.put(10, 5);
        parForLoch.put(11, 4);
        parForLoch.put(12, 5);
        parForLoch.put(13, 4);
        parForLoch.put(14, 3);
        parForLoch.put(15, 4);
        parForLoch.put(16, 4);
        parForLoch.put(17, 3);
        parForLoch.put(18, 5);
    }

    public int getParForLoch(final int loch){
        if(loch > 18 || loch < 1){
            return 0;
        }else return parForLoch.get(loch);
    }

    public int getLochCount(){
        return parForLoch.size();
    }

}
