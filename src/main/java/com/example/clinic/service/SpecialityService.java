package com.example.clinic.service;

import com.example.clinic.dto.SpecialityDto;
import com.example.clinic.filter.SpecialityFilter;

import java.util.List;
import java.util.UUID;

public interface SpecialityService {

    SpecialityDto getById(UUID id);

    List<SpecialityDto> findAll();

    List<SpecialityDto> findByFilter(SpecialityFilter filter);

    String save(SpecialityDto dto);

    String delete(UUID id);

    String update(SpecialityDto dto);
}
