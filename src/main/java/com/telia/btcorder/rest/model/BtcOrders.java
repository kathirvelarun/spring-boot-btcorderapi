package com.telia.btcorder.rest.model;

import java.util.ArrayList;
import java.util.List;

public class BtcOrders 
{
    private List<BtcOrder> btcOrderList;
    
    public List<BtcOrder> getBtcOrderList() {
        if(btcOrderList == null) {
        	btcOrderList = new ArrayList<>();
        }
        return btcOrderList;
    }
 
    public void setBtcOrderList(List<BtcOrder> btcOrderList) {
        this.btcOrderList = btcOrderList;
    }
}
