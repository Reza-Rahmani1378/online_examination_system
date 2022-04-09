package com.tosan.online_styem.repositories;

import com.tosan.online_styem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByPasswordAndEmail(String password, String email);

    User getUserByEmail(String email);
}
