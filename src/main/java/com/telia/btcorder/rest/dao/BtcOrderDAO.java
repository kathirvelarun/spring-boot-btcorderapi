package com.telia.btcorder.rest.dao;

import org.springframework.stereotype.Repository;
import com.telia.btcorder.rest.model.BtcOrder;
import com.telia.btcorder.rest.model.BtcOrders;

@Repository
public class BtcOrderDAO 
{
    private static BtcOrders list = new BtcOrders();
    
    static 
    {
        list.getBtcOrderList().add(new BtcOrder(1, "Rod", "Johnson", "spring@gmail.com", "Btc Order"));
        list.getBtcOrderList().add(new BtcOrder(2, "James", "Goshling", "spring@gmail.com", "Btc Order"));
        list.getBtcOrderList().add(new BtcOrder(3, "Yann", "Carrdd", "spring@gmail.com", "Btc Order"));
 
    }
    
    public BtcOrders getAllBtcOrders() 
    {
        return list;
    }
    
    public void addEmployee(BtcOrder employee) {
        list.getBtcOrderList().add(employee);
    }
}
