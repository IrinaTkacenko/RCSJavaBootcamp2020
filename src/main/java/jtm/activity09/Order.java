package jtm.activity09;

/*- TODO #1
 * Implement Comparable interface with Order class
 * Hint! Use generic type of comparable items in form: Comparable<Order>
 * 
 * TODO #2 Override/implement necessary methods for Order class:
 * - public Order(String orderer, String itemName, Integer count) — constructor of the Order
 * - public int compareTo(Order order) — comparison implementation according to logic described below
 * - public boolean equals(Object object) — check equality of orders
 * - public int hashCode() — to be able to handle it in some hash... collection 
 * - public String toString() — string in following form: "ItemName: OrdererName: Count"
 * 
 * Hints:
 * 1. When comparing orders, compare their values in following order:
 *    - Item name
 *    - Customer name
 *    - Count of items
 * If item or customer is closer to start of alphabet, it is considered "smaller"
 * 
 * 2. When implementing .equals() method, rely on compareTo() method, as for sane design
 * .equals() == true, if compareTo() == 0 (and vice versa).
 * 
 * 3. Also Ensure that .hashCode() is the same, if .equals() == true for two orders.
 * 
 */

import java.util.Objects;

public class  Order implements Comparable<Order>{
	String customer; // Name of the customer
	String name; // Name of the requested item
	int count; // Count of the requested items

	public Order(String orderer, String itemName, Integer count) {
		customer = orderer;
		name = itemName;
		this.count = count;
	}

	@Override
	public int compareTo(Order order) {
		if(name.compareTo(order.name) != 0) {
			return name.compareTo(order.name) > 0 ? 1 : -1;
		}else {
			if(customer.compareTo(order.customer) != 0) {
				return customer.compareTo(order.customer) > 0 ? 1 : -1;
			}else {
				if(count != order.count) {
					return count > order.count ? 1 : -1;
				}
			}
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;
		Order order = (Order) o;
		return count == order.count &&
				Objects.equals(customer, order.customer) &&
				Objects.equals(name, order.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, name, count);
	}

	@Override
	public String toString() {
		return name +": " + customer + ": " + count;
	}
}
