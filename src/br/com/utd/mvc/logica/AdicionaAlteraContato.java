package br.com.utd.mvc.logica;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.utd.classes.Contato;
import br.com.utd.conexao.ContatoDao;

public class AdicionaAlteraContato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Long id = null;
		String idNumber = req.getParameter("id");
		if(idNumber != null){
			id = Long.parseLong(idNumber);
			}
		PrintWriter saida = res.getWriter();
		
		//buscando parâmetros
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String telefone = req.getParameter("phone");
		String dataEmTexto = req.getParameter("date");
		Calendar dataNascimento = null;
		String cidade = req.getParameter("cidade");
		
		try {
			Date data =	new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			} catch (ParseException e) {
			saida.println("Erro de conversão da data");
		}
		// monta um objeto contato
				Contato contato = new Contato();
				contato.setNome(nome);
				contato.setEmail(email);
				contato.setTelefone(telefone);
				contato.setDataNascimento(dataNascimento);
				contato.setCidade(cidade);
				
				// salva o contato
				ContatoDao dao = new ContatoDao();
				
				if (id != null ) {
				     contato.setId(id);
				     dao.altera(contato);
				     /*RequestDispatcher rd = req.getRequestDispatcher("/contatoAlterado.jsp");
								rd.forward(req,res);*/
				      }else{
				      dao.adiciona(contato);
				   // imprime o nome do contato que foi adicionado
						/*RequestDispatcher rd = req.getRequestDispatcher("/contatoAdicionado.jsp");
								rd.forward(req,res);*/
				      }
				
		return "mvc?logica=ListaContatos";
	}

}
