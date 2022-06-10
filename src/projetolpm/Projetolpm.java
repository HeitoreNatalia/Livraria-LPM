package projetolpm;

import java.util.ArrayList;
import java.util.Scanner;


public class Projetolpm {

    private static ArrayList<Cliente> cadCli = new ArrayList();
    private static ArrayList<Funcionario> cadFun = new ArrayList();
    private static ArrayList<Livro> cadLiv = new ArrayList();
    static Scanner input = new Scanner(System.in);


    public static void limpaBuffer(){
        String lixo = input.nextLine();
    }

    public static void cadastrarC() {
        String nome, cpf, tel, preferencias;
        int idade, id;

        limpaBuffer();
        
        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("CPF: ");
        cpf = input.nextLine();

        System.out.println("Telefone: ");
        tel = input.nextLine();

        
        try{
            System.out.println("Idade: ");
            idade = input.nextInt();
        }
        catch(Exception e){
            System.out.println("Erro!! Idade inserida inválida. Sua idade foi definida para 0");
            idade = 0;
        }
        
        
        if(idade < 0){
            throw new ArithmeticException("Erro! Valor invalido.");
        }
        

        limpaBuffer();
        System.out.println("Preferencias: ");
        preferencias = input.nextLine();

        System.out.println("Id: ");
        id = input.nextInt();

        Cliente c1 = new Cliente(nome, cpf, tel, idade, id, preferencias);
        cadCli.add(c1);

    }

    public static void cadastrarF() {
        String nome, cpf, tel;
        int idade, id;
        float salario;

        limpaBuffer();
        
        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("CPF: ");
        cpf = input.nextLine();

        System.out.println("Telefone: ");
        tel = input.nextLine();

        try{
            System.out.println("Idade: ");
            idade = input.nextInt();
        }
        catch(Exception e){
            throw new ArithmeticException("Erro! Valor invalido.");
        }
        
        try{
            System.out.println("Salário: ");
            salario = input.nextFloat();
        }
        catch(Exception e){
            throw new RuntimeException("Erro!! Salário inserido inválido.");
        }

        System.out.println("Id: ");
        id = input.nextInt();

        Funcionario f1 = new Funcionario(nome, cpf, tel, idade, id, salario);
        cadFun.add(f1);

    }

    public static void cadastrarL() {
        String nome, descricao, autor, editora;
        float preco;
        int id;

        limpaBuffer();
        
        System.out.println("Nome: ");
        nome = input.nextLine();

        System.out.println("Descrição: ");
        descricao = input.nextLine();

        System.out.println("Autor: ");
        autor = input.nextLine();

        System.out.println("Editora: ");
        editora = input.nextLine();

        try{
            System.out.println("Preço: ");
            preco = input.nextFloat();
        }
        catch(Exception e){
            System.out.println("Erro!! preço inserido inválido. O valor foi definido para 0");
            preco = 0;
        }

        System.out.println("Id: ");
        id = input.nextInt();

        Livro l1 = new Livro(nome, descricao, autor, editora, preco, id);
        cadLiv.add(l1);

    }

    public static void excluirC() {
        System.out.println("ID do cliente para exclusão: ");
        int idBusca = input.nextInt();

        for (Cliente c : cadCli) {
            if (c.getId() == idBusca) {
                cadCli.remove(c);
                break;
            }
        }

    }

    public static void excluirF() {

        System.out.println("ID do funcionário para exclusão: ");
        int idBusca = input.nextInt();

        for (Funcionario f : cadFun) {
            if (f.getId() == idBusca) {
                cadFun.remove(f);
                break;
            }
        }

    }

    public static void excluirL() {
        limpaBuffer();
        System.out.println("Digite o nome do livro para a exclusão: ");
        String nomeBusca = input.nextLine();

        for (Livro l : cadLiv) {
            if (l.getNome().toLowerCase().startsWith(nomeBusca.toLowerCase())) {
                cadLiv.remove(l);
                break;
            }
        }
    }

    public static void buscarC() {
        limpaBuffer();
        System.out.println("Digite o começo do nome do cliente para a pesquisa: ");
        String busca = input.nextLine();

        for (Cliente c : cadCli) {
            if (c.nome.toLowerCase().startsWith(busca.toLowerCase())) {
                c.mostraDados();
            }
        }
    }

