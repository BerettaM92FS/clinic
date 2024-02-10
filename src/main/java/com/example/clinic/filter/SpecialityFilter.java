package com.example.clinic.filter;

import com.example.clinic.domain.SpecialityEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

import static com.example.clinic.specification.SpecialitySpec.*;

@Builder
@Getter
@Setter
public class SpecialityFilter {
    private UUID id;
    private String name;
    private List<String> nameList;

    public Specification<SpecialityEntity> toSpecification() {
        return Specification.where(hasId(id))
                .and(hasName(name))
                .and(hasNameList(nameList));
    }
}
