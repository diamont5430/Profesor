package server.database;

import commons.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<appUser, String> {
}
