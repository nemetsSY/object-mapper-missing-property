package com.andersenlab.objectmappermissingproperty.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ExtendedObjectDTO extends BasicObjectDTO {
    @Builder
    public ExtendedObjectDTO(String name) {
        super(name);
    }
}
