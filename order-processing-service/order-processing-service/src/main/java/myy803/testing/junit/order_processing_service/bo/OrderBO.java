package myy803.testing.junit.order_processing_service.bo;

import myy803.testing.junit.order_processing_service.dao.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
