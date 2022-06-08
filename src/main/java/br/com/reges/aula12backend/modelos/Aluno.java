package br.com.reges.aula12backend.modelos;




public class Aluno extends Pessoa {

    private String plano;
    private String mensalidade;

    //CONSTRUTORES
    public Aluno() {
    }

     //CONSTRUTOR COM NOME, TELEFONE, EMAIL
    public Aluno(String pNome,String pDocumento, String pTelefone) {
        super(pNome, pDocumento, pTelefone);
    }

    //CONSTRUTOR COM NOME, TELEFONE, EMAIL E PLANO E MENSALIDADE
    public Aluno(String pNome, String pEmail, String pDocumento, String pTelefone ,String pPlano, String pMensalidade) {
        super(pNome, pEmail, pDocumento, pTelefone);
        this.plano = pPlano;
        this.mensalidade = pMensalidade;
    }

    //CONSTRUTOR COM NOME, TELEFONE, EMAIL, DATA DE NASCIMENTO E ENDERECO
    public Aluno(String pNome, String pDocumento, String pTelefone, String pEmail, String pDataNascimento, Endereco pEndereco) {
        super(pNome, pDocumento, pTelefone, pEmail, pDataNascimento, pEndereco);

    }

    //CONSTRUTOR COMPLETO
    public Aluno(String pNome, String pDocumento, String pTelefone, String pEmail, String pDataNascimento, Endereco pEndereco, String pPlano, String pMensalidade) {
        super(pNome, pDocumento, pTelefone, pEmail, pDataNascimento, pEndereco);//CHAMA O CONSTRUTOR DA CLASSE PAI               
        this.plano = pPlano;
        this.mensalidade = pMensalidade;

    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }
}
