package com.example.clinic.filter;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.domain.MedicalCardEntity;
import com.example.clinic.domain.PatientsEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.UUID;

import static com.example.clinic.specification.MedicalCardSpec.*;

@Builder
@Getter
@Setter
public class MedicalCardFilter {
    private UUID id;
    private Integer number;
    private PatientsEntity patient;
    private String patFio;
    private String patPhone;
    private DoctorsEntity doctor;
    private Date dateAdd;
    private String diagnosis;

    public Specification<MedicalCardEntity> toSpecification() {
        return Specification.where(hasId(id))
                .and(hasNumber(number))
                .and(hasPatient(patient))
                .and(hasPatFio(patFio))
                .and(hasPatPhone(patPhone))
                .and(hasDoctor(doctor))
                .and(hasDateAdd(dateAdd))
                .and(hasDiagnosis(diagnosis));
    }
}
