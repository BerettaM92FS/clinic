package com.example.clinic.specification;

import com.example.clinic.domain.SpecialityEntity;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class SpecialitySpec {

    public static Specification<SpecialityEntity> hasId(UUID id) {
        return id == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<SpecialityEntity> hasName(String name) {
        return name == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<SpecialityEntity> hasNameList(List<String> nameList) {
        return CollectionUtils.isEmpty(nameList)
                ? null
                : (root, query, criteriaBuilder) -> root.get("name").in(nameList);
    }
}
