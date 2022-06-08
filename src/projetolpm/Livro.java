package projetolpm;

public class Livro {

    private String nome;
    private String descricao;
    private String autor;
    private String editora;
    float preco;
    private int id;

    public Livro (String nome, String descricao, String autor, String editora, float preco, int id){
        
      this.nome = nome;
      this.descricao = descricao;
      this.autor = autor;
      this.editora = editora;
      this.preco = preco;
      
    }

    public void mostraDados()
    {
        System.out.println("\nDados do livro: \n");
        System.out.println("Nome: " + nome + "\nDescrição: " + descricao + "\nAutor: " + autor + "\nEditora: " + editora + "\nPreço: " + preco);
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
