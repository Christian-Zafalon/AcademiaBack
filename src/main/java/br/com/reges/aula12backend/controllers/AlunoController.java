package br.com.reges.aula12backend.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.reges.aula12backend.modelos.Aluno;
import br.com.reges.aula12backend.rdn.AlunoRdn;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AlunoController {

  
    @GetMapping("/alunos")
    public List<Aluno> Get() {

        AlunoRdn rdn = new AlunoRdn();
        return rdn.obterTodos();

    }
  
    @GetMapping("/alunos/{id}")
    public Aluno GetById(@PathVariable("id") int id) {

        AlunoRdn rdn = new AlunoRdn();
        return rdn.obterPorId(id);
    }
    
    @PostMapping("/alunos")
    public int Post(@RequestBody Aluno pcli) throws SQLException {

        AlunoRdn rdn = new AlunoRdn();
        return rdn.inserir(pcli);

    }
    
    @PutMapping("/alunos/{id}")
    public int Put(@PathVariable(value = "id") int id, @RequestBody Aluno pAluno) {
        AlunoRdn rdn = new AlunoRdn();
        if (rdn.obterPorId(id).getId() > 0) {
            int ret = rdn.alterar(pAluno);
            return ret;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno não encontrado");
        }
    }
   
    @DeleteMapping("/alunos/{id}")
    public int Delete(@PathVariable(value = "id") int id) {

        AlunoRdn rdn = new AlunoRdn();
        if (rdn.obterPorId(id).getId() > 0) {
            return rdn.deletar(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "aluno não encontrado");
        }
    }

    /*
     * @PutMapping("/cliente/{id}")
     * public int Put(@PathVariable(value = "id") int id, @RequestBody Cliente
     * cliente) {
     * 
     * AlunoRdn rdn = new AlunoRdn();
     * int retorno = 0;
     * 
     * if (rdn.obterPorId(id).getId() > 0) {
     * 
     * retorno = rdn.alterar(cliente);
     * 
     * } else {
     * 
     * throw new ResponseStatusException( HttpStatus.NOT_FOUND,
     * "cliente não encontrado");
     * }
     * return retorno;
     * 
     * }
     */

    /*
     * @PostMapping("/cliente")
     * public int Post(@RequestBody Cliente cliente) throws SQLException {
     * AlunoRdn rdn = new AlunoRdn();
     * int retorno = rdn.inserir(cliente);
     * 
     * return retorno;
     * }
     */

    /*
     * @PutMapping("/cliente/{id}")
     * public int Put(@PathVariable(value = "id") int id, @RequestBody Cliente
     * cliente) {
     * 
     * AlunoRdn rdn = new AlunoRdn();
     * int retorno = 0;
     * 
     * if (rdn.obterPorId(id).getId() > 0) {
     * 
     * retorno = rdn.alterar(cliente);
     * 
     * } else {
     * 
     * throw new ResponseStatusException( HttpStatus.NOT_FOUND,
     * "cliente não encontrado");
     * }
     * return retorno;
     * 
     * }
     */

    /*
     * @DeleteMapping("/cliente/{id}")
     * public int Delete(@PathVariable(value = "id") int id) {
     * AlunoRdn rdn = new AlunoRdn();
     * 
     * int retorno = 0;
     * 
     * if (rdn.obterPorId(id).getId() > 0) {
     * 
     * retorno = rdn.deletar(id);
     * 
     * } else {
     * 
     * throw new ResponseStatusException(HttpStatus.NOT_FOUND,
     * "cliente não encontrado");
     * }
     * return retorno;
     * }
     */

}