    public static void buscarF() {
        limpaBuffer();
        System.out.println("Digite o começo do nome do funcionário para a pesquisa: ");
        String busca = input.nextLine();

        for (Funcionario f : cadFun) {
            if (f.nome.toLowerCase().startsWith(busca.toLowerCase())) {
                f.mostraDados();
            }
        }
    }

    public static void buscarL() {
        System.out.println("Deseja buscar por: \n[1] Descrição\n[2] Nome \n[3] Preço");
        int resp = input.nextInt();

        switch (resp) {
            case 1:
                limpaBuffer();
                System.out.println("Digite parte da descrição do produto: ");
                String buscaD = input.nextLine();
                for (Livro l : cadLiv) {
                    if (l.getDescricao().contains(buscaD)) {
                        l.mostraDados();
                    }
                }
                break;
            case 2:
                limpaBuffer();
                System.out.println("Digite parte do nome do Livro: ");
                String buscaN = input.nextLine();
                for (Livro l : cadLiv) {
                    if (l.getNome().startsWith(buscaN)) {
                        l.mostraDados();
                    }
                }
                break;
            case 3:
                System.out.println("Digite o preço do Livro: ");
                float buscaPreco = input.nextInt();
                for (Livro l : cadLiv) {
                    if (l.getPreco() == buscaPreco) {
                        l.mostraDados();
                    }
                }
                break;
        }
    }

