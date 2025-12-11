package br.ifpe.funcionarios.model;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GerenteDAO {

    private final JdbcClient jdbc;

    public GerenteDAO(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public Integer create(Gerente g) {
        String sql = "INSERT INTO funcionario (nome, idade, email, codigo, cargo, salario, rua, cidade, bonus) " +
                "VALUES (:nome, :idade, :email, :codigo, 'Gerente', :salario, :rua, :cidade, :bonus)";

        return jdbc.sql(sql)
                .param("nome", g.getNome())
                .param("idade", g.getIdade())
                .param("email", g.getEmail())
                .param("codigo", g.getCodigo())
                .param("salario", g.getSalario())
                .param("rua", g.getEndereco().getRua())
                .param("cidade", g.getEndereco().getCidade())
                .param("bonus", g.getBonus())
                .update();
    }

    // READ - Listar todos
    public List<Gerente> findAll() {
        String sql = "SELECT * From funcionario where cargo ='Gerente'";
        return jdbc.sql(sql).query(this::mapRow).list();
    }

    // READ - Buscar por Nome
    public List<Gerente> filtrarPorNome(String nome) {
        String sql = "SELECT * From funcionario where cargo ='Gerente' AND nome LIKE :nome";
        return jdbc.sql(sql)
                .param("nome", "%" + nome + "%")
                .query(this::mapRow)
                .list();
    }

    // READ - Buscar por ID
    public Gerente findById(int id) {
        String sql = "Select * From funcionario where id = :id";
        return jdbc.sql(sql)
                .param("id", id)
                .query(this::mapRow)
                .single();
    }

    // UPDATE
    public Integer update(Gerente g) {
        String sql = """
                    UPDATE funcionario SET
                        nome = :nome,
                        idade = :idade,
                        email = :email,
                        codigo = :codigo,
                        salario = :salario,
                        rua = :rua,
                        cidade = :cidade,
                        bonus = :bonus
                    Where id = :id
                """;
        return jdbc.sql(sql)
                .param("nome", g.getNome())
                .param("idade", g.getIdade())
                .param("email", g.getEmail())
                .param("codigo", g.getCodigo())
                .param("salario", g.getSalario())
                .param("rua", g.getEndereco().getRua())
                .param("cidade", g.getEndereco().getCidade())
                .param("bonus", g.getBonus())
                .param("id", g.getId())
                .update();
    }

    // DELETE
    public Integer delete(int id) {
        String sql = "DELETE From funcionario where id = :id";
        return jdbc.sql(sql).param("id", id).update();
    }

    // Mapper
    private Gerente mapRow(ResultSet r, int rowNum) throws SQLException {
        Gerente g = new Gerente();
        g.setId(r.getInt("id"));
        g.setNome(r.getString("nome"));
        g.setIdade(r.getInt("idade"));
        g.setEmail(r.getString("email"));
        g.setCodigo(r.getInt("codigo"));
        g.setSalario(r.getDouble("salario"));
        g.setBonus(r.getDouble("bonus"));
        g.setCargo("Gerente");

        Endereco en = new Endereco();
        en.setRua(r.getString("rua"));
        en.setCidade(r.getString("cidade"));
        g.setEndereco(en);
        return g;
    }
}