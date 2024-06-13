package com.uaemex.proyefinal.lobosdecastronegro.service.dto;

import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class PartidaDTO {
    @ElementCollection
    private List<Integer> jugadoresIds;
}
