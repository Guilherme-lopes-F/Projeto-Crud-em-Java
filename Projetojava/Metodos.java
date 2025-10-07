import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    static ArrayList<Funcionarios> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


//OBs:Create está pronto

    static void contratarFuncionario(){
        System.out.println("Bem vindo, Havanna! Quem você quer contratar?\n");
        
        System.out.println("Por favor insira o nome do escra-..quero dizer.. Funcionário(aluno)");
        String nome = sc.nextLine();

        sc.nextLine();
        System.out.println("Por favor insira a idade");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Agora digite o  email, se possivel o pessoal");
        String email = sc.next();

        System.out.println("Insira o código do funcionário");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.println("Insira o cargo");
        String cargo = sc.nextLine();

        System.out.println("Insira o salario");
        double salario = sc.nextDouble();
        sc.nextLine();

        
        
        Funcionarios f = new Funcionarios(nome, idade, email, codigo, cargo, salario);
        list.add(f);
    }

    //OBs: Rea está pronto
    static void VerFuncionarios(){
        if(list.isEmpty()){
            System.out.println("Eu acho que não é possivel ver os fúncionários se não existe funcionários");
        }else{
            for (Funcionarios r : list){
            System.out.println(r);
            }
          }
        }
        
    
}
