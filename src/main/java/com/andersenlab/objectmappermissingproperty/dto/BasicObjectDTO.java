package com.andersenlab.objectmappermissingproperty.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonTypeInfo(
        defaultImpl = BasicObjectDTO.class,
        use = Id.NAME,
        include = As.PROPERTY,
        property = "type"
)
@JsonSubTypes({@Type(
        value = ExtendedObjectDTO.class,
        name = "extended"
), @Type(
        value = AnotherExtendedObjectDTO.class,
        name = "another"
), @Type(
        value = BasicObjectDTO.class,
        name = "basic"
)
})
public abstract class BasicObjectDTO {
    private String name;
}
