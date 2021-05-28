package br.edu.usj.ads.pw.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@Controller
public class LivrosController {

    @Autowired
    LivrosRepository livrosRepository; 
    
    @GetMapping(value="/")
    public ModelAndView getIndex() {

        List <Livros> lista = new ArrayList<>();

        lista = livrosRepository.findAll();
       
        ModelAndView modelAndView = new ModelAndView ("index");
        
        modelAndView.addObject("lista", lista);       
        
        return modelAndView;
    }

    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView ("detalhes");
        Livros livros = new Livros ();
        livros = livrosRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView ("detalhes");

        modelAndView.addObject("livros", livros);

         return modelAndView;

    }


    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        ModelAndView modelAndView = new ModelAndView ("cadastro");

        return modelAndView;
    }
    

    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(@RequestParam String titulo, @RequestParam String autor, @RequestParam String assunto, @RequestParam String resumo) {
        Livros livros = new Livros();

        livros.setTitulo(titulo);
        livros.setAutor(autor);
        livros.setAssunto(assunto);
        livros.setResumo(resumo);


        livrosRepository.save(livros);
 
        ModelAndView modelAndView = new ModelAndView ("detalhes");

        modelAndView.addObject("livros", livros);

         return modelAndView;
    }
    
    
}