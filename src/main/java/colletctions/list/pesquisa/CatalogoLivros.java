package main.java.colletctions.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> listaLivro;

    public CatalogoLivros() {
        this.listaLivro = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        listaLivro.add(new Livro(titulo, autor, anoPublicacao));        
    }

    // public, retorno list de livros
    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livroPorAutor = new ArrayList<>();

        if(!listaLivro.isEmpty()) {
            for(Livro l : listaLivro) {
                if(l.getAutor().equalsIgnoreCase(autor)) {
                    livroPorAutor.add(l);
                }
            }
        }
        return livroPorAutor;
    }
    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livroPorIntervaloAno = new ArrayList<>();

        if(!listaLivro.isEmpty()) {
            for(Livro l : listaLivro) {
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livroPorIntervaloAno.add(l);
                }
            }
        }
        return livroPorIntervaloAno;
    }
    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;

        if(!listaLivro.isEmpty()) {
            for(Livro l: listaLivro) {
                if(l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = l;
                    break;
                }
            }
        }else {
            System.out.println("Lista vazia");
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        // Criando uma instância do catálogo de livros
        CatalogoLivros catalogoLivros = new CatalogoLivros();
    
        // Adicionando livros ao catálogo
        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);
    
        // Exibindo livros pelo mesmo autor
        System.out.println(catalogoLivros.pesquisarPorAutor("Robert C. Martin"));
    
        // Exibindo livros pelo mesmo autor (caso em que não há livros de um autor específico)
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));
    
        // Exibindo livros dentro de um intervalo de anos
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022));
    
        // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2025, 2030));
    
        // Exibindo livros por título
        System.out.println(catalogoLivros.pesquisarPorTitulo("Java Guia do Programador"));
    
        // Exibindo livros por título (caso em que não há livros com o título especificado)
        System.out.println(catalogoLivros.pesquisarPorTitulo("Título Inexistente"));
      }
}
