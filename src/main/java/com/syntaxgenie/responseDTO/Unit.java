package com.syntaxgenie.responseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Unit {

    private Integer unitId;
    private List<Chapter> chapters;
}