package org.prgms.kdt;

import java.util.List;
import java.util.UUID;

public class Order {
	//Entity는 식별자를 가지고 있어야 한다
	// 보통 식별자는 UUID나 데이터베이스에서 생성되는 Long 타입을 사용하곤 한다.
	private final UUID orderId;
	private final UUID customerId;
	private final List<OrderItem> orderItems;
	private Voucher voucher;
	private OrderStatus orderStatus = OrderStatus.ACCEPTED;

	public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderItems = orderItems;
		this.voucher = voucher;
	}

	public long totalAmount() {
		var beforeDiscount = orderItems.stream()
			.map(o -> o.getProductPrice() * o.getQuantity())
			.reduce(0L, Long::sum);

		return voucher.discount(beforeDiscount);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
