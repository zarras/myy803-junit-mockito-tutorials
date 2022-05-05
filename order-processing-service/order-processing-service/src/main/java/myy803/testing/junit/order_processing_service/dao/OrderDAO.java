package myy803.testing.junit.order_processing_service.dao;

import java.sql.SQLException;

public interface OrderDAO {

	int create(Order order) throws SQLException;

	Order read(int id) throws SQLException;

	int update(Order order) throws SQLException;

	int delete(int id) throws SQLException;

}
