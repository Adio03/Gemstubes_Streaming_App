package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.EmailRequest;
import africa.semicolon.gemstube.dtos.responses.EmailResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Override
    public EmailResponse sendEmail(EmailRequest request) {

        return null;
    }
}
