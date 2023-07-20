package sg.edu.nus.iss.paf_day23_workshop2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day23_workshop2.model.Order;

@Repository
public class OrderRepo {
    
    @Autowired
    JdbcTemplate template;
    // SELECT o.id, o.order_date, o.customer_id, (od.quantity * od.unit_price * (1- od.discount)) as total_price, (od.quantity * p.standard_cost) as cost_price
    // from orders as o
    // inner join order_details as od on o.id=od.order_id
    // inner join products as p on p.id=od.product_id
    // where o.id=30;

    private String query = " SELECT o.id, o.order_date, o.customer_id, (od.quantity * od.unit_price * (1- od.discount)) as total_price, (od.quantity * p.standard_cost) as cost_price\n" + //
            "    from orders as o\n" + //
            "    inner join order_details as od on o.id=od.order_id\n" + //
            "    inner join products as p on p.id=od.product_id\n" + //
            "    where o.id=?";

    public List<Order> listOrder(Integer id){
        return template.query(query, BeanPropertyRowMapper.newInstance(Order.class), id);
    }
}
