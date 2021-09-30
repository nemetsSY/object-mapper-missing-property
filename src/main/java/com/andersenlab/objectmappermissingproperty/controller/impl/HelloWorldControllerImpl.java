package com.andersenlab.objectmappermissingproperty.controller.impl;

import com.andersenlab.objectmappermissingproperty.controller.HelloWorldController;
import com.andersenlab.objectmappermissingproperty.dto.AnotherExtendedObjectDTO;
import com.andersenlab.objectmappermissingproperty.dto.BasicObjectDTO;
import com.andersenlab.objectmappermissingproperty.dto.ExtendedObjectDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerImpl implements HelloWorldController {
    private static final List<BasicObjectDTO> LIST = List.of(new ExtendedObjectDTO("extendedObject"), new AnotherExtendedObjectDTO("anotherObject"));

    private final ObjectMapper objectMapper;

    public HelloWorldControllerImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<List<BasicObjectDTO>> getAll() {
        return new ResponseEntity<>(LIST, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<BasicObjectDTO>> getAll(Pageable pageable) {
        Page<BasicObjectDTO> result = new PageImpl<>(LIST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getAllString(Pageable pageable) throws JsonProcessingException {
        Page<BasicObjectDTO> result = new PageImpl<>(LIST);
        final String string;
        try {
            string = objectMapper.writerFor(
                            objectMapper.getTypeFactory().constructParametricType(Page.class, BasicObjectDTO.class))
                    .writeValueAsString(result);
            return new ResponseEntity<>(string, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
