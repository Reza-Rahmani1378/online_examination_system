package com.tosan.online_styem.services.impl;

import com.tosan.online_styem.base.service.impl.BaseServiceImpl;
import com.tosan.online_styem.exception.AccessDeniedRunTimeException;
import com.tosan.online_styem.models.Professor;
import com.tosan.online_styem.repositories.ProfessorRepository;
import com.tosan.online_styem.services.ProfessorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl extends BaseServiceImpl<Professor, Long, ProfessorRepository> implements ProfessorService {

    public ProfessorServiceImpl(ProfessorRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Professor saveNotSecure(Professor professor) {
        return super.saveNotSecure(professor);
    }

    @Override
    @Transactional
    public List<Professor> saveAllNotSecure(Collection<Professor> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Professor> findByIdNotSecure(Long id) {
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Professor> findAllNotSecure() {
        return super.findAllNotSecure();
    }

    @Override
    public void deleteByIdNotSecure(Long id) {
        super.deleteByIdNotSecure(id);
        throw new AccessDeniedRunTimeException("can't delete entity with id " + id);
    }
}
