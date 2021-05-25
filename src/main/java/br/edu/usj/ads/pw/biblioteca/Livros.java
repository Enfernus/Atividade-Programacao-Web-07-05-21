package br.edu.usj.ads.pw.biblioteca;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Livros {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String titulo;
    String autor; 
    String assunto;
    String resumo;

    
}