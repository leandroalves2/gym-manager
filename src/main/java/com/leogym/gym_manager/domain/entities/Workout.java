package com.leogym.gym_manager.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "workout_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Date data;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "progress_id", referencedColumnName = "id")
    private List<Progress> progressIdList;

}
