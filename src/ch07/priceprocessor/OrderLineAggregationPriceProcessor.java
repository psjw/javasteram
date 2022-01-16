package ch07.priceprocessor;


import ch07.model.Order;
import ch07.model.OrderLine;

import java.math.BigDecimal;
import java.util.function.Function;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getOrderLines().stream()
                .map(OrderLine::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add));
    }
}
