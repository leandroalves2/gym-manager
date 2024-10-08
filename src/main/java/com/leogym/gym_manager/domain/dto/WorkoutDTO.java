package com.leogym.gym_manager.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDTO {

    private Long id;
    private String name;
    private Date data;
    private List<Long> progressDTOList;

}
