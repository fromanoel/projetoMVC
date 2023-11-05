package br.edu.iftm.tspi.projetocadastro.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iftm.tspi.projetocadastro.dao.CadastroDao;
import br.edu.iftm.tspi.projetocadastro.dto.CadastroDTO;

@Controller
public class CadastroResources {

    @Autowired
    private CadastroDao dao;

    @PostMapping("/cadastroPost")
    public String doPost(CadastroDTO dto, Model model) {
        dao.postCadastroDTOs(dto);
        return doGet(model);
    }

    @RequestMapping("/cadastroGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros", dao.getCadastroDTOs());
        return "lista";
    }

    @RequestMapping("/cadastroSearch")

    public String getCadastroSearch(@RequestParam(value = "id", required = true) int id, Model model) {

        model.addAttribute("cadastros", dao.getCadastroDTOs(id));

        return "lista";

    }

    @GetMapping(value = "/deletarUsuario/{id}")
    public String deletarUsuario(@PathVariable("id") int id, Model model) {
        dao.deleteCadastroDTOs(id);
        return doGet(model);
    }
}

   
