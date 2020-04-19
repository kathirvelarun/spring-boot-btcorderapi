package com.telia.btcorder.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.telia.btcorder.rest.dao.BtcOrderDAO;
import com.telia.btcorder.rest.model.BtcOrder;
import com.telia.btcorder.rest.model.BtcOrders;

@RestController
@RequestMapping(path = "/btcorderapi")
public class BtcOrderController 
{
    @Autowired
    private BtcOrderDAO btcOrderDao;
    
    @GetMapping(path="/", produces = "application/json")
    public BtcOrders getEmployees() 
    {
        return btcOrderDao.getAllBtcOrders();
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody BtcOrder employee) 
                 throws Exception 
    {       
        //Generate resource id
        Integer id = btcOrderDao.getAllBtcOrders().getBtcOrderList().size() + 1;
        employee.setId(id);
        
        //add resource
        btcOrderDao.addEmployee(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
