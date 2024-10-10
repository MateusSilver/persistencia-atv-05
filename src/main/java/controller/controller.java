package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.ClientBanco;

@WebServlet(urlPatterns = { "/controller", "/main", "/insert", "/delete" })
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientBanco bd;
	private Candidato candidato;

	public controller() {
		super();
		try {
			this.bd = new ClientBanco();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Server at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			try {
				candidatos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("/insert")) {
			novocandidato(request, response);
		} else if (action.equals("/delete")) {
			deletecandidato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar contatos
	protected void candidatos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Candidato> lista;
		try {
			lista = bd.listarCandidatos();
		} catch (Exception e) {
			throw new Exception();
		}
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getCodigo());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getSexo());
			System.out.println(lista.get(i).getData_nasc());
			System.out.println(lista.get(i).getCargo_pretendido());
			System.out.println(lista.get(i).getTexto_curriculo());
		}
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("candidatos.jsp");
		rd.forward(request, response);
	}

	// insere contato
	protected void novocandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Random rand = new Random();
			candidato = new Candidato(rand.nextInt(1000), request.getParameter("nome"), request.getParameter("sexo"),
					request.getParameter("data_nasc"), request.getParameter("cargo_pretendido"),
					request.getParameter("texto_curriculo"));
			this.bd.PostCandidato(candidato);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	protected void deletecandidato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			bd.DeleteCandidato(Integer.parseInt(id));
			response.sendRedirect("main");
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
		}
	}
}
