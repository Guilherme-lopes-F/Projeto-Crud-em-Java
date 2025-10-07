class Funcionarios{

        String nome;
        int idade;
        String email;
        int codigo;
        String cargo;
        double salario;
        
        

        public Funcionarios(String nome, int idade, String email, int codigo, String cargo, double salario) {
                this.nome = nome;
                this.idade = idade;
                this.email = email;
                this.codigo = codigo;
                this.cargo = cargo;
                this.salario = salario;
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


}