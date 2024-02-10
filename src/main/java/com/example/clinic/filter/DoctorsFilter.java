package com.example.clinic.filter;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.domain.SpecialityEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.example.clinic.specification.DoctorsSpec.*;

@Builder
@Getter
@Setter
public class DoctorsFilter {
    private UUID id;
    private String fio;
    private SpecialityEntity spec;
    private String specName;
    private List<UUID> specIds;
    private Date hiringDate;
    private String phone;
    private String address;

    public Specification<DoctorsEntity> toSpecification() {
        return Specification.where(hasId(id))
                .and(hasFio(fio))
                .and(hasSpec(spec))
                .and(hasSpecName(specName))
                .and(hasSpecIds(specIds))
                .and(hasHiringDate(hiringDate))
                .and(hasPhone(phone))
                .and(hasAddress(address));
    }
}
