package myy803.testing.junit.order_processing_service;

import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import myy803.testing.junit.order_processing_service.bo.BOException;
import myy803.testing.junit.order_processing_service.bo.OrderBOImpl;
import myy803.testing.junit.order_processing_service.dao.Order;
import myy803.testing.junit.order_processing_service.dao.OrderDAOImpl;


@ExtendWith(MockitoExtension.class)
public class OrderBOImplTest {

	private static final int ORDER_ID = 123;
	
	@Mock
	private OrderDAOImpl dao;
	@InjectMocks
	private OrderBOImpl bo;

	@Test
	public void placeOrder_Should_Return_True() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);

		Assertions.assertTrue(result);
		verify(dao, atLeast(1)).create(order);

	}

	@Test
	public void placeOrder_Should_Return_False() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		boolean result = bo.placeOrder(order);

		Assertions.assertFalse(result);
		verify(dao).create(order);

	}

	@Test
	public void cancelOrder_Should_Return_True() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(anyInt())).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(ORDER_ID);
		Assertions.assertTrue(result);

		verify(dao).read(anyInt());
		verify(dao).update(order);

	}

	@Test
	public void cancelOrder_Should_Return_False() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result = bo.cancelOrder(ORDER_ID);

		Assertions.assertFalse(result);

		verify(dao).read(ORDER_ID);
		verify(dao).update(order);

	}

	public void cancelOrder_ShouldThrowABOExceptionOnRead() throws SQLException, BOException {
		
		when(dao.read(anyInt())).thenThrow(SQLException.class);
		
		Assertions.assertThrows(BOException.class, () -> {bo.cancelOrder(ORDER_ID);});
	}

	public void cancelOrder_Should_Throw_A_BOExceptionOnUpdate() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(ORDER_ID)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);
		Assertions.assertThrows(BOException.class, () -> {bo.cancelOrder(ORDER_ID);});	}

	@Test
	public void deleteOrder_Should_Return_True() throws SQLException, BOException {

		when(dao.delete(ORDER_ID)).thenReturn(1);
		boolean result = bo.deleteOrder(ORDER_ID);
		Assertions.assertTrue(result);
		verify(dao).delete(ORDER_ID);

	}

}
