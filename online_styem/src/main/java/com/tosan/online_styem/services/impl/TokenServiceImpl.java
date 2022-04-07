package com.tosan.online_styem.services.impl;

import com.tosan.online_styem.base.service.impl.BaseServiceImpl;
import com.tosan.online_styem.exception.AccessDeniedRunTimeException;
import com.tosan.online_styem.models.Token;
import com.tosan.online_styem.repositories.TokenRepository;
import com.tosan.online_styem.services.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl extends BaseServiceImpl<Token, Integer, TokenRepository> implements TokenService {

    public TokenServiceImpl(TokenRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Token saveNotSecure(Token student) {
        return super.saveNotSecure(student);
    }

    @Override
    @Transactional
    public List<Token> saveAllNotSecure(Collection<Token> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Token> findByIdNotSecure(Integer id) {
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Token> findAllNotSecure() {
        return super.findAllNotSecure();
    }

    @Override
    public void deleteByIdNotSecure(Integer id) {
        try {
            super.deleteByIdNotSecure(id);

        } catch (Exception e) {
            throw new AccessDeniedRunTimeException("can't delete entity with id " + id);

        }
    }

    @Override
    public int getTokenDetail(String emailId) {
        int tokenId = 0;
        try {
            Token tokenByEmailId = super.repository.getTokenByEmailId(emailId);
            if (tokenByEmailId != null) {
                tokenId = tokenByEmailId.getId();
                return tokenId;
            }

        } catch (Exception e) {
            throw new AccessDeniedRunTimeException("Exception while getting the Token Id.");

        }

        return tokenId;
    }

    @Override
    public boolean updateToken(String email, String authenticationToken, String secretKey) {
        return super.repository.updateToken(email, authenticationToken, secretKey) == 1;
    }
}
