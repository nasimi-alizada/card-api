package com.example.cardapi.model.criteria;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.USE_DEFAULTS;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageCriteria {
    @JsonInclude(USE_DEFAULTS)
    private Integer page = 1;
    @JsonInclude(USE_DEFAULTS)
    private Integer count = 10;
}
