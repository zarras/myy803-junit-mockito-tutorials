package myy803.testing.junit.test_double_patterns;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class UserServiceSpyTest {

    @Test
    void sendsWelcomeEmailWhenUserRegisters() {

        // real object
        EmailService realEmailService = new EmailService();

        // spy wrapping the real object
        EmailService spyEmailService = spy(realEmailService);

        UserService service = new UserService(spyEmailService);

        service.registerUser("test@example.com");

        // verify interaction
        verify(spyEmailService).sendEmail("test@example.com", "Welcome!");
    }
}
