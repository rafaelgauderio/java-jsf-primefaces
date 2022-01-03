package br.com.delucahigiene.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.delucahigiene.model.Pessoa;

@Named("bean")
@ConversationScoped //se clicar no botao parar a lista começa do zero novamente. Controla o inicio e fim da lista
public class PessoaMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//notação inject para gerenciar atraves do cdi (contexts and dependency injection)
	@Inject
	private Pessoa pessoa;
	
	@Inject
	private Conversation conversation;
	
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
		
		if(pessoas.isEmpty()) {
			conversation.begin();
		}
		
		pessoas.add(pessoa);
		limpar();
		
		return null;
		
		
	}
	
	private void limpar() {
		
		pessoa = new Pessoa();
	}
	
	public String parar() {
		conversation.end();
		
		return null;
	}
	
	
	

}
