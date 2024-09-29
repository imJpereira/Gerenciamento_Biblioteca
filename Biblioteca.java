import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //Pesquisar sobre List e ArrayList
    private List<Livro> acervo = new ArrayList<>();

    public void adicionarLivro(Livro novoLivro) throws Exception {
        if (novoLivro.getTitulo() == null || novoLivro.getTitulo().isEmpty()) {
            throw new Exception("Não é permitido cadastra livro sem título");
        } 

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())) {
                throw new Exception("Já existe um livro com esse nome cadastrado");
            }
        }
        if (novoLivro.getTitulo() == null || novoLivro.getAutor().isEmpty()){
            throw new Exception("Não é permitido cadastrar livro sem autor!");
        }
        int anoAtual = LocalDate.now().getYear();
        if (novoLivro.getAnoPublicacao() < 1400 || novoLivro.getAnoPublicacao() > anoAtual){
            throw new Exception("Ano de publicação inválido. Deve estar entre 1400 e " + anoAtual + ".");
        }
        if  (novoLivro.getPaginas() <= 0){ 
            throw new Exception("Número de páginas inválido. Deve ser maior que zero.");
        
        }
        if (novoLivro.getAutor().toLowerCase().contains("autor")) {
            throw new Exception("Não é permitido cadastrar o autor do livro como 'autor'!");
        }
        
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())) {
                throw new Exception("Já existe um livro com esse nome cadastrado.");
            }
        }
        
        acervo.add(novoLivro);
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }

    public Boolean removerPorTitulo(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                acervo.remove(livro);
                return true;
            }
        }
        return false;
    }

    public List<Livro> pesquisarTodos() {
        return this.acervo;
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

}
