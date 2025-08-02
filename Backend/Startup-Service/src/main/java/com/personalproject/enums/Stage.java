package com.personalproject.enums;

public enum Stage {
    PRE_SEED, SEED, SERIES_A, SERIES_B, SERIES_C_BEYOND;

    public String getStageName(){
        return this.name();
    }
}
