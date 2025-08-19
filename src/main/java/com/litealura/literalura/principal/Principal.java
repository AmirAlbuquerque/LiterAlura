package com.litealura.literalura.principal;

import com.litealura.literalura.model.DadosLivro;
import com.litealura.literalura.model.Livro;
import com.litealura.literalura.repository.LivroRepositorio;
import com.litealura.literalura.service.ConsumoAPI;
import com.litealura.literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final String urlBase = "https://gutendex.com/books/?search=";

    private Integer opcao = -1;
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();
    private LivroRepositorio livroRepositorio;

    //Variável Global
    private String livroBuscado;
    private List<Livro> livros = new ArrayList<>();

    public Principal(LivroRepositorio repositorio) {
        this.livroRepositorio = repositorio;
    }

    private String menu = """
            Escolha uma das opções abaixo:
            
            1- Buscar livro pelo título;
            2- Listar livros cadastrados;
            3- Listar autores cadastrados;
            4- Listar autores vivos de determinado ano;
            5- Listar livros em determinados idiomas.
            
            0- SAIR
            """;

    public void exibeMenu() {
        while (opcao != 0) {
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    buscarLivro();
                    break;
                case 0:
                    System.out.println("Finalizando...");
                    break;
            }
        }
    }

    private List<DadosLivro> obterLivro() {
        System.out.println("Informe o nome do livro buscado: ");
        livroBuscado = scanner.nextLine();
        String url = urlBase + livroBuscado.replace(" ", "+");
        var json = consumoAPI.obterDados(url);
        return converteDados.obterDados(json, DadosLivro.class);
    }

    private void buscarLivroPeloTitulo() {
        Livro livro = new Livro(obterLivro());
        if (livro == null){
            System.out.println("Nenhum livro encontrado");
            return;
        }
        livroRepositorio.save(livro);
        System.out.println("Livro cadastrado no banco de dados com sucesso!");
    }

    private void buscarLivro() {
        livros = livroRepositorio.findAll();
        livros.forEach(System.out::println);
    }
}
