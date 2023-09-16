import Biblioteca.Biblioteca;
import Livros.Livro;
import Usuario.Usuario;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int resposta = 1;
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        //cadastrando um novo  usuário
        System.out.println("Olá, me chamo Rafael, o que gostaria de fazer em nossa biblioteca?\n");
        do {
            System.out.println("Selecione uma das opções abaixo:\n" +
                    "1 = Consultar livros cadastrados \n" +"2 = Consultar usuarios cadastrados \n" +
                    "3 = Emprestar livro \n" + "4 = Devolver livro \n" +
                    "5 = Cadastrar um novo livro\n" + "6 = Cadastrar um novo usuario\n" +
                    "7 = Remover usuario\n" + "8 = Remover livro");
            int menu = scanner.nextInt();

            if (menu == 1) {
                biblioteca.consultarLivro();
            }
            if (menu == 2) {
                biblioteca.consultarUsuario();
            }
            if (menu == 3) {
               biblioteca.emprestarLivro();
            }
            if (menu == 4) {
               biblioteca.devolverLivro();
            }
            if (menu == 5) {
                System.out.println("Otimo vamos prosseguir! ");
                scanner.nextLine();
                System.out.println("Digite o nome do livro: ");
                String titulo = scanner.nextLine();
                System.out.println("Digite o nome do autor: ");
                String autor = scanner.nextLine();
                System.out.println("Digite o ano de publicação do livro: ");
                String anoPublicaco = scanner.nextLine();
                biblioteca.adicionarLivro(new Livro(titulo, autor, anoPublicaco));
            }
            if (menu == 6) {
                System.out.println("Otimo, vamos prosseguir! ");
                scanner.nextLine();
                System.out.println("Digite seu nome: ");
                String nome = scanner.nextLine();
                System.out.println("Digite seu Email: ");
                String email = scanner.nextLine();
                System.out.println("Digite seu numero de telefone: ");
                int telefone = scanner.nextInt();
                biblioteca.adicionarUsuario(new Usuario(nome, email, telefone));
            }
            if (menu == 7) {
                biblioteca.removerUsuario();
            }
            if ( menu == 8) {
                biblioteca.removerLivro();
            }
            System.out.println("Deseja encerrar o programa? 1 = continuar 2 = encerrar ");
            resposta = scanner.nextInt();
        } while (resposta == 1);
        System.out.println("Encerrando o programa!");

    }
}