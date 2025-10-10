import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    static ArrayList<Funcionarios> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // OBs:Create está pronto (João G.)

    static void contratarFuncionario() {
        System.out.println("Bem vindo, Havanna! Quem você quer contratar?\n");

        System.out.println("Por favor insira o nome do escra-..quero dizer.. Funcionário(aluno)");
        String nome = sc.nextLine();

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

    // OBs: Read está pronto (João G.)
    static void VerFuncionarios() {
        if (list.isEmpty()) {
            System.out.println("Eu acho que não é possivel ver os fúncionários se não existe funcionários");
        } else {
            for (Funcionarios r : list) {
                System.out.println(r);
            }
        }
    }

    // OBS: Update está pronto (Juan)
    static void atualizarFuncionario() {
        System.out.println("Bem vindo, Havanna! Quem você quer atualizar?\n");

        if (list.isEmpty()) {
            System.out.println("Não há funcionários cadastrados para atualizar.");
            return;
        }

        System.out.println("Digite o código do funcionário que você deseja atualizar");
        int codigoBusca = sc.nextInt();
        sc.nextLine(); // Consumir a nova linha após nextInt()

        Funcionarios funcionarioParaAtualizar = null;
        boolean encontrado = false;

        for (Funcionarios f : list) {
            if (f.getCodigo() == codigoBusca) {
                funcionarioParaAtualizar = f;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Funcionário encontrado: " + funcionarioParaAtualizar.getNome());
            System.out.println(
                    "Insira os novos dados do escra- ..quero dizer.. Funcionário (pressione Enter para manter a informação atual):");

            System.out.print("Novo nome [" + funcionarioParaAtualizar.getNome() + "]: ");
            String novoNome = sc.nextLine();
            if (!novoNome.trim().isEmpty()) { // .trim() remove espaços em branco no início e fim
                funcionarioParaAtualizar.setNome(novoNome);
            }

            System.out.print("Nova idade [" + funcionarioParaAtualizar.getIdade() + "]: ");
            String novaIdadeStr = sc.nextLine();
            if (!novaIdadeStr.trim().isEmpty()) {
                try {
                    int novaIdade = Integer.parseInt(novaIdadeStr); // Converte String para int
                    funcionarioParaAtualizar.setIdade(novaIdade);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida para idade. Mantendo o valor original.");
                }
            }

            System.out.print("Novo email [" + funcionarioParaAtualizar.getEmail() + "]: ");
            String novoEmail = sc.nextLine();
            if (!novoEmail.trim().isEmpty()) {
                funcionarioParaAtualizar.setEmail(novoEmail);
            }

            System.out.print("Novo cargo [" + funcionarioParaAtualizar.getCargo() + "]: ");
            String novoCargo = sc.nextLine();
            if (!novoCargo.trim().isEmpty()) {
                funcionarioParaAtualizar.setCargo(novoCargo);
            }

            System.out.print("Novo salário [" + funcionarioParaAtualizar.getSalario() + "]: ");
            String novoSalarioStr = sc.nextLine();
            if (!novoSalarioStr.trim().isEmpty()) {
                try {
                    double novoSalario = Double.parseDouble(novoSalarioStr); // Converte String para double
                    funcionarioParaAtualizar.setSalario(novoSalario);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida para salário. Mantendo o valor original.");
                }
            }

            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário com o código " + codigoBusca + " não encontrado.");
        }
    }

    // Delete feito por Tomé
    static void deletarFuncionario() {
        System.out.println("Bem vinda, Havanna! Quem você quer demitir/expulsar hoje?\n");

        if (list.isEmpty()) {
            System.out.println("Não há funcionários cadastrados para deletar.");
            return;
        }

        System.out.println("Digite o código do funcionário que você deseja deletar:");
        int codigoBusca = sc.nextInt();
        sc.nextLine();

        boolean removido = false;

        removido = list.removeIf(f -> f.getCodigo() == codigoBusca);

        if (removido) {
            System.out.println("Funcionário removido com sucesso! Espero que ele não processe a empresa.");
        } else {
            System.out.println("Nenhum funcionário encontrado com o código " + codigoBusca + ".");
        }
    }

}
