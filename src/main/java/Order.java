import lombok.With;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@With
public record Order(
        String id,
        List<Product> products,
        OrderStatus orderStatus,
        LocalDateTime timestamp
) {
    /*
    Add an order status to the Order (PROCESSING, IN_DELIVERY, COMPLETED) to determine the status of the order.
     */
}
