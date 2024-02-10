package com.example.clinic.service.impl;

import com.example.clinic.domain.MedicalCardEntity;
import com.example.clinic.dto.MedicalCardDto;
import com.example.clinic.filter.MedicalCardFilter;
import com.example.clinic.repository.MedicalCardRepository;
import com.example.clinic.service.MedicalCardService;
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
public class MedicalCardServiceImpl implements MedicalCardService {

    @Autowired
    private MedicalCardRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MedicalCardDto getById(UUID id) {
        Optional<MedicalCardEntity> entity = repository.findById(id);
        return modelMapper.map(entity, MedicalCardDto.class);
    }

    @Override
    public List<MedicalCardDto> findAll() {
        List<MedicalCardEntity> entities = repository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, MedicalCardDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalCardDto> findByFilter(MedicalCardFilter filter) {
        List<MedicalCardEntity> entities = repository.findAll(filter);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, MedicalCardDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String save(MedicalCardDto dto) {
        MedicalCardEntity entity = modelMapper.map(dto, MedicalCardEntity.class);
        return String.valueOf(repository.save(entity));
    }

    @Override
    public String delete(UUID id) {
        MedicalCardEntity entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
        return "Объект удалён!";
    }

    @Override
    public String update(MedicalCardDto dto) {
        Optional<MedicalCardEntity> entityOptional = repository.findById(dto.getId());
        if (entityOptional.isPresent()) {
            MedicalCardEntity entity = entityOptional.get();
            MedicalCardEntity dtoToEntity = modelMapper.map(dto, MedicalCardEntity.class);
            entity.setNumber(dtoToEntity.getNumber());
            entity.setPatient(dtoToEntity.getPatient());
            entity.setDoctor(dtoToEntity.getDoctor());
            entity.setDateAdd(dtoToEntity.getDateAdd());
            entity.setDiagnosis(dtoToEntity.getDiagnosis());
            return "Объект обновлён!";
        }
        return "Объект не найден!";
    }
}
