package br.edu.iftm.tspi.projetocadastro.dto;

import lombok.Data;

@Data
public class CadastroDTO {
    private int id;
    private String email;
    private String name;
    private String adress;


    public CadastroDTO(){

    }


    public CadastroDTO(int id, String email, String name, String adress){
        this.id = id;
        this.email = email;
        this.name = name;
        this.adress = adress;
    }
}
