class Livro {
    String titulo;
    String autor;
    int paginas;
    boolean disponivel;

    void mostrar() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + paginas);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("------------");
    }

    void reservar() {
        if (disponivel) {
            disponivel = false;
            System.out.println(titulo + " reservado!");
        } else {
            System.out.println(titulo + " já está reservado.");
        }
    }

    void devolver() {
        disponivel = true;
        System.out.println(titulo + " devolvido!");
    }
}

class Livraria {
    Livro[] livros = new Livro[100];
    int cont = 0;

    void adicionar(Livro l) {
        if (cont < livros.length) {
            livros[cont] = l;
            cont++;
        } else {
            System.out.println("Não cabe mais livros.");
        }
    }

    void listar() {
        System.out.println("Todos os livros:");
        for (int i = 0; i < cont; i++) {
            livros[i].mostrar();
        }
    }

    void listarDisponiveis() {
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < cont; i++) {
            if (livros[i].disponivel) {
                livros[i].mostrar();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Livraria l = new Livraria();

        Livro livro1 = new Livro();
        livro1.titulo = "Java Fácil";
        livro1.autor = "Ana";
        livro1.paginas = 200;
        livro1.disponivel = true;

        Livro livro2 = new Livro();
        livro2.titulo = "Programação 101";
        livro2.autor = "Carlos";
        livro2.paginas = 150;
        livro2.disponivel = true;

        l.adicionar(livro1);
        l.adicionar(livro2);

        l.listar();

        livro1.reservar();
        livro1.reservar();

        l.listarDisponiveis();

        livro1.devolver();

        l.listarDisponiveis();
    }
}
