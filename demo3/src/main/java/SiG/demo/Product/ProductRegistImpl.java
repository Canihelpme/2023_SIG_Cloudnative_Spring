package SiG.demo.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductRegistImpl implements ProductRegist {

    public void productRegist(String name, int price) {

        Product product = new Product(name, price);

    }
}




