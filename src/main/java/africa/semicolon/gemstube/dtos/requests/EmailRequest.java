package africa.semicolon.gemstube.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmailRequest {
    private Sender sender;
    @JsonProperty("to")
    private List<Recipient> recipients;
}
