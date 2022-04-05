package com.tosan.online_styem.services.impl;

import com.tosan.online_styem.base.service.impl.BaseServiceImpl;
import com.tosan.online_styem.exception.AccessDeniedRunTimeException;
import com.tosan.online_styem.models.Admin;
import com.tosan.online_styem.repositories.AdminRepository;
import com.tosan.online_styem.services.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Admin saveNotSecure(Admin admin) {
        return super.saveNotSecure(admin);
    }

    @Override
    @Transactional
    public List<Admin> saveAllNotSecure(Collection<Admin> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Admin> findByIdNotSecure(Long id) {
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Admin> findAllNotSecure() {
        return super.findAllNotSecure();
    }

    @Override
    public void deleteByIdNotSecure(Long id) {
        super.deleteByIdNotSecure(id);
        throw new AccessDeniedRunTimeException("can't delete entity with id " + id);
    }
}
