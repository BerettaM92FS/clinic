package com.example.clinic.service.impl;

import com.example.clinic.domain.SpecialityEntity;
import com.example.clinic.dto.SpecialityDto;
import com.example.clinic.filter.SpecialityFilter;
import com.example.clinic.repository.SpecialityRepository;
import com.example.clinic.service.SpecialityService;
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
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SpecialityDto getById(UUID id) {
        Optional<SpecialityEntity> entity = repository.findById(id);
        return modelMapper.map(entity, SpecialityDto.class);
    }

    @Override
    public List<SpecialityDto> findAll() {
        List<SpecialityEntity> entities = repository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, SpecialityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SpecialityDto> findByFilter(SpecialityFilter filter) {
        List<SpecialityEntity> entities = repository.findAll(filter);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, SpecialityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String save(SpecialityDto dto) {
        SpecialityEntity entity = modelMapper.map(dto, SpecialityEntity.class);
        return String.valueOf(repository.save(entity).getId());
    }

    @Override
    public String delete(UUID id) {
        SpecialityEntity entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
        return "Объект удалён!";
    }

    @Override
    public String update(SpecialityDto dto) {
        Optional<SpecialityEntity> entityOptional = repository.findById(dto.getId());
        if (entityOptional.isPresent()) {
            SpecialityEntity entity = entityOptional.get();
            SpecialityEntity dtoToEntity = modelMapper.map(dto, SpecialityEntity.class);
            entity.setName(dtoToEntity.getName());
            return "Объект обновлён!";
        }
        return "Объект не найден!";
    }
}
