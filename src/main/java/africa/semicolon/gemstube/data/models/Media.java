package africa.semicolon.gemstube.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    private String url;
    @OneToOne(fetch = FetchType.EAGER)
    private User uploader;
    private LocalDateTime createdAt;
}
