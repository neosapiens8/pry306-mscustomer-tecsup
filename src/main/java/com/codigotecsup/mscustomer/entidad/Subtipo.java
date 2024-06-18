package com.codigotecsup.mscustomer.entidad;

import lombok.Data;

@Data
public class Subtipo {
    String id;

    enumerasubtipo valor;

    public enum enumerasubtipo{
        NORMAL,VIP,PYME
    }
}
