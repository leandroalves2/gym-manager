package com.leogym.gym_manager.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoalDTO {

    private Long id;
    private String description;
    private Date targetDate;
    private boolean completed;

}
