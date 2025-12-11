package br.ifpe.funcionarios.model;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DesenvolvedorDAO {

    private final JdbcClient jdbc;

    public DesenvolvedorDAO(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    public Integer create(Desenvolvedor d) {
        String sql = "INSERT INTO funcionario (nome, idade, email, codigo, cargo, salario, rua, cidade, linguagem) " +
                "VALUES (:nome, :idade, :email, :codigo, 'Desenvolvedor', :salario, :rua, :cidade, :linguagem)";
        return jdbc.sql(sql)
                .param("nome", d.getNome())
                .param("idade", d.getIdade())
                .param("email", d.getEmail())
                .param("codigo", d.getCodigo())
                .param("salario", d.getSalario())
                .param("rua", d.getEndereco().getRua())
                .param("cidade", d.getEndereco().getCidade())
                .param("linguagem", d.getLinguagemPrincipal())
                .update();
    }

    public List<Desenvolvedor> findAll() {
        String sql = "SELECT * From funcionario where cargo = 'Desenvolvedor'";
        return jdbc.sql(sql).query(this::mapRow).list();
    }

    public List<Desenvolvedor> filtrarPorNome(String nome) {
        String sql = "SELECT * From funcionario where cargo = 'Desenvolvedor' AND nome LIKE :nome";
        return jdbc.sql(sql)
                .param("nome", "%" + nome + "%")
                .query(this::mapRow)
                .list();
    }

    public Desenvolvedor findById(int id) {
        String sql = "Select * From funcionario where id = :id";
        return jdbc.sql(sql).param("id", id).query(this::mapRow).single();
    }

    public Integer update(Desenvolvedor d) {
        String sql = """
                    UPDATE funcionario SET
                        nome = :nome, idade = :idade, email = :email, codigo = :codigo,
                        salario = :salario, rua = :rua, cidade = :cidade, linguagem = :linguagem
                    Where id = :id
                """;
        return jdbc.sql(sql)
                .param("nome", d.getNome())
                .param("idade", d.getIdade())
                .param("email", d.getEmail())
                .param("codigo", d.getCodigo())
                .param("salario", d.getSalario())
                .param("rua", d.getEndereco().getRua())
                .param("cidade", d.getEndereco().getCidade())
                .param("linguagem", d.getLinguagemPrincipal())
                .param("id", d.getId())
                .update();
    }

    public Integer delete(int id) {
        String sql = "DELETE From funcionario where id = :id";
        return jdbc.sql(sql).param("id", id).update();
    }

    private Desenvolvedor mapRow(ResultSet r, int rowNum) throws SQLException {
        Desenvolvedor d = new Desenvolvedor(
                r.getString("nome"), r.getInt("idade"), r.getString("email"), r.getInt("codigo"),
                r.getDouble("salario"), r.getString("rua"), r.getString("cidade"), r.getString("linguagem"));
        d.setId(r.getInt("id"));
        return d;
    }
}