package com.codigotecsup.mscustomer.entidad;

import lombok.Data;

@Data
public class Tipocustomer {
    String id;
    enumeratipocustomer valor;
    Subtipo subtipo1;
    public enum enumeratipocustomer{
        EMPRESARIAL,PERSONAL
    }
}