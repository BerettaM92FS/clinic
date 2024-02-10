package com.example.clinic.specification;

import com.example.clinic.domain.PatientsEntity;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.UUID;

@UtilityClass
public class PatientsSpec {

    public static Specification<PatientsEntity> hasId(UUID id) {
        return id == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<PatientsEntity> hasFio(String fio) {
        return fio == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fio"), "%" + fio + "%");
    }

     public static Specification<PatientsEntity> hasDateBirth(Date dateBirth) {
        return dateBirth == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("dateBirth"), dateBirth);
     }

     public static Specification<PatientsEntity> hasPhone(String phone) {
         return phone == null
                 ? null
                 : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("phone"), "%" + phone + "%");
     }

     public static Specification<PatientsEntity> hasPassport(String passport) {
        return passport == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("passport"), "%" + passport + "%");
     }

     public static Specification<PatientsEntity> hasAddress(String address) {
         return address == null
                 ? null
                 : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("address"), "%" + address + "%");
     }
}
