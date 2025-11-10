//Aluno Filipe Alves Sousa Julio
//LP2

package avaliacao3.versao01.questao01;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaUtil {

    public static List<Pessoa> lista = new ArrayList<Pessoa>();
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            System.out.println("Digite: ");
            System.out.println("(0) para encerrar");
            System.out.println("(1) para adicionar pessoas");
            System.out.println("(2) para listar pessoas não saudáveis");
            System.out.println("(3) para listar pessoas acima da média");
            System.out.println("(4) para exibir a pessoa mais pesada");
            System.out.print(">> Opção: ");

            int op = input.nextInt();
            input.nextLine();

            if (op == 0) {
                System.out.println("Encerrando programa");
                resultado();
                break;
            }

            switch (op) {
                case 1 -> adicionarPessoa();
                case 2 -> listarNaoSaudaveis();
                case 3 -> acimaMedia();
                case 4 -> maisPesado();
                default -> throw new AssertionError();
            }
        }

    }

    public static void adicionarPessoa(){
        System.out.print("Digite o nome: ");
        String nome = input.nextLine();
        while(true){
            try {
                System.out.print("Digite o peso: ");
                double peso = input.nextDouble();
                input.nextLine();
                System.out.print("Digite a altura: ");
                double altura = input.nextDouble();
                input.nextLine();
                Pessoa pessoa = new Pessoa (nome, peso, altura);
                lista.add(pessoa);

                System.out.println("Pessoa adicionada com sucesso! \n");
                break;
            } catch (Exception e) {
                System.out.print("Peso ou altura ou ambos inválidos!\n");
            }            
        }
    }

    public static void listarNaoSaudaveis(){
        System.out.println("pessoas não saudáveis: ");
        for (Pessoa p : lista){
            if(p.getIMC()<18.5){
                double massaIdeal1 = 18.5 * (p.getAltura()*p.getAltura());
                System.out.println(p.getNome() + " - " + "precisa ganhar pelo menos " + (p.getPeso()-massaIdeal1) + "kg para ficar saudável");
            }
            if(p.getIMC()>=25){
                double massaIdeal2 = 24.9 * (p.getAltura()*p.getAltura());
                System.out.println(p.getNome() + " - " + "precisa perder pelo menos " + (p.getPeso()-massaIdeal2) + "kg para ficar saudável");
            }
        }
    }

    public static void acimaMedia(){
        double pesoTotal = 0;
            System.out.println("pessoas acima da média: ");
        for(Pessoa p : lista){
            pesoTotal += p.getPeso();
        }

        double media = pesoTotal/lista.size();
        
        for(Pessoa a : lista){
            if(a.getPeso() > media){
                System.out.println(a.getNome() + " está acima da média, com IMC igual a " + a.getIMC());
            }
        }
        System.out.println(media);
    }

    public static void maisPesado(){
        Pessoa maisPesada = lista.get(0);
        for (Pessoa x : lista){
            if(maisPesada.getPeso() < x.getPeso()){
                maisPesada = x;
            }
        }
        System.out.println("A pessoa mais pesada é: " + maisPesada.getNome() + " com " + maisPesada.getPeso() + "kg e " + maisPesada.getAltura() + "m");
    }

    public static void resultado(){
        ArrayList<Pessoa> magreza = new ArrayList<>();
        ArrayList<Pessoa> saudavel = new ArrayList<>();
        ArrayList<Pessoa> sobrepeso = new ArrayList<>();

        for(Pessoa y : lista){
            if(y.getIMC() < 18.5){
                magreza.add(y);
            }
            else if (y.getIMC()>=18.5 && y.getIMC()<25){
                saudavel.add(y);
            } else {
                sobrepeso.add(y);
            }
        }

        if(!lista.isEmpty()){
            System.out.println("----------RESULTADO----------");
            System.out.println("Magreza - " + magreza.size() + " pessoas - " + ((magreza.size()/lista.size())*100) + "% do total");
            System.out.println("Saudável - " + saudavel.size() + " pessoas - " + ((saudavel.size()/lista.size())*100) + "% do total");
            System.out.println("Sobrepeso ou Obesidade - " + sobrepeso.size() + " pessoas - " + ((sobrepeso.size()/lista.size())*100) + "% do total");
        } else {
            System.out.println("Lista vazia");
        }


    }

}