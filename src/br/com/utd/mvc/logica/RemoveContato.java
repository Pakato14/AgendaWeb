package br.com.utd.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.utd.classes.Contato;
import br.com.utd.conexao.ContatoDao;

public class RemoveContato implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			long id = Long.parseLong(req.getParameter("id"));
			Contato contato = new Contato();
			contato.setId(id);
			ContatoDao dao = new ContatoDao();
			dao.exclui(contato);
			return "mvc?logica=ListaContatos";
			}

}
