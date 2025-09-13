package com.sebastianflorian.sportfinal.repository;

import com.sebastianflorian.sportfinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByFirstName(String firstName);
    boolean existsByLastName(String lastName);
    boolean existsByEmail(String email);

    boolean existsByFirstNameAndIdNot(String firstName, Integer id);
    boolean existsByLastNameAndIdNot(String lastName, Integer id);
    boolean existsByEmailAndIdNot(String email, Integer id);


}
