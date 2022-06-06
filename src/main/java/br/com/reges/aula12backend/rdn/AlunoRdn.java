/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reges.aula12backend.rdn;

import br.com.reges.aula12backend.modelos.Aluno;
import br.com.reges.aula12backend.modelos.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author alex.lopes
 */
public class AlunoRdn {

    public int inserir(Aluno aluno) throws SQLException {

        StringBuilder sql = new StringBuilder();
        int linhasAfetadas = 0;

        sql.append("INSERT INTO alunos                                ");
        sql.append("            (nome                                 ");
        sql.append("            ,telefone                             ");
        sql.append("            ,data_nascimento                      ");
        sql.append("            ,email                                ");
        sql.append("            ,plano                                ");
        sql.append("            ,mensalidade                          ");
        sql.append("            ,logradouro                           ");
        sql.append("            ,bairro                               ");
        sql.append("            ,cep                                  ");
        sql.append("            ,cidade                               ");
        sql.append("            ,complemento                          ");
        sql.append("            ,numero                               ");
        sql.append("            ,uf)                                  ");
        sql.append("        VALUES                                    ");
        sql.append("              (?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?                                  ");
        sql.append("              ,?)                                 ");

        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql.toString());

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getTelefone());
        stmt.setString(3, aluno.getDataNascimento());
        stmt.setString(4, aluno.getEmail());
        stmt.setString(5, aluno.getPlano());
        stmt.setString(6, aluno.getMensalidade());
        stmt.setString(7, aluno.getEndereco().getLogradouro());
        stmt.setString(8, aluno.getEndereco().getBairro());
        stmt.setString(9, aluno.getEndereco().getCep());
        stmt.setString(10, aluno.getEndereco().getCidade());
        stmt.setString(11, aluno.getEndereco().getComplemento());
        stmt.setString(12, aluno.getEndereco().getNumero());
        stmt.setString(13, aluno.getEndereco().getUf());

        linhasAfetadas = stmt.executeUpdate();

        System.out.print("linhas afetadas: " + linhasAfetadas);

        stmt.close();
        conn.close();

        return linhasAfetadas;
    }

    public ArrayList<Aluno> obterTodos() {

        ArrayList<Aluno> retorno = new ArrayList<Aluno>();

        try {

            StringBuilder str = new StringBuilder();

            str.append("select  a.id_aluno                   ");
            str.append("        ,a.nome                        ");
            str.append("        ,a.telefone                    ");
            str.append("        ,a.data_nascimento             ");
            str.append("        ,a.email                       ");
            str.append("        ,a.plano                       ");
            str.append("        ,a.mensalidade                 ");
            str.append("        ,a.logradouro                  ");
            str.append("        ,a.bairro                      ");
            str.append("        ,a.cep                         ");
            str.append("        ,a.complemento                 ");
            str.append("        ,a.numero                      ");
            str.append("        ,a.uf                          ");
            str.append("        ,a.cidade                      ");
            str.append(" from alunos a                        ");

            //ABRE A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //CRIAR NOSSO STATEMENT
            Statement stmt = conn.createStatement();

            //RECEBER OS DADOS NO RESULTSET
            ResultSet rs = stmt.executeQuery(str.toString());

            //PERCORRE TODOS OS REGISTROS DO RESULT SET
            while (rs.next()) {
                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getString("data_nascimento"));
                aluno.setEmail(rs.getString("email"));
                aluno.setPlano(rs.getString("plano"));
                aluno.setMensalidade(rs.getString("mensalidade"));

                //POPULAR/CARREGAR OS ATRIBUTOS DO ENDEREÇO
                Endereco end = new Endereco();
                end.setLogradouro(rs.getString("logradouro"));
                end.setNumero(rs.getString("numero"));
                end.setBairro(rs.getString("bairro"));
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));
                end.setComplemento(rs.getString("complemento"));
                end.setUf(rs.getString("uf"));
                //INCLUIR O OBJETO ENDEREÇO NA ATRIBUTO DO Aluno
                aluno.setEndereco(end);

                //ADICIONAR O OBJETO Aluno NA LISTA DE Alunos
                retorno.add(aluno);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return retorno;
    }

    public int excluir(int id) {

        int numeroLinhasAfetadas = 0;

        try {

            String str = "delete from alunos where id_aluno = ?";

            //RECUPERAR A CONEXÃO 
            Connection conn = new ConnectionFactory().getConnection();

            //INSTANCIA O COMANDO
            PreparedStatement statement = conn.prepareStatement(str);
            
            //CONFIGURA O PRAMETRO
            statement.setInt(1, id);

            //EXECUTA O DELETE
            numeroLinhasAfetadas = statement.executeUpdate();

            //FECHA A CONEXÃO E O STATEMENT
            conn.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return numeroLinhasAfetadas;
    }
    
    
     public int deletar(int id) {

        int numeroLinhasAfetadas = 0;

        try {

            String str = "delete from alunos where id_aluno = ?";

            //RECUPERAR A CONEXÃO 
            Connection conn = new ConnectionFactory().getConnection();
            //INSTANCIAR O COMANDO
            PreparedStatement stmt = conn.prepareStatement(str.toString());

            //CRIAÇÃO DE PARAMETROS
            stmt.setInt(1, id);          
            
            //EXECUTA O DELETE
            numeroLinhasAfetadas = stmt.executeUpdate();

            //FECHA A CONEXÃO E O STATEMENT
            conn.close();

            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return numeroLinhasAfetadas;
    }

    public int alterar(Aluno aluno) {

        StringBuilder str = new StringBuilder();
        int numeroLinhasAfetadas = 0;

        try {

            str.append(" update alunos set nome = ?                       ");
            str.append("                    ,telefone = ?                  ");
            str.append("                    ,data_nascimento = ?           ");
            str.append("                    ,email = ?                     ");
            str.append("                    ,plano = ?                     ");
            str.append("                    ,mensalidade = ?               ");
            str.append("                    ,logradouro = ?                ");
            str.append("                    ,bairro = ?                    ");
            str.append("                    ,cep = ?                       ");
            str.append("                    ,cidade = ?                    ");
            str.append("                    ,complemento = ?               ");
            str.append("                    ,numero = ?                    ");
            str.append("                    ,uf = ?                        ");
            str.append("where id_aluno = ?                                 ");

            //RECUPERAR A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //INSTANCIAR O COMANDO
            PreparedStatement stmt = conn.prepareStatement(str.toString());

            //CRIAÇÃO DE PARAMETROS
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getDataNascimento());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getPlano());
            stmt.setString(6, aluno.getMensalidade());
            stmt.setString(7, aluno.getEndereco().getLogradouro());
            stmt.setString(8, aluno.getEndereco().getBairro());
            stmt.setString(9, aluno.getEndereco().getCep());
            stmt.setString(10, aluno.getEndereco().getCidade());
            stmt.setString(11, aluno.getEndereco().getComplemento());
            stmt.setString(12, aluno.getEndereco().getNumero());
            stmt.setString(13, aluno.getEndereco().getUf());
            stmt.setInt(14, aluno.getId());

            //EXECUTAR O COMANDO
            //numeroLinhasAfetadas = stmt.executeUpdate(str.toString());
            numeroLinhasAfetadas = stmt.executeUpdate();

            //FECHAR OS RECURSOS
            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        return numeroLinhasAfetadas;

    }

    public Aluno obterPorId(int id) {

        Aluno aluno = new Aluno();

        try {

            StringBuilder str = new StringBuilder();

            str.append("select  a.id_aluno                     ");
            str.append("        ,a.nome                        ");
            str.append("        ,a.telefone                    ");
            str.append("        ,a.data_nascimento             ");
            str.append("        ,a.email                       ");
            str.append("        ,a.plano                       ");
            str.append("        ,a.mensalidade                 ");
            str.append("        ,a.logradouro                  ");
            str.append("        ,a.bairro                      ");
            str.append("        ,a.cep                         ");
            str.append("        ,a.cidade                      ");
            str.append("        ,a.complemento                 ");
            str.append("        ,a.numero                      ");
            str.append("        ,a.uf                          ");
            str.append(" from alunos a                        ");
            str.append(" where a.id_aluno = ?                ");

            //ABRE A CONEXÃO
            Connection conn = new ConnectionFactory().getConnection();

            //CRIAR NOSSO STATEMENT           
            PreparedStatement stmt = conn.prepareStatement(str.toString());

            //PASSAR O PARAMETRO DE ID
            stmt.setInt(1, id);

            //RECEBER OS DADOS NO RESULTSET
            ResultSet rs = stmt.executeQuery();

            //PERCORRE TODOS OS REGISTROS DO RESULT SET
            while (rs.next()) {
                //Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getString("data_nascimento"));
                aluno.setEmail(rs.getString("email"));
                aluno.setPlano(rs.getString("plano"));
                aluno.setMensalidade(rs.getString("mensalidade"));


                //POPULAR/CARREGAR OS ATRIBUTOS DO ENDEREÇO
                Endereco end = new Endereco();
                end.setLogradouro(rs.getString("logradouro"));
                end.setBairro(rs.getString("bairro"));
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));
                end.setComplemento(rs.getString("complemento"));
                end.setNumero(rs.getString("numero"));
                end.setUf(rs.getString("uf"));

                //INCLUIR O OBJETO ENDEREÇO NA ATRIBUTO DO Aluno
                aluno.setEndereco(end);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return aluno;
    }

}
