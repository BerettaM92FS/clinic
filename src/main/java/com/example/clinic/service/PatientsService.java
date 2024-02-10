package com.example.clinic.service;

import com.example.clinic.dto.PatientsDto;
import com.example.clinic.filter.PatientsFilter;

import java.util.List;
import java.util.UUID;

public interface PatientsService {

    PatientsDto getById(UUID id);

    List<PatientsDto> findAll();

    List<PatientsDto> findByFilter(PatientsFilter filter);

    String save(PatientsDto dto);

    String delete(UUID id);

    String update(PatientsDto dto);
}
