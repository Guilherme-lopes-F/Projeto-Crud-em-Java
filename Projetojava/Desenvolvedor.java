public class Desenvolvedor extends Funcionarios {

    private String linguagemPrincipal;

    public Desenvolvedor(String nome, int idade, String email, int codigo, double salario, String rua, String cidade,
            String linguagemPrincipal) {
        super(nome, idade, email, codigo, "Desenvolvedor", salario, rua, cidade);
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", linguagem='" + getLinguagemPrincipal() + "'" +
                "\n***********************************\n";
    }
}
