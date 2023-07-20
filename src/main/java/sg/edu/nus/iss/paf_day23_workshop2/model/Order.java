package sg.edu.nus.iss.paf_day23_workshop2.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Date orderDate;
    private Integer customerId;
    private double totalPrice;
    private double costPrice;
}
