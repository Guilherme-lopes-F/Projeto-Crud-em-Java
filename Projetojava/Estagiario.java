public class Estagiario extends Funcionarios {

    private String instituicaoEnsino;

    public Estagiario(String nome, int idade, String email, int codigo, double salario, String rua, String cidade,
            String instituicaoEnsino) {
        super(nome, idade, email, codigo, "Estagiario", salario, rua, cidade);
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", instituicaoEnsino='" + getInstituicaoEnsino() + "'" +
                "\n***********************************\n";
    }
}
