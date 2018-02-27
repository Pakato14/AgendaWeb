package br.com.utd.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.utd.classes.Contato;
import br.com.utd.conexao.ContatoDao;

@WebServlet("/adicionaContato")
public class AdicionaContato extends HttpServlet {
	@Override
	protected void service(HttpServletRequest chama, HttpServletResponse responde) throws ServletException, IOException {
		
		
		PrintWriter saida = responde.getWriter();
		
		//buscando parâmetros
		String nome = chama.getParameter("nome");
		String email = chama.getParameter("email");
		String telefone = chama.getParameter("phone");
		String dataEmTexto = chama.getParameter("date");
		Calendar dataNascimento = null;
		String cidade = chama.getParameter("cidade");
		
		try {
			Date data =	new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			} catch (ParseException e) {
			saida.println("Erro de conversão da data");
			return; //para a execução do método
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
				dao.adiciona(contato);
				
				// imprime o nome do contato que foi adicionado
				RequestDispatcher rd = chama
						.getRequestDispatcher("/contatoAdicionado.jsp");
						rd.forward(chama,responde);

	}

}
