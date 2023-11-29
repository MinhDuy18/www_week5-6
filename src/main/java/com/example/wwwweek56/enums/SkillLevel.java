package com.example.wwwweek56.enums;

public enum SkillLevel {
    PROFESSIONAL(1),
    MASTER(2),
    INTERMEDIATE(3),
    BEGINNER(4),
    ADVANCED(5);

    private final int level;

    SkillLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
