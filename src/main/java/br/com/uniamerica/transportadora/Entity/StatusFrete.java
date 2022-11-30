package br.com.uniamerica.transportadora.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum StatusFrete {

    CARGA,
    EM_TRANSPORTE,
    INTERROMPIDO,
    DESCARGA,
    FATURADO,
    CANCELADO;

}
