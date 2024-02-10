package com.example.clinic.repository;

import com.example.clinic.domain.MedicalCardEntity;
import com.example.clinic.filter.MedicalCardFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCardEntity, UUID>,
        JpaSpecificationExecutor<MedicalCardEntity> {

    default List<MedicalCardEntity> findAll(MedicalCardFilter filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }
}
