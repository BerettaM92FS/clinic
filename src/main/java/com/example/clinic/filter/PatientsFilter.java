package com.example.clinic.filter;

import com.example.clinic.domain.PatientsEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.UUID;

import static com.example.clinic.specification.PatientsSpec.*;

@Builder
@Getter
@Setter
public class PatientsFilter {
    private UUID id;
    private String fio;
    private Date dateBirth;
    private String phone;
    private String passport;
    private String address;

    public Specification<PatientsEntity> toSpecification() {
        return Specification.where(hasId(id))
                .and(hasFio(fio))
                .and(hasDateBirth(dateBirth))
                .and(hasPhone(phone))
                .and(hasPassport(passport))
                .and(hasAddress(address));
    }
}
