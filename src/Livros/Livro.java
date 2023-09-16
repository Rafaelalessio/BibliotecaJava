package Livros;

import Usuario.Usuario;

import java.util.Date;

public class Livro  {
    //declarando os atributos
    public String titulo ;
    public String autor ;
    public String anoPublicacao;
    public boolean emprestado;
    private Usuario locador;
    private Date dataEmprestimo;
    //criando um construtor da classe livro com os atributos a cima
    public Livro(String titulo, String autor, String anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = false;
        this.locador = null;
        this.dataEmprestimo = null;
    }

    public boolean emprestar(Usuario usuario) {
        if (!emprestado) {
            emprestado = true;
            locador = usuario;
            dataEmprestimo = new Date();
            return true;
        } else {
            return false;
        }
    }

    public boolean devolver() {
        if (emprestado) {
            emprestado = false;
            locador = null;
            dataEmprestimo = null;
            return true;
        } else {
            return false;
        }
    }
}
