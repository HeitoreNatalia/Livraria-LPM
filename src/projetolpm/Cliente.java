package projetolpm;

public class Cliente extends Pessoa implements IPessoa{
    
    private String preferencias;
    private static int id;

    public Cliente(String nome, String cpf, String tel, int idade, int id, String preferencias) {
        super(nome, cpf, tel, idade, id);
        this.preferencias = preferencias;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public void mostraDados()
    {
        System.out.println("\nDados do cliente: \n");
        System.out.println("\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nTelefone: " + tel);
    }
}


