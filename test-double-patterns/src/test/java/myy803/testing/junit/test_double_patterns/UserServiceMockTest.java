package myy803.testing.junit.test_double_patterns;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class UserServiceMockTest {

	@Test
    void sendsWelcomeEmailWhenUserRegisters() {

        // real object
        EmailService realEmailService = new EmailService();

        // spy wrapping the real object
        EmailService mockEmailService = mock(EmailService.class);
        
        UserService service = new UserService(mockEmailService);

        service.registerUser("test@example.com");

        // verify interaction
        verify(mockEmailService).sendEmail("test@example.com", "Welcome!");
    }
}
