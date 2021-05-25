package br.edu.usj.ads.pw.biblioteca;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LivrosRepository extends CrudRepository <Livros, Long>{
     List<Livros> findAll(); 

}