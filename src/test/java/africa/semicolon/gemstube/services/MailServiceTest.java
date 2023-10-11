package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.EmailRequest;
import africa.semicolon.gemstube.dtos.requests.Recipient;
import africa.semicolon.gemstube.dtos.requests.Sender;
import africa.semicolon.gemstube.dtos.responses.EmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MailServiceTest {
    @Autowired
    private EmailService emailService;
    @Test
    public void testSendMail(){
        Sender sender = new Sender();
        sender.setName("joy");
        sender.setEmail("joy@gmail.com");

        Recipient recipient = new Recipient();
        recipient.setName("Nati");
        recipient.setEmail("yoxepo7226@fesgrid.com");
        List<Recipient> recipients = List.of(recipient);

        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setSender(sender );
        emailRequest.setRecipients(recipients);
        emailRequest.setHtmlContent("<p>We are testing our app</p>");
        emailRequest.setSubject("testing 123...");

        EmailResponse response = emailService.sendEmail(emailRequest);
        assertNotNull(response);
        assertNotNull(response.getMessage());

    }

}
