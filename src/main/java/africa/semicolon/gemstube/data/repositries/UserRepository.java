package africa.semicolon.gemstube.data.repositries;

import africa.semicolon.gemstube.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
