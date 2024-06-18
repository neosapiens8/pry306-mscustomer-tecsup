package com.codigotecsup.mscustomer.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Builder
@Document("customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;

    private Tipocustomer tipocustomer1;
    private enumeratipodocumento enutipodoc1;

    @NotEmpty
    private String documentnumero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechanac;

    @NotNull
    private String genero;
    public enum enumeratipodocumento{
        DNI,PASAPORTE
    }
}