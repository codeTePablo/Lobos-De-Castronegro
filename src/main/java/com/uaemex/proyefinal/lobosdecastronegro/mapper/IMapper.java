package com.uaemex.proyefinal.lobosdecastronegro.mapper;


public interface IMapper <I, O>{
    //Mapea lo que entre a la salida
   public  O map (I in);
}
