package com.kardec.pethub.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Sexo {

    MACHO(0),
    FEMEA(1);

    private static final Map<Integer, Sexo> byId = new HashMap<Integer, Sexo>();
    static {
        for (Sexo e : Sexo.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }

    private final Integer id;

    Sexo(Integer id) {
        this.id = id;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }


}
