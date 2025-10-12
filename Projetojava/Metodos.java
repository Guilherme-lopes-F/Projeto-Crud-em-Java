import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {
    static ArrayList<Funcionarios> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // OBs:Create está pronto (João G.)
    static void contratarFuncionario() {
        System.out.println("Bem vindo, Havanna! Quem você quer contratar?\n");

        System.out.println("Qual o tipo de funcionário?");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.println("Por favor insira o nome do funcionário");
        String nome = sc.nextLine();

        System.out.println("Por favor insira a idade");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Agora digite o email");
        String email = sc.nextLine();

        System.out.println("Insira o código do funcionário");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.println("Insira o salario");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.println("--- Endereço ---");
        System.out.println("Insira a rua");
        String rua = sc.nextLine();
        System.out.println("Insira a cidade");
        String cidade = sc.nextLine();

        Funcionarios f = null;

        switch (tipo) {
            case 1:
                System.out.println("Insira o valor do bônus do Gerente");
                double bonus = sc.nextDouble();
                sc.nextLine();
                f = new Gerente(nome, idade, email, codigo, salario, rua, cidade, bonus);
                break;
            case 2:
                System.out.println("Insira a linguagem principal do Desenvolvedor");
                String linguagem = sc.nextLine();
                f = new Desenvolvedor(nome, idade, email, codigo, salario, rua, cidade, linguagem);
                break;
            case 3:
                System.out.println("Insira a instituição de ensino do Estagiário");
                String instituicao = sc.nextLine();
                f = new Estagiario(nome, idade, email, codigo, salario, rua, cidade, instituicao);
                break;
            default:
                System.out.println("Opção inválida. Operação cancelada.");
                return;
        }

        list.add(f);
        System.out.println("\nFuncionário contratado com sucesso!");
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
        sc.nextLine();

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
            if (!novoNome.trim().isEmpty()) {
                funcionarioParaAtualizar.setNome(novoNome);
            }

            System.out.print("Nova idade [" + funcionarioParaAtualizar.getIdade() + "]: ");
            String novaIdadeStr = sc.nextLine();
            if (!novaIdadeStr.trim().isEmpty()) {
                try {
                    int novaIdade = Integer.parseInt(novaIdadeStr);
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

            System.out.print("Novo salário [" + funcionarioParaAtualizar.getSalario() + "]: ");
            String novoSalarioStr = sc.nextLine();
            if (!novoSalarioStr.trim().isEmpty()) {
                try {
                    double novoSalario = Double.parseDouble(novoSalarioStr);
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
