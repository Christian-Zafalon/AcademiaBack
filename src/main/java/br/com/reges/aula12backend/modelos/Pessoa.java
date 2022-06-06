package br.com.reges.aula12backend.modelos;


public abstract class Pessoa {
    
    private int id;    
    private String nome;      
    private String telefone;
    private String email;
    private String dataNascimento;    
    private  Endereco endereco; 

   
    
    
    //CONSTRUTOR DEFAULT
     public Pessoa() {}
    
     
     //CONSTRUTOR SOMENTE COM NOME
     public Pessoa(String pNome){
        this.nome = pNome;       
     
        
    };
     
      //CONSTRUTOR COM NOME E TELEFONE
      public Pessoa(String pNome, String pTelefone){
        this.nome = pNome;    
        this.telefone = pTelefone;        
    };       
    
          //CONSTRUTOR COM NOME E TELEFONE E EMAIL
          public Pessoa(String pNome, String pTelefone, String pEmail){
            this.nome = pNome;    
            this.telefone = pTelefone;     
            this.email = pEmail;   
        };  
     
     
     //CONSTRUTOR COMPLETO
      public Pessoa(String pNome, String pTelefone, String pEmail, String pDataNascimento, Endereco pEndereco){
        this.nome = pNome;
        this.telefone = pTelefone;
        this.email = pEmail;
        this.dataNascimento = pDataNascimento;
        this.endereco = pEndereco;        
    };
    
    
    
   
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }       
                 
    
}

