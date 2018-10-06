package com.lovato.weatherspotifymicroservice.domain.music;

public enum Category {
    PARTY("party"),
    POP("pop"),
    ROCK("rock"),
    CLASSICAL("classical");

    private final String type;

    Category(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }
}
