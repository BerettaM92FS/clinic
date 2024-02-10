package com.example.clinic.rest;

import com.example.clinic.dto.MedicalCardDto;
import com.example.clinic.filter.MedicalCardFilter;
import com.example.clinic.service.MedicalCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "medical-card-controller", description = "Управление объектами \"medical_card\"")
@RestController
@RequestMapping("/medicalCard")
public class MedicalCardController {

    @Autowired
    private MedicalCardService service;

    public MedicalCardController(MedicalCardService service) {
        this.service = service;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Успешно",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content)
    })
    @Operation(summary = "Получить объект по id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable("id") UUID id
    ) {
        return ResponseEntity.ok(service.getById(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Успешно",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content)
    })
    @Operation(summary = "Получить список объектов")
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Успешно",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content)
    })
    @Operation(summary = "Получить список объектов с фильтром")
    @PostMapping("/filter")
    public ResponseEntity<?> findByFilter(
            @RequestBody MedicalCardFilter filter
    ) {
        return ResponseEntity.ok().body(service.findByFilter(filter));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Успешно",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content)
    })
    @Operation(summary = "Сохранение объекта в таблицу")
    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody MedicalCardDto dto
    ) {
        return ResponseEntity.ok().body(service.save(dto));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Успешно",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content)
    })
    @Operation(summary = "Удаление объекта")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") UUID id
    ) {
        return ResponseEntity.ok(service.delete(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Успешно",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Некорректный запрос",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Внутренняя ошибка сервера",
                    content = @Content)
    })
    @Operation(summary = "Обновление объекта в таблице")
    @PutMapping
    public ResponseEntity<?> update(
            @RequestBody MedicalCardDto dto
    ) {
        return ResponseEntity.ok().body(service.update(dto));
    }
}
