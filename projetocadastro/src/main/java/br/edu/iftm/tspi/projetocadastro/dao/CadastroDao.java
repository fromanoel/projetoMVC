package br.edu.iftm.tspi.projetocadastro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;
import br.edu.iftm.tspi.projetocadastro.dto.CadastroDTO;

@Component

public class CadastroDao {

    @Autowired

    JdbcTemplate db;

    public List<CadastroDTO> getCadastroDTOs() {

        String sql = "select id, email, name, adress from tb_CadastroDTO";

        return db.query(sql, (res, rowNum) -> {

            return new CadastroDTO(

                    res.getInt("id"),

                    res.getString("email"),

                    res.getString("name"),

                    res.getString("adress")

            );

        });

    }

    public List<CadastroDTO> getCadastroDTOs(int id) {

        String sql = "select id, email, name, adress from tb_CadastroDTO where id=?";

        return db.query(sql,

                new BeanPropertyRowMapper<>(CadastroDTO.class),

                new Object[] { id });

    }



    public void postCadastroDTOs(CadastroDTO cadastroDTO) {

        String sql = "INSERT INTO tb_CadastroDTO (id, email, name, adress) VALUES (?, ?, ?, ?)";

        db.update(sql, cadastroDTO.getId(), cadastroDTO.getEmail(), cadastroDTO.getName(), cadastroDTO.getAdress());
    }

    public void deleteCadastroDTOs(int id){
        String sql = "DELETE FROM tb_CadastroDTO where id = ?";

        db.update(sql, id);
    }

}
