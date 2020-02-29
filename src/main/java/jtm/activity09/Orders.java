package jtm.activity09;


/*- TODO #2
 * Implement Iterator interface with Orders class
 * Hint! Use generic type argument of iterateable items in form: Iterator<Order>
 * 
 * TODO #3 Override/implement public methods for Orders class:
 * - Orders()                — create new empty Orders
 * - add(Order item)            — add passed order to the Orders
 * - List<Order> getItemsList() — List of all customer orders
 * - Set<Order> getItemsSet()   — calculated Set of Orders from list (look at description below)
 * - sort()                     — sort list of orders according to the sorting rules
 * - boolean hasNext()          — check is there next Order in Orders
 * - Order next()               — get next Order from Orders, throw NoSuchElementException if can't
 * - remove()                   — remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
 * - String toString()          — show list of Orders as a String
 * 
 * Hints:
 * 1. To convert Orders to String, reuse .toString() method of List.toString()
 * 2. Use built in List.sort() method to sort list of orders
 * 
 * TODO #4
 * When implementing getItemsSet() method, join all requests for the same item from different customers
 * in following way: if there are two requests:
 *  - ItemN: Customer1: 3
 *  - ItemN: Customer2: 1
 *  Set of orders should be:
 *  - ItemN: Customer1,Customer2: 4
 */
import java.util.*;

public class Orders implements Iterator<Order> {

	/*-
	 * TODO #1
	 * Create data structure to hold:
	 *   1. some kind of collection of Orders (e.g. some List)
	 *   2. index to the current order for iterations through the Orders in Orders
	 *   Hints:
	 *   1. you can use your own implementation or rely on .iterator() of the List
	 *   2. when constructing list of orders, set number of current order to -1
	 *      (which is usual approach when working with iterateable collections).
	 */
	private List<Order> listOfOrders;
	private ListIterator<Order> it;

	public Orders() {
		listOfOrders = new ArrayList<>();
		it = listOfOrders.listIterator();
	}

	public void add(Order item) {
		it.add(item);
		it.previous();
	}

	public List<Order> getItemsList() {
		return listOfOrders;
	}

	public Set<Order> getItemsSet() {
		Set<Order> set = new TreeSet<>();
		Set<String> uniqueItems = new TreeSet<>();
		List<String> multipleCustomers = new ArrayList<>();
		int totalCountForItem = 0;
		for (Order order:listOfOrders) {
			uniqueItems.add(order.name);
		}
		for (String item:uniqueItems) {
			for (int i = 0; i < listOfOrders.size(); i++) {
				if(listOfOrders.get(i).name.equals(item)) {
					multipleCustomers.add(listOfOrders.get(i).customer);
					totalCountForItem += listOfOrders.get(i).count;
				}
			}
			Collections.sort(multipleCustomers);
			String customer = "";
			for(int i = 0; i < multipleCustomers.size(); i++) {
				if(i == multipleCustomers.size()-1) {
					customer += multipleCustomers.get(i);
					break;
				}
				customer += multipleCustomers.get(i) + ",";
			}
			set.add(new Order(customer, item, totalCountForItem));
			multipleCustomers.clear();
			totalCountForItem = 0;
		}
        return set;
	}

	public void sort() {
		Collections.sort(listOfOrders);
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Order next() {
		return it.next();
	}

	@Override
	public void remove() {
		it.remove();
	}

	@Override
	public String toString() {
		return listOfOrders.toString();
	}
}
