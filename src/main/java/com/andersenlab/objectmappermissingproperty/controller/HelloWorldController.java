package com.andersenlab.objectmappermissingproperty.controller;

import com.andersenlab.objectmappermissingproperty.dto.BasicObjectDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("list")
public interface HelloWorldController {

    @GetMapping
    ResponseEntity<List<BasicObjectDTO>> getAll();

    @GetMapping(value = "/pageable")
    ResponseEntity<Page<BasicObjectDTO>> getAll(Pageable pageable);

    @GetMapping(value = "/pageable/string", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAllString(Pageable pageable) throws JsonProcessingException;
}
