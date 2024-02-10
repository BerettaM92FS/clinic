package com.example.clinic.specification;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.domain.SpecialityEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class DoctorsSpec {

    public static Specification<DoctorsEntity> hasId(UUID id) {
        return id == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<DoctorsEntity> hasFio(String fio) {
        return fio == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fio"), "%" + fio + "%");
    }

    public static Specification<DoctorsEntity> hasSpec(SpecialityEntity spec) {
        return spec == null
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<DoctorsEntity, SpecialityEntity> specJoin = root.join("spec", JoinType.LEFT);
            return criteriaBuilder.equal(specJoin, spec);
        });
    }

    public static Specification<DoctorsEntity> hasSpecName(String specName) {
        return specName == null
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<DoctorsEntity, SpecialityEntity> specJoin = root.join("spec", JoinType.LEFT);
            return criteriaBuilder.like(specJoin.get("name"), "%" + specName + "%");
        });
    }

    public static Specification<DoctorsEntity> hasSpecIds(List<UUID> specIds) {
        return CollectionUtils.isEmpty(specIds)
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<DoctorsEntity, SpecialityEntity> specJoin = root.join("spec", JoinType.LEFT);
            return specJoin.get("id").in(specIds);
        });
    }

    public static Specification<DoctorsEntity> hasHiringDate(Date hiringDate) {
        return hiringDate == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("hiringDate"), hiringDate);
    }

    public static Specification<DoctorsEntity> hasPhone(String phone) {
        return phone == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("phone"), "%" + phone + "%");
    }

    public static Specification<DoctorsEntity> hasAddress(String address) {
        return address == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("address"), "%" + address + "%");
    }
}
