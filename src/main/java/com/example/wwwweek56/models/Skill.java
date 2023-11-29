package com.example.wwwweek56.models;

import com.example.wwwweek56.enums.SkillType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "skill")
@Data @NoArgsConstructor @AllArgsConstructor
public class Skill {
    @Id
    private long id;
    private String skillName;
    private String skillDescription;

    @Enumerated
    private SkillType skillType;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;
}
