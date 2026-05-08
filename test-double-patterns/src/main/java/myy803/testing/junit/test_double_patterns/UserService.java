package myy803.testing.junit.test_double_patterns;

class UserService {

    private EmailService emailService;

    UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    void registerUser(String email) {
        // business logic (e.g. save user)

        // important side effect
        emailService.sendEmail(email, "Welcome!");
    }
}
