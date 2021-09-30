package com.andersenlab.objectmappermissingproperty.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class AnotherExtendedObjectDTO extends BasicObjectDTO {
    @Builder
    public AnotherExtendedObjectDTO(String name) {
        super(name);
    }
}
