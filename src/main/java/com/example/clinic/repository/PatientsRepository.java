package com.example.clinic.repository;

import com.example.clinic.domain.PatientsEntity;
import com.example.clinic.filter.PatientsFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientsRepository extends JpaRepository<PatientsEntity, UUID>,
        JpaSpecificationExecutor<PatientsEntity> {

    default List<PatientsEntity> findAll(PatientsFilter filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }
}
