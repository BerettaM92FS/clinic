package com.example.clinic.service.impl;

import com.example.clinic.domain.PatientsEntity;
import com.example.clinic.dto.PatientsDto;
import com.example.clinic.filter.PatientsFilter;
import com.example.clinic.repository.PatientsRepository;
import com.example.clinic.service.PatientsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientsServiceImpl implements PatientsService {

    @Autowired
    private PatientsRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientsDto getById(UUID id) {
        Optional<PatientsEntity> entity = repository.findById(id);
        return modelMapper.map(entity, PatientsDto.class);
    }

    @Override
    public List<PatientsDto> findAll() {
        List<PatientsEntity> entities = repository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, PatientsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientsDto> findByFilter(PatientsFilter filter) {
        List<PatientsEntity> entities = repository.findAll(filter);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, PatientsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String save(PatientsDto dto) {
        PatientsEntity entity = modelMapper.map(dto, PatientsEntity.class);
        return String.valueOf(repository.save(entity).getId());
    }

    @Override
    public String delete(UUID id) {
        PatientsEntity entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
        return "Объект удалён!";
    }

    @Override
    public String update(PatientsDto dto) {
        Optional<PatientsEntity> entityOptional = repository.findById(dto.getId());
        if (entityOptional.isPresent()) {
            PatientsEntity entity = entityOptional.get();
            PatientsEntity dtoToEntity = modelMapper.map(dto, PatientsEntity.class);
            entity.setFio(dtoToEntity.getFio());
            entity.setDateBirth(dtoToEntity.getDateBirth());
            entity.setPhone(dtoToEntity.getPhone());
            entity.setPassport(dtoToEntity.getPassport());
            entity.setAddress(dtoToEntity.getPassport());
            return "Объект обновлён!";
        }
        return "Объект не найден!";
    }
}
