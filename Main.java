import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
            limparTela();
            System.out.println(menu);
            opcao = inputNumInteiro("Sua escolha: "); 

            switch (opcao) {
                case 0:                   
                    System.out.println("Volte sempre!");
                    break;
                case 1: //Adiciona
                    adicionar();
                    break;
                case 2: //Mostra todos 
                    pesquisarTodos();
                    break;
                case 3: //Pesquisa por título
                    pesquisarPorTitulo();
                    break;
                case 4:
                    removerLivro();
                    break;
                default:
                    System.out.println("Opção inválida! ");
                    break;
            }
        
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void limparTela() {
        System.out.println("\033[H\033[2J");
    }

    private static void travarAcao() {
        System.out.print("Clique qualquer tecla para prosseguir: ");
        scanner.nextLine();
    }

    private static int inputNumInteiro(String mensagem) {
        int valorNumerico = 0;
        Boolean inputNumerico = false;
        
        while(!inputNumerico) {
            System.out.print(mensagem);
            String inputStr = scanner.nextLine();
            try {
                valorNumerico = Integer.parseInt(inputStr);
                inputNumerico = true;
            } catch (Exception e) {
                System.out.println("Por favor, digite um número inteiro! "+ e.getMessage());
            }
        }
        return valorNumerico;
    }

    private static void adicionar() {
        limparTela();
        Livro novoLivro = new Livro();
        System.out.print("Informe o tíulo do livro: ");
        novoLivro.setTitulo(scanner.nextLine());

        System.out.print("Informe o autor do livro: ");
        novoLivro.setAutor(scanner.nextLine());

        novoLivro.setAnoPublicacao(inputNumInteiro("Informe o ano de publicação do livro: "));
        novoLivro.setPaginas(inputNumInteiro("Informe o número de páginas do livro: "));

        try {
            biblio.adicionarLivro(novoLivro);
           limparTela();
            System.out.println("Livro adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar livro: \n"+ e.getMessage());
        }

        travarAcao();        
    }

    private static void pesquisarTodos() {
        var livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo)); //Ordem alfabética 
        listarLivros(livros);
    }

    private static void pesquisarPorTitulo() {
        limparTela();
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        List<Livro> livrosEncontrados = new ArrayList<>();

        try {
             livrosEncontrados = biblio.pesquisarPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println("Erro ao procurar livro: " + e.getMessage());
        }
        listarLivros(livrosEncontrados);
    }

    private static void listarLivros(List<Livro> livros) {
        limparTela();
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
        travarAcao();
    }

    private static void removerLivro() {
        limparTela();
        pesquisarTodos();
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        
        Boolean removidoComSucesso = false;

        limparTela();
        try {
            removidoComSucesso = biblio.removerPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println("Não foi possível remover o livro "+ e.getMessage());
        }

        if (removidoComSucesso) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
        
        System.out.println("================");
        System.out.println("""
            [0] Remover outro livro 
            [1] Voltar para o menu
                """);
        int opcao = inputNumInteiro("Sua escolha: ");
        switch (opcao) {
            case 0:
                removerLivro();
                break;
            default:
                break;
        
        }
    }

}