package projetolpm;

import java.util.ArrayList;
import java.util.Scanner;


public class Projetolpm {

    private static ArrayList<Cliente> cadCli = new ArrayList();
    private static ArrayList<Funcionario> cadFun = new ArrayList();
    private static ArrayList<Livro> cadLiv = new ArrayList();
    static Scanner input = new Scanner(System.in);
    protected static int id;

    public static void initId() {
        id = 0;
    }

    public void cadastrarC() {
        String nome, cpf, tel, preferencias;
        int idade;

        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("CPF: ");
        cpf = input.nextLine();

        System.out.println("Telefone: ");
        tel = input.nextLine();

        System.out.println("Idade: ");
        idade = input.nextInt();

        System.out.println("Preferencias: ");
        preferencias = input.nextLine();

        id++;

        Cliente c1 = new Cliente(nome, cpf, tel, idade, id, preferencias);
        cadCli.add(c1);

    }

    public void cadastrarF() {
        String nome, cpf, tel;
        int idade;
        float salario;

        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("CPF: ");
        cpf = input.nextLine();

        System.out.println("Telefone: ");
        tel = input.nextLine();

        System.out.println("Idade: ");
        idade = input.nextInt();

        System.out.println("Salário: ");
        salario = input.nextFloat();

        id++;

        Funcionario f1 = new Funcionario(nome, cpf, tel, idade, id, salario);
        cadFun.add(f1);

    }

    public void cadastrarL() {
        String nome, descricao, autor, editora;
        float preco;

        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("Descrição: ");
        descricao = input.nextLine();

        System.out.println("Autor: ");
        autor = input.nextLine();

        System.out.println("Editora: ");
        editora = input.nextLine();

        System.out.println("Preço: ");
        preco = input.nextFloat();

        id++;

        Livro l1 = new Livro(nome, descricao, autor, editora, preco, id);
        cadLiv.add(l1);

    }

    public static void excluirC() {

        System.out.println("ID do cliente para exclusão: ");
        id = input.nextInt();

        for (Cliente c : cadCli) {
            if (c.getId() == id) {
                cadCli.remove(c);
                break;
            }
        }

    }

    public static void excluirF() {

        System.out.println("ID do funcionário para exclusão: ");
        id = input.nextInt();

        for (Funcionario f : cadFun) {
            if (f.getId() == id) {
                cadFun.remove(f);
                break;
            }
        }

    }

    public static void excluirL() {

        System.out.println("ID do livro para exclusão: ");
        id = input.nextInt();

        for (Livro l : cadLiv) {
            if (l.getId() == id) {
                cadLiv.remove(l);
                break;
            }
        }
    }

    public static void buscarC() {
        System.out.println("Digite o começo do nome do cliente para a pesquisa: ");
        String busca = input.nextLine();

        for (Cliente c : cadCli) {
            if (c.nome.compareTo(busca) == 0) {
                c.mostraDados();
            }
        }
    }

    public static void buscarF() {
        System.out.println("Digite o começo do nome do funcionário para a pesquisa: ");
        String busca = input.nextLine();

        for (Funcionario f : cadFun) {
            if (f.nome.compareTo(busca) == 0) {
                f.mostraDados();
            }
        }
    }

    public static void buscaP() {
        System.out.println("Deseja buscar por: \n[1] Descrição\n[2] Nome \n[3] Id");
        int resp = input.nextInt();
        switch (resp) {
            case 1:
                System.out.println("Digite parte da descrição do produto: ");
                String buscaD = input.nextLine();
                for (Livro l : cadLiv) {
                    if (l.getDescricao().compareTo(buscaD) == 0) {
                        l.mostradados();
                    }
                }
                break;
            case 2:
                System.out.println("Digite parte do nome do Livro: ");
                String buscaN = input.nextLine();
                for (Livro l : cadLiv) {
                    if (l.getNome().compareTo(buscaN) == 0) {
                        l.mostradados();
                    }
                }
                break;
            case 3:
                System.out.println("Digite parte do nome do Livro: ");
                int buscaI = input.nextInt();
                for (Livro l : cadLiv) {
                    if (l.getId() == buscaI) {
                        l.mostradados();
                    }
                }
                break;
        }
    }

    public static void velhoC(){
        int velho = 0;
        for(Cliente c: cadCli)
        {
            if(c.idade > velho){
                velho = c.idade;
            }
        }

        for (Cliente c: cadCli){
            if(c.idade == velho){
                c.mostraDados();
            }
        }
    }

    public static void novoc(){
        int novo = 9999;
        for(Cliente c: cadCli)
        {
            if(c.idade < novo){
                novo = c.idade;
            }
        }

        for (Cliente c: cadCli){
            if(c.idade == novo){
                c.mostraDados();
            }
        }
    }

    public static int qtdVelhos(){
        int qtdvelhos = 0;
        for(Cliente c: cadCli){
            if(c.idade > 60){
                qtdvelhos++;
            }
        }
        return qtdvelhos;
    }

    public static int qtdNovos(){
        int qtdnovos = 0;
        for(Cliente c: cadCli){
            if(c.idade < 18){
                qtdnovos++;
            }
        }
        return qtdnovos;
    }

    public static float idademedia(){
        int cont = 0;
        int numeros =0;

        for(Cliente c: cadCli){
            numeros += c.idade;
            cont++;
        }
        return numeros / cont;
    }

    public static float maiscaro(){
        float maiscaro = 0;
        for (Livro l: cadLiv){
            if (l.getPreco() > maiscaro)
            {
                maiscaro = l.getPreco();
            }
        }
        return maiscaro;
    }

    public static float maisbarato(){
        float maisbarato = 99999;
        for (Livro l: cadLiv){
            if (l.getPreco() < maisbarato)
            {
                maisbarato = l.getPreco();
            }
        }
        return maisbarato;
    }

    public static float mediaprecos(){
        int cont = 0;
        int numeros =0;

        for(Livro l: cadLiv){
            numeros += l.preco;
            cont++;
        }
        return numeros / cont;
    }

    public static int livroscaros(){
        int qtdcaros = 0;
        float precomedio = mediaprecos();
        for(Livro l: cadLiv){
            if (l.preco > precomedio){
                qtdcaros++;
            }
        }
        return qtdcaros;
    }

    public static void main(String[] args) {
        initId();
    }

}
