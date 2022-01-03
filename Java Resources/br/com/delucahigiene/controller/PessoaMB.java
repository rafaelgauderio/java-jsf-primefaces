package br.com.delucahigiene.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.delucahigiene.model.Pessoa;

@Named("bean")
@ApplicationScoped //scope que é compartilhado entre os usuários
public class PessoaMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//notação inject para gerenciar atraves do cdi (contexts and dependency injection)
	@Inject
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas = new ArrayList<>();	
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String adicionar() {
		
		pessoas.add(pessoa);
		limpar();
		
		return null;
		
		
	}
	
	private void limpar() {
		
		pessoa = new Pessoa();
	}
	
	
	

}
