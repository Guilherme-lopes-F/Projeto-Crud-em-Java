abstract class Funcionarios {

        private String nome;
        private int idade;
        private String email;
        private int codigo;
        private String cargo;
        private double salario;
        private Endereco endereco;

        public Funcionarios(String nome, int idade, String email, int codigo, String cargo, double salario, String rua,
                        String cidade) {
                this.nome = nome;
                this.idade = idade;
                this.email = email;
                this.codigo = codigo;
                this.cargo = cargo;
                this.salario = salario;
                this.endereco = new Endereco(rua, cidade);
        }

        public String getNome() {
                return this.nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public int getIdade() {
                return this.idade;
        }

        public void setIdade(int idade) {
                this.idade = idade;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public int getCodigo() {
                return this.codigo;
        }

        public void setCodigo(int codigo) {
                this.codigo = codigo;
        }

        public String getCargo() {
                return this.cargo;
        }

        public void setCargo(String cargo) {
                this.cargo = cargo;
        }

        public double getSalario() {
                return this.salario;
        }

        public void setSalario(double salario) {
                this.salario = salario;
        }

        public Endereco getEndereco() {
                return this.endereco;
        }

        public void setEndereco(Endereco endereco) {
                this.endereco = endereco;
        }

        @Override
        public String toString() {
                return "************************************" +
                                "\n" +
                                " nome='" + getNome() + "'" +
                                ", idade='" + getIdade() + "'" +
                                ", email='" + getEmail() + "'" +
                                ", codigo='" + getCodigo() + "'" +
                                ", cargo='" + getCargo() + "'" +
                                ", salario='" + getSalario() + "'" +
                                ", endereco='" + getEndereco().getRua() + ", " + getEndereco().getCidade() + "'";
        }

}
