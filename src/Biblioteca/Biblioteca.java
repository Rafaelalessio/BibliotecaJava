package Biblioteca;
//importando de outras classes
import Livros.Livro;
import Usuario.Usuario;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Biblioteca {
    //criando variavel do tipo lista de livros e usuarios
    private ArrayList<Livro> livrosDisponiveis;
    private ArrayList<Usuario> usuariosCadastadros;
    Scanner scanner = new Scanner(System.in);

    //construindo a classe de biblioteca com os atributos a cima
    public Biblioteca(){
        this.livrosDisponiveis = new ArrayList<>();
        this.usuariosCadastadros = new ArrayList<>();

        livrosDisponiveis.add(new Livro("Cem Anos de Solidão", " Gabriel García Márquez", "1967"));
        livrosDisponiveis.add(new Livro("Dom Quixote", "Miguel de Cervantes", "1605"));
        livrosDisponiveis.add(new Livro("O Grande Gatsby", "F. Scott Fitzgerald", "1925"));
        livrosDisponiveis.add(new Livro("Matar um Rouxinol", " Harper Lee", "1960"));
        livrosDisponiveis.add(new Livro("O Apanhador no Campo de Centeio", " J.D. Salinger", "1951"));
        livrosDisponiveis.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski ", "1866"));
        livrosDisponiveis.add(new Livro("A Revolução dos Bichos", "George Orwell", "1945"));
        livrosDisponiveis.add(new Livro("O Senhor dos Anéis: A Sociedade do Anel", " J.R.R. Tolkien", "1954"));
        livrosDisponiveis.add(new Livro("O Sol é para Todos", "  Harper Lee ", "1960"));

        usuariosCadastadros.add(new Usuario("Lucas","lucas@gmail",34423782));
        usuariosCadastadros.add(new Usuario("Beatriz","bia@gmail",34423951));
        usuariosCadastadros.add(new Usuario("joão","joao@gmail",34423500));
    }
    //metodo de adicionar um livro
    public void adicionarLivro (Livro livro){
        livrosDisponiveis.add(livro);
        System.out.println("Livro cadastrado com exito");
        System.out.println("Titulo: " + livro.titulo );
        System.out.println("Autor: " + livro.autor );
        System.out.println("Ano de publicação: " + livro.anoPublicacao );
    }
    //metodo de adicionar um usuario
    public void adicionarUsuario (Usuario usuario){
        usuariosCadastadros.add(usuario);
        System.out.println("Usuario cadastrado com exito");
        System.out.println("Nome: " + usuario.nome );
        System.out.println("E-mail: " + usuario.email );
        System.out.println("Telefone: " + usuario.telefone );
    }
    //metodo de remover um livro
    public void removerLivro (){
        if (consultarLivro()) {
            System.out.println("Digite a numeração do livro que deseja remover: ");
            int opcao = scanner.nextInt();
            int indexRemover = opcao - 1;
            livrosDisponiveis.remove(indexRemover);
            System.out.println("Livro removido com sucesso");
        }
    }
    //metodo de remover um usuario
    public void removerUsuario (){
        if (consultarUsuario()) {
            System.out.println("Digite a numeração do usuário que deseja remover: ");
            int opcao = scanner.nextInt();
            int indexRemover = opcao - 1;
            usuariosCadastadros.remove(indexRemover);
            System.out.println("Usuário removido com sucesso");
        }
    }
    public boolean consultarLivro () {
        if (livrosDisponiveis.size() < 1) {
            System.out.println("Não existe nenhum livro cadastrado.");
            return false;
        } else {
            System.out.println("Lista de livros cadastrados: ");
            for (int i = 0; i < livrosDisponiveis.size(); i++) {
                Livro livro = livrosDisponiveis.get(i);
                System.out.println((i + 1) + " - " + livro.titulo + (livro.emprestado ? " (Emprestado)" : ""));
            }
            return true;
        }
    }
    public boolean consultarUsuario () {
        if (usuariosCadastadros.size() < 1) {
            System.out.println("Não existe nenhum usuario cadastrado. ");
            return false;
        } else {
            System.out.println("Lista de usuarios cadastrados: ");
            for (int i = 0; i < usuariosCadastadros.size(); i++) {
                Usuario usuario = usuariosCadastadros.get(i);
                System.out.println((i + 1) + " - " + usuario.nome);
            }
            return true;
        }
    }
    public void emprestarLivro() {
        int opcaoLivro = 0;
        int opcaoUsuario = 0;
        int indexLivro = -1;
        int indexUsuario = -1;

        if (consultarLivro()) {
            System.out.println("Digite o numero do livro que deseja emprestar: ");
            opcaoLivro = scanner.nextInt();
            indexLivro = opcaoLivro -1;
        }

        Livro livro = livrosDisponiveis.get(indexLivro);

        if (livro.emprestado) {
            System.out.println("Livro indisponivel.");
            return;
        }

        if (consultarUsuario()) {
            System.out.println("Digite o numero do usuario que deseja emprestar o livro: ");
            opcaoUsuario = scanner.nextInt();
            indexUsuario = opcaoUsuario - 1;
        }

        Usuario usuario = usuariosCadastadros.get(indexUsuario);

        if (livro != null && usuario != null) {
            livro.emprestar(usuario);
            System.out.println("Livro emprestado com sucesso para " + usuario.nome);
        } else {
            System.out.println("É necessario digitar um livro e um usuario para poder emprestar.");
        }
    }

    public void devolverLivro() {
        if (consultarLivro()) {
            System.out.println("Digite o numero do livro que deseja emprestar: ");
            int opcaoLivro = scanner.nextInt();
            int indexLivro = opcaoLivro - 1;

            Livro livro = livrosDisponiveis.get(indexLivro);

            if (livro != null) {
                livro.devolver();
                System.out.println("LIvro devolvido com sucesso.");
            }
        }
    }
}
