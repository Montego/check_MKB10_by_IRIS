package ru.vitasoft.pilipenko.MIAC_Tables.model.comparison;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PagingParams {
    private Integer pageSize;
    private Integer page;
}
