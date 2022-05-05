package myy803.testing.junit.order_processing_service.bo;

import java.sql.SQLException;

public class BOException extends Exception {

	private static final long serialVersionUID = 1L;

	public BOException(SQLException e) {

		super(e);
	}

}
