package lk.company.notesmanagementAPI.repository;

import lk.company.notesmanagementAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
