package sg.edu.nus.iss.paf_day23_workshop2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day23_workshop2.model.Order;
import sg.edu.nus.iss.paf_day23_workshop2.repository.OrderRepo;

@Service
public class OrderSvc {
    @Autowired
    OrderRepo repo;
    
    public List<Order> listOrder(Integer id){
        return repo.listOrder(id);
    }
}
