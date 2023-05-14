package SiG.demo.OrderService;

import org.springframework.stereotype.Component;

@Component
public class StatelessOrderService {

    public Order createOrder(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        return new Order(name, price);
    }
}




