import java.util.Scanner;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String menu = """
            SISTEMA DE GERENCIAMENTO BIBLIOTECA
            Escolha uma das opções:
            1- Adicionar novo livro;
            2- Listar todos os livros;
            3- Pesquisar livro;
            4- Remover livro;
            0- Sair;
            """;

        int opcao; 
            
        do {
            System.out.println(menu);
            System.out.print("Sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 0:                   
                    System.out.println("Volte sempre!");
                    break;
                case 1: //Adiciona
                    adicionar();
                    break;
                case 2: //Mostra todos 
                    listar();
                    break;
                case 3:
                    //biblio.pesquisarPorTitulo(menu);
                    break;
                case 4:
                    //biblio.removePorTitulo(menu);
                    break;
                default:
                    break;
            }
        
        } while (opcao != 0);
        
        scanner.close();
    }


    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.print("Informe o tíulo do livro: ");
        novoLivro.setTitulo(scanner.nextLine());

        System.out.print("Informe o autor do livro: ");
        novoLivro.setAutor(scanner.nextLine());

        System.out.print("Informe o ano de publicação do livro: ");
        novoLivro.setAnoPublicacao(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Informe o número de páginas do livro: ");
        novoLivro.setPaginas(scanner.nextInt());
        scanner.nextLine();

        biblio.adicionarLivro(novoLivro);
    }

    private static void listar() {
        var livros = biblio.pesquisarTodos();

        System.out.println("Lista de livros: ");
        for (Livro livro : livros) {
            System.out.println("====================================");
            System.out.printf(""" 
                    Título: %s
                    Autor: %s
                    Ano de publicação: %d
                    Número de páginas: %d
                    """, livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao(), livro.getPaginas());
        }
        System.out.println("====================================");
    }

}