package br.ifpe.funcionarios.model;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EstagiarioDAO {

    private final JdbcClient jdbc;

    public EstagiarioDAO(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public Integer create(Estagiario e) {
        String sql = "INSERT INTO funcionario (nome, idade, email, codigo, cargo, salario, rua, cidade, instituicao) " +
                "VALUES (:nome, :idade, :email, :codigo, 'Estagiario', :salario, :rua, :cidade, :instituicao)";

        return jdbc.sql(sql)
                .param("nome", e.getNome())
                .param("idade", e.getIdade())
                .param("email", e.getEmail())
                .param("codigo", e.getCodigo())
                .param("salario", e.getSalario())
                .param("rua", e.getEndereco().getRua())
                .param("cidade", e.getEndereco().getCidade())
                .param("instituicao", e.getInstituicaoEnsino())
                .update();
    }

    // READ LISTA
    public List<Estagiario> findAll() {
        String sql = "SELECT * From funcionario where cargo = 'Estagiario'";
        return jdbc.sql(sql).query(this::mapRow).list();
    }

    // READ SINGLE
    public Estagiario findById(int id) {
        String sql = "Select * From funcionario where id = :id";
        return jdbc.sql(sql)
                .param("id", id)
                .query(this::mapRow)
                .single();
    }

    // UPDATE
    public Integer update(Estagiario e) {
        String sql = """
                    UPDATE funcionario SET
                        nome = :nome,
                        idade = :idade,
                        email = :email,
                        codigo = :codigo,
                        salario = :salario,
                        rua = :rua,
                        cidade = :cidade,
                        instituicao = :instituicao
                    Where id = :id
                """;
        return jdbc.sql(sql)
                .param("nome", e.getNome())
                .param("idade", e.getIdade())
                .param("email", e.getEmail())
                .param("codigo", e.getCodigo())
                .param("salario", e.getSalario())
                .param("rua", e.getEndereco().getRua())
                .param("cidade", e.getEndereco().getCidade())
                .param("instituicao", e.getInstituicaoEnsino())
                .param("id", e.getId())
                .update();
    }

    // DELETE
    public Integer delete(int id) {
        String sql = "DELETE From funcionario where id = :id";
        return jdbc.sql(sql).param("id", id).update();
    }

    private Estagiario mapRow(ResultSet r, int rowNum) throws SQLException {
        Estagiario e = new Estagiario(
                r.getString("nome"),
                r.getInt("idade"),
                r.getString("email"),
                r.getInt("codigo"),
                r.getDouble("salario"),
                r.getString("rua"),
                r.getString("cidade"),
                r.getString("instituicao"));
        e.setId(r.getInt("id"));
        return e;
    }
}