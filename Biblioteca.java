import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //Pesquisar sobre List e ArrayList
    private List<Livro> acervo = new ArrayList<>();

    public void adicionarLivro(Livro novoLivro) {
        acervo.add(novoLivro);
    }

    public Livro pesquisarPorTitulo(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public void removePorTitulo(String titulo) {
        Livro livroRemove = pesquisarPorTitulo(titulo);

        if (livroRemove != null) {
            acervo.remove(livroRemove);
        }
    }

    public List<Livro> pesquisarTodos() {
        return this.acervo;
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

}
