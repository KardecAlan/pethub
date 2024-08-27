package com.kardec.pethub.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Especie {

    AVE(0),
    BOVINO(1),
    BUBALINO(2),
    CANINO(3),
    CAPRINO(4),
    COELHO(5),
    EQUINO(6),
    FELINO(7),
    OVINO(8),
    PEIXE(9),
    SUINO(10);

    private static final Map<Integer, Especie> byId = new HashMap<Integer, Especie>();
    static {
        for (Especie e : Especie.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

    private final Integer id;

    Especie(Integer id) {
        this.id = id;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }

}
