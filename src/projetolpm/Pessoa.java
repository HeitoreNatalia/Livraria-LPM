package projetolpm;

public abstract class Pessoa {

    protected String nome;
    protected String cpf;
    protected String tel;
    protected int idade;
    protected int id;
    
    public Pessoa(String nome, String cpf, String tel, int idade, int id)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.idade = idade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

