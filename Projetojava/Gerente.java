public class Gerente extends Funcionarios {

    private double bonus;

    public Gerente(String nome, int idade, String email, int codigo, double salario, String rua, String cidade,
            double bonus) {
        super(nome, idade, email, codigo, "Gerente", salario, rua, cidade);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonus='" + getBonus() + "'" +
                "\n***********************************\n";
    }
}
