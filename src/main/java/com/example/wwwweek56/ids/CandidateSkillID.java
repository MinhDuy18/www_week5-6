package com.example.wwwweek56.ids;

import com.example.wwwweek56.models.Candidate;
import com.example.wwwweek56.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Objects;

@Data @NoArgsConstructor @AllArgsConstructor
public class CandidateSkillID implements Serializable {
    private Candidate candidate;
    private Skill skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillID that = (CandidateSkillID) o;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }
}
