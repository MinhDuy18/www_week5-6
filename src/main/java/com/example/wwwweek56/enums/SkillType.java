package com.example.wwwweek56.enums;

public enum SkillType {
    TECHNICAL_SKILL(3),
    SOFT_SKILL(1),
    UNSPECIFIC(2);

    private final int typeCode;

    SkillType(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }
}
