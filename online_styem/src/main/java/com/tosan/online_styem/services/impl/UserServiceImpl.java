package com.tosan.online_styem.services.impl;

import com.tosan.online_styem.base.service.impl.BaseServiceImpl;
import com.tosan.online_styem.exception.AccessDeniedRunTimeException;
import com.tosan.online_styem.models.User;
import com.tosan.online_styem.repositories.UserRepository;
import com.tosan.online_styem.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public User saveNotSecure(User user) {
        return super.saveNotSecure(user);
    }

    @Override
    @Transactional
    public List<User> saveAllNotSecure(Collection<User> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<User> findByIdNotSecure(Long id) {
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<User> findAllNotSecure() {
        return super.findAllNotSecure();
    }

    @Override
    public void deleteByIdNotSecure(Long id) {
        try {

            super.deleteByIdNotSecure(id);
        } catch (Exception e) {
            throw new AccessDeniedRunTimeException("can't delete entity with id " + id);
        }

    }
}
