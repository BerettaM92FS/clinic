package com.example.clinic.repository;

import com.example.clinic.domain.SpecialityEntity;
import com.example.clinic.filter.SpecialityFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpecialityRepository extends JpaRepository<SpecialityEntity, UUID>,
        JpaSpecificationExecutor<SpecialityEntity> {

    default List<SpecialityEntity> findAll(SpecialityFilter filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }
}
