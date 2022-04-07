package com.tosan.online_styem.repositories;

import com.tosan.online_styem.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token getTokenByEmailId(String emailId);

    @Modifying
    @Query("update Token t set t.authenticationToken = :auth , t.secretKey = :secret where t.emailId = :email")
    int updateToken(@Param("email") String email, @Param("auth") String authenticationToken, @Param("secret") String secretKey);
}
