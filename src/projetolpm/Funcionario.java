package projetolpm;

public class Funcionario extends Pessoa implements IPessoa {
    private double salario;
    private static int id;
    
    public Funcionario (String nome, String cpf, String tel, int idade, int id, double salario) {
        super(nome, cpf, tel, idade, id);
        this.salario = salario;
    }
    
    @Override
    public void mostraDados()
    {
        System.out.println("\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nTelefone: " + tel + "\nSalário: " + salario + "\nId: " + id);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
