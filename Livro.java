public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int paginas;
    
    public Livro(String titulo, String autor, int anoPublicacao, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.paginas = paginas;
    }

    public Livro() {
        
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    

}