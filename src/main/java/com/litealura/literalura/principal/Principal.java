package com.litealura.literalura.principal;

import java.util.Scanner;

public class Principal {

    private Integer opcao = -1;
    private Scanner scanner = new Scanner(System.in);

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
            var escolha = scanner.nextInt();
            scanner.nextLine();
        }
    };
}