    public static void clienteMaisVelho(){
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

    public static void clienteMaisNovo(){
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

    public static int qtdClientesIdosos(){
        int qtdvelhos = 0;
        for(Cliente c: cadCli){
            if(c.idade > 60){
                qtdvelhos++;
            }
        }
        return qtdvelhos;
    }

    public static int qtdClientesMenores(){
        int qtdnovos = 0;
        for(Cliente c: cadCli){
            if(c.idade < 18){
                qtdnovos++;
            }
        }
        return qtdnovos;
    }

    public static float idadeMediaClientes(){
        int cont = 0;
        int numeros =0;

        for(Cliente c: cadCli){
            numeros += c.idade;
            cont++;
        }
        return numeros / cont;
    }

    public static float livroMaisCaro(){
        float maiscaro = 0;
        for (Livro l: cadLiv){
            if (l.getPreco() > maiscaro)
            {
                maiscaro = l.getPreco();
            }
        }
        for(Livro l:cadLiv){
            if (l.getPreco() == maiscaro){
                l.mostraDados();
            }
        }
        return maiscaro;
    }

    public static float livroMaisBarato(){
        float maisbarato = 2147483647;
        for (Livro l: cadLiv){
            if (l.getPreco() < maisbarato)
            {
                maisbarato = l.getPreco();
            }
        }

        for (Livro l: cadLiv){
            if(l.getPreco() == maisbarato){
                l.mostraDados();
            }
        }
        return maisbarato;
    }

    public static float mediaPrecosLivros(){
        int cont = 0;
        int numeros =0;

        for(Livro l: cadLiv){
            numeros += l.preco;
            cont++;
        }
        if (cont == 0){
            return -1;
        }
        return numeros / cont;
    }

    public static int qtdLivrosCaros(){
        int qtdcaros = 0;
        float precomedio = mediaPrecosLivros();
        if (precomedio < 0){
            return -1;
        }
        for(Livro l: cadLiv){
            if (l.preco > precomedio){
                qtdcaros++;
            }
        }
        return qtdcaros;
    }
    
    //Main ==========================================

    public static void main(String[] args) 
    {
        int opcao, resposta;
        boolean loop;
        
        loop = true;
        
        while (loop)
        {
            System.out.println("|==============|SISTEMA DE VENDAS PARA LIVRARIA|==============|\n");
 
            
            System.out.println("\nDigite o respectivo número para: "
                    + "\n[1] Criar um cadastro "
                    + "\n[2] Excluir um cadastro "
                    + "\n[3] Buscar cadastro "
                    + "\n[4] Pesquisar outras informações\n");
            opcao = input.nextInt();

            switch(opcao)
            {
                case 1:
                    System.out.println("\nDigite o respectivo número para: "
                            + "\n[1] Criar um cadastro de cliente "
                            + "\n[2] Criar um cadastro de funcionário "
                            + "\n[3] Criar um cadastro de livro\n");
                    opcao = input.nextInt();

                    switch (opcao)
                    {
                        case 1: 
                            cadastrarC();
                            break;
                        case 2:
                            cadastrarF();
                            break;
                        case 3:
                            cadastrarL();
                            break;
                    }

                    break;

                case 2:
                    System.out.println("\nDigite o respectivo número para: "
                            + "\n[1] Excluir um cadastro de cliente "
                            + "\n[2] Excluir um cadastro de funcionário "
                            + "\n[3] Excluir um cadastro de livro\n");
                    opcao = input.nextInt();

                    switch (opcao)
                    {
                        case 1: 
                            excluirC();
                            break;
                        case 2:
                            excluirF();
                            break;
                        case 3:
                            excluirL();
                            break;
                    }
                    break;

                case 3:
                    System.out.println("\nDigite o respectivo número para: "
                            + "\n[1] Buscar um cadastro de cliente "
                            + "\n[2] Buscar um cadastro de funcionário "
                            + "\n[3] Buscar um cadastro de livro\n");
                    opcao = input.nextInt();

                    switch (opcao)
                    {
                        case 1: 
                            buscarC();
                            break;
                        case 2:
                            buscarF();
                            break;
                        case 3:
                            buscarL();
                            break;
                    }
                    break;

                case 4:
                    System.out.println("\nDigite o respectivo número para: "
                            + "\n[1] Buscar informações sobre os clientes "
                            + "\n[2] Buscar informações sobre os livros\n");
                    opcao = input.nextInt();

                    switch (opcao)
                    {
                        case 1:
                            System.out.println("\nDigite o respectivo número para: "
                                    + "\n[1] O cliente de maior idade do sistema "
                                    + "\n[2] O cliente de menor idade do sistema "
                                    + "\n[3] A quantidade de clientes maiores de 60 anos "
                                    + "\n[4] A quantidade de clientes menores de 18 anos "
                                    + "\n[5] A idade média dos clientes.\n");
                            opcao = input.nextInt();
                            switch (opcao)
                            {
                                case 1:
                                    clienteMaisVelho();
                                    break;
                                case 2:
                                    clienteMaisNovo();
                                    break;
                                case 3:
                                    System.out.println("|===============|\nA quantidade de clientes maiores de 60 anos é: " + qtdClientesIdosos() +
                                            "\n|===============|");
                                    break;
                                case 4:
                                    System.out.println("|===============|\nA quantidade de clientes menores de 18 anos é: " + qtdClientesMenores() +
                                    "\n|===============|");
                                    break;
                                case 5:
                                    System.out.println("|===============|\nA média de idade dos clientes é de: " +idadeMediaClientes() +
                                            " anos \n|===============|");
                                    break; 
                            }
                            break;

                        case 2:
                            System.out.println("\nDigite o respectivo número para: "
                                    + "\n[1] O livro mais caro do sistema"
                                    + "\n[2] O livro mais barato do sistema"
                                    + "\n[3] A média de preços dos livros"
                                    + "\n[4] A quantidade de livros com preço acima da média\n");

                            opcao = input.nextInt();

                            switch (opcao)
                            {
                                case 1:
                                    livroMaisCaro();
                                    break;
                                case 2:
                                    livroMaisBarato();
                                    break;
                                case 3:
                                    float media = mediaPrecosLivros();
                                    if (media == -1){
                                        System.out.println("|===============|" + "Não há livros no estoque." + "|===============|");
                                    }
                                    else{
                                        System.out.println("|===============|" + "A média dos preços é: " + mediaPrecosLivros() + " R$|===============|");
                                    }
                                    break;
                                case 4:
                                    if (qtdLivrosCaros() < 0){
                                        System.out.println("|===============|" + "Não há livros no estoque." + "|===============|");
                                    }
                                    else{
                                    System.out.println("|===============|" + "A quantidade de livros com preço acima da média é: " + qtdLivrosCaros() + "|===============|");
                                    }
                                    break;
                            }
                            break;

                    }
                    break;
                    
            }
            limpaBuffer();
            System.out.println("\nDeseja continuar? Digite [1] caso sim ou [2] caso não\n");
            resposta = input.nextInt();
            if (resposta != 1)
            {
                loop = false;
            }
            
        
            System.out.println("\n\n---------------------------------------------------------------\n\n");
        }
     
    }
}
