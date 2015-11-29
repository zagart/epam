package by.grodno.zagart.services;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import by.grodno.zagart.dataaccess.model.Order;
import by.grodno.zagart.services.impl.OrderServiceImpl;

/**
 * Class for testing OrderService methods. It uses JUnit tests.
 * 
 * @author zagart
 *
 */
public class OrderTest extends AbstractSpringClass {

	private static Random rnd = new Random();

	@Autowired
	OrderServiceImpl orderService;

	private int id;

	@Test
	public void addNewOrder() {
		Order order = randomOrder();
		id = orderService.insertNewOrder(order);
		Order testOrder = getOrderById();

		Assert.assertNotNull(testOrder);

		deleteOrder();
	}

	public static Order randomOrder() {
		Order order = new Order();
		Integer shoppingCartId = null;
		Date dateOfOrder = new Date();
		Date dateOfDeliver = new Date();
		String orderStatus = RandomStringUtils.random(rnd.nextInt(200));
		order.setDateOfOrder(dateOfOrder);
		order.setDateOfDeliver(dateOfDeliver);
		order.setOrderStatus(orderStatus);
		order.setShoppingCartId(shoppingCartId);
		return order;
	}

	public void deleteOrder() {
		orderService.deleteOrderById(id);
	}

	public Order getOrderById() {
		return orderService.getOrderById(id);
	}

}
