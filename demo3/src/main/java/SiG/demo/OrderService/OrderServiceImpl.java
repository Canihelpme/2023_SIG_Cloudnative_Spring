package SiG.demo.OrderService;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    @Override
    public Order requestOrder(){

        Order newOrder = new Order("Computer", 100000);

        return newOrder;

    }

}
