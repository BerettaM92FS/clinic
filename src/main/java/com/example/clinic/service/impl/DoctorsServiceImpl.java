package com.example.clinic.service.impl;

import com.example.clinic.domain.DoctorsEntity;
import com.example.clinic.dto.DoctorsDto;
import com.example.clinic.filter.DoctorsFilter;
import com.example.clinic.repository.DoctorsRepository;
import com.example.clinic.service.DoctorsService;
import jakarta.persistence.EntityManagerFactory;
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
public class DoctorsServiceImpl implements DoctorsService {

    @Autowired
    private DoctorsRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DoctorsDto getById(UUID id) {
        DoctorsEntity entity = repository.findById(id).orElseThrow();
        return modelMapper.map(entity, DoctorsDto.class);
    }

    @Override
    public List<DoctorsDto> findAll() {
        List<DoctorsEntity> entities = repository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, DoctorsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorsDto> findByFilter(DoctorsFilter filter) {
        List<DoctorsEntity> entities = repository.findAll(filter);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, DoctorsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String save(DoctorsDto dto) {
        DoctorsEntity entity = modelMapper.map(dto, DoctorsEntity.class);
        return String.valueOf(repository.save(entity).getId());
    }

    @Override
    public String delete(UUID id) {
        DoctorsEntity entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
        return "Объект удалён!";
    }

    @Override
    public String update(DoctorsDto dto) {
        Optional<DoctorsEntity> entityOptional = repository.findById(dto.getId());
        if (entityOptional.isPresent()) {
            DoctorsEntity entity = entityOptional.get();
            DoctorsEntity dtoToEntity = modelMapper.map(dto, DoctorsEntity.class);
            entity.setFio(dtoToEntity.getFio());
            entity.setSpec(dtoToEntity.getSpec());
            entity.setHiringDate(dtoToEntity.getHiringDate());
            entity.setPhone(dtoToEntity.getPhone());
            entity.setAddress(dtoToEntity.getAddress());
            repository.save(entity);
            return "Объект обновлён!";
        }
        return "Объект не найден!";
    }

    @Override
    public DoctorsEntity getByIdEntity(UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
