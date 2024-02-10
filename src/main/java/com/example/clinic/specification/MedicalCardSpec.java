package com.example.clinic.specification;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.domain.MedicalCardEntity;
import com.example.clinic.domain.PatientsEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.UUID;

@UtilityClass
public class MedicalCardSpec {

    public static Specification<MedicalCardEntity> hasId(UUID id) {
        return id == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<MedicalCardEntity> hasNumber(Integer number) {
        return number == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("number"), "%" + number + "%");
    }

    public static Specification<MedicalCardEntity> hasPatient(PatientsEntity patient) {
        return patient == null
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<MedicalCardEntity, PatientsEntity> patientJoin = root.join("patient", JoinType.LEFT);
            return criteriaBuilder.equal(patientJoin, patient);
        });
    }

    public static Specification<MedicalCardEntity> hasPatFio(String patFio) {
        return patFio == null
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<MedicalCardEntity, PatientsEntity> patientJoin = root.join("patient", JoinType.LEFT);
            return criteriaBuilder.like(patientJoin.get("fio"), "%" + patFio + "%");
        });
    }

    public static Specification<MedicalCardEntity> hasPatPhone(String patPhone) {
        return patPhone == null
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<MedicalCardEntity, PatientsEntity> patientJoin = root.join("patient", JoinType.LEFT);
            return criteriaBuilder.like(patientJoin.get("phone"), "%" + patPhone + "%");
        });
    }

    public static Specification<MedicalCardEntity> hasDoctor(DoctorsEntity doctor) {
        return doctor == null
                ? null
                : ((root, query, criteriaBuilder) -> {
            Join<MedicalCardEntity, DoctorsEntity> doctorJoin = root.join("patient", JoinType.LEFT);
            return criteriaBuilder.equal(doctorJoin, doctor);
        });
    }

    public static Specification<MedicalCardEntity> hasDateAdd(Date dateAdd) {
        return dateAdd == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("dateAdd"), dateAdd);
    }

    public static Specification<MedicalCardEntity> hasDiagnosis(String diagnosis) {
        return diagnosis == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("diagnosis"), "%" + diagnosis + "%");
    }
}
