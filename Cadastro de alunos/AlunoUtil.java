//Aluno:Filipe Alves Sousa Julio

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoUtil {
    public static Scanner input = new Scanner(System.in);
    public static List<Aluno> lista = new ArrayList<>();

    public static void main(String[] args){
        String op = null;

        while (true) {
            System.out.print("Cadastrar (c), Listar por Curso (l) ou Encerrar(e)? ");
            op = input.nextLine().toLowerCase();

            if(op.equals("e")){
                System.out.println("Encerrando programa");
                break;
            }

            switch (op) {
                case "c":
                    try{
                        cadastrarAluno();
                    } catch (Exception e){
                        System.out.println("Entrada inválida. Tente novamente");
                        input.nextLine();
                    }
                    break;
                case "l":
                    listarPorCurso();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Quantidade final de alunos cadastrados: " + lista.size());
        input.close();
    }

    // Questão 1
    public static void cadastrarAluno(){
        System.out.print("- Digite a matrícula do aluno: ");
        int matricula = input.nextInt();
        input.nextLine();
        System.out.print("- Digite o nome do aluno: ");
        String nome = input.nextLine().toLowerCase();
        System.out.print("- Digite o sexo do aluno: ");
        String sexo = input.nextLine().toLowerCase();
        System.out.print("- Digite o curso do aluno: ");
        String curso = input.nextLine().toLowerCase();
        System.out.print("- Digite o ano de ingresso: ");
        int anoIngresso = input.nextInt();
        input.nextLine();
        System.out.print("- Digite o semestre de ingresso: ");
        int semestreIngresso = input.nextInt();
        input.nextLine();
        Aluno cadastro = new Aluno (matricula, nome, sexo, curso, anoIngresso, semestreIngresso);
        lista.add(cadastro);
    }

    //Questão 2 letra a
    public static void listarPorCurso(){
        if (lista.isEmpty()){
            System.out.println("Lista vazia");
        } else {
            System.out.print("- Digite o nome do curso: ");
            String curso = input.nextLine().toLowerCase();
            System.out.println("Alunos do curso de " + curso + ":");
            for(Aluno a: lista){
                if(a.getCurso().equals(curso)){
                    System.out.println(a.getMatricula() + " - " + a.getNome() + " - " +a.getAnoIngresso() + "/" + a.getSemestreIngresso());
                }
            }
        }
    }

    //Questão 2 letra c
    public static void quantidadeAlunos(){
        System.out.println("Quantidade de alunos cadastrados: " + lista.size());
    }
}