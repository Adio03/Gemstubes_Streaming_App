package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.EmailRequest;
import africa.semicolon.gemstube.dtos.responses.EmailResponse;

public interface EmailService {
    EmailResponse sendEmail(EmailRequest request);
}
