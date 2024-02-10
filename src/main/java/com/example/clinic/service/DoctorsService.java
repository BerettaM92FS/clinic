package com.example.clinic.service;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.dto.DoctorsDto;
import com.example.clinic.filter.DoctorsFilter;

import java.util.List;
import java.util.UUID;

public interface DoctorsService {

    DoctorsDto getById(UUID id);

    List<DoctorsDto> findAll();

    List<DoctorsDto> findByFilter(DoctorsFilter filter);

    String save(DoctorsDto dto);

    String delete(UUID id);

    String update(DoctorsDto dto);

    DoctorsEntity getByIdEntity(UUID id);
}
