package com.tosan.online_styem.repositories;

import com.tosan.online_styem.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token getTokenByEmailId(String emailId);
}
