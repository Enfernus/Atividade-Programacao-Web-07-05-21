package br.edu.usj.ads.pw.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class LivrosController {

    @Autowired
    LivrosRepository livrosRepository; 
    
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