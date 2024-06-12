import lombok.With;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.System.*;

@With
public class ShopService {

    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();
    private List<Product> products;

    public Order addOrder(List<String> productIds) throws ProductNotFoundException {
         /*
        Modify the 'addOrder' method in the ShopService so that an exception is thrown if the product does not exist.
        Extend the Order object with a field that stores the order timestamp.
        In the 'addOrder' method, fill this field with the current timestamp.
         */

        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId).orElseThrow(()-> new ProductNotFoundException("No product found"));
            if (productToOrder == null) {
                out.println("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
                return null;
            }
            products.add(productToOrder);
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING, LocalDateTime.now());

        return orderRepo.addOrder(newOrder);
    }

    public List<Order>orderList (OrderStatus orderStatus){
/*
Write a method in the ShopService that returns a list of all orders with a specific order status (parameter) using streams.
 */

        return orderRepo.getOrders().stream().filter(n -> n.orderStatus().equals(orderStatus)).toList();

    }
    public void updateOrder(String newId,  Order newOrderStatus){
/*
    Add an 'updateOrder' method in the ShopService that updates the Order based on an orderId and a new order status.
    Use the Lombok @With annotation for this.
     */
        for (int i = 0; i < products.size(); i++) {
            Product order = products.get(i);
            if (order.id().equals(newId)) {
                products.set(i, newOrderStatus.products().get(i));
            }
        }
    }
}
