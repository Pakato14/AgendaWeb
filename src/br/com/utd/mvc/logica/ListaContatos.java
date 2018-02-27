package br.com.utd.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.utd.classes.Contato;
import br.com.utd.conexao.ContatoDao;

public class ListaContatos implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Contato> contatos = new ContatoDao().getLista();
		req.setAttribute("contatos", contatos);
		return "listaContatos.jsp";
	}

}
