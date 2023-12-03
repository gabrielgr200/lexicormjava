package com.web.lexicorm.lexicormWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.lexicorm.lexicormWeb.models.Administrador;
import com.web.lexicorm.lexicormWeb.repository.AdministradoresRepo;

@Controller
public class AdmController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/administradores")
    public String index(Model model) {
        List<Administrador> administradores = (List<Administrador>) repo.findAll();
        model.addAttribute("administradores", administradores);
        return "adm/index";
    }

    @GetMapping("/administradores/novo")
    public String novo() {
        return "adm/novo";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador) {
        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String buscar(@PathVariable Integer id, Model model) {
        Optional<Administrador> admin = repo.findById(id);
        try {
         model.addAttribute("administradores", admin.get());   
        } catch (Exception err) {
            return "redirect:/administradores";
        }
        return "adm/editar";
    }

    @PostMapping("/administradores/{id}/atualizar")
    public String atualizar(@PathVariable Integer id, Administrador administrador) {
        if (!repo.exist(id)) {
            return "redirect:/administradores";
        }

        repo.save(administrador);

        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/administradores";
    }
}
