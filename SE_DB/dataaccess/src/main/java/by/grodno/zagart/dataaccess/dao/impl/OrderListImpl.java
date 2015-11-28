package by.grodno.zagart.dataaccess.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.grodno.zagart.dataaccess.dao.OrderListDao;
import by.grodno.zagart.dataaccess.dao.mapper.OrderListMapper;
import by.grodno.zagart.dataaccess.model.OrderList;

@Repository
public class OrderListImpl implements OrderListDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public OrderList getById(Integer id) {
		return jdbc.queryForObject("SELECT * FROM order_list WHERE id = " + id, new OrderListMapper());
	}

	@Override
	public void deleteById(Integer id) {
		jdbc.update("DELETE FROM order_list WHERE id = " + id);
	}

	@Override
	public void insert(OrderList list) {
		jdbc.update("INSEST INTO order_list (id, product_id, product_quantity) VALUES (?,?,?)", list.getId(),
				list.getProductId(), list.getProductQuantity());
	}

}
