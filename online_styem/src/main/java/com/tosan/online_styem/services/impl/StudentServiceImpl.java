package com.tosan.online_styem.services.impl;

import com.tosan.online_styem.base.service.impl.BaseServiceImpl;
import com.tosan.online_styem.exception.AccessDeniedRunTimeException;
import com.tosan.online_styem.models.Student;
import com.tosan.online_styem.repositories.StudentRepository;
import com.tosan.online_styem.services.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, Long, StudentRepository> implements StudentService {

    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Student saveNotSecure(Student student) {
        return super.saveNotSecure(student);
    }

    @Override
    @Transactional
    public List<Student> saveAllNotSecure(Collection<Student> collection) {
        return super.saveAllNotSecure(collection);
    }

    @Override
    public Optional<Student> findByIdNotSecure(Long id) {
        return super.findByIdNotSecure(id);
    }

    @Override
    public List<Student> findAllNotSecure() {
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
