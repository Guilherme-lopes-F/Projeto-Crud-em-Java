import java.util.Scanner;

public class Main {

    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("********Seja Bem vinda Havana, ao sistema de gerenciamento de funcionários");
            System.out.println("O que deseja fazer?" +
                    "\n 1.Adicionar novos trabalhadores" +
                    "\n 2. Visualizar quem está cadastrado no sistema" +
                    "\n 3. Atualizar dados de um usuário" +
                    "\n 4. Deletar usuário do sistema  (demissão)" +
                    "\n 5. Sair do sistema");

            escolha = sc.nextInt();
            switch (escolha) {
                case 1: {
                    System.out.println("\n");
                    Metodos.contratarFuncionario();
                    System.out.println("\n");
                    break;
                }
                case 2: {
                    System.out.println("\n");
                    Metodos.VerFuncionarios();
                    System.out.println("\n");
                    break;
                }
                case 3: {
                    System.out.println("\n");
                    Metodos.atualizarFuncionario();
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    System.out.println("\n");
                    Metodos.deletarFuncionario();
                    System.out.println("\n");
                    break;
                }

            }
        } while (escolha != 5);
    }
}
