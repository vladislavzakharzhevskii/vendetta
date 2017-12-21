package com.vendettasoft.vendetta.models.hibernate;

import java.io.Serializable;

public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
