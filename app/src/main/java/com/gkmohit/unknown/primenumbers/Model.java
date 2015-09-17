package com.gkmohit.unknown.primenumbers;

import java.util.ArrayList;

/**
 * Created by AirUnknown on 14-12-12.
 */
public class Model {

    /**
     A good model hides the implementation of its data. Here,
     the list is implemented as an ArrayList. The controller
     passes the model a string as input, and expects a string
     as output. The details of how this is done are known only
     to the model.
     */
    private ArrayList<Integer> factorList;

    public Model(){
        factorList = new ArrayList<Integer>();
        factorList.add(1);
    }

    public void addFactor(int factor){
        //accept a factor and add it to the list:
        factorList.add(factor);
    }

    public int size(){
        int tempSize = this.factorList.size();
        return tempSize;
    }
    public String getList() {
        //return a string representation of the list:
        String retVal = new String();
        for (Integer factor : factorList)
            retVal = String.format("%s %d, ", retVal, factor);
        return retVal;
    }
    public ArrayList getArrayList(){
        ArrayList temp = this.factorList;
        return temp;
    }
    public void clear(){
        factorList.clear();
    }
//    public ArrayAdapter toArrayAdaptor(){
//        ArrayAdapter myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.factorList);
//    }
}