package africa.semicolon.gemstube.data.repositries;

import africa.semicolon.gemstube.data.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media,Long> {
}
