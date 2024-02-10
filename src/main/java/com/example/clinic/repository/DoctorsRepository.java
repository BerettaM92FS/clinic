package com.example.clinic.repository;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.filter.DoctorsFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorsRepository extends JpaRepository<DoctorsEntity, UUID>, JpaSpecificationExecutor<DoctorsEntity> {

    default List<DoctorsEntity> findAll(DoctorsFilter filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }
}
