package controle;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Agenda;
import modelo.IAgendaDAO;

public class AgendaDAO implements IAgendaDAO {

	private static ArrayList<Agenda> listaContatos;
	private static AgendaDAO instancia;

	private AgendaDAO() {
	}

	public static AgendaDAO getInstancia() {
		if (instancia == null) {
			instancia = new AgendaDAO();
			listaContatos = new ArrayList<>();
		}
		return instancia;
	}

	@Override
	public boolean adicionarContato(Agenda contato) {
		if (contato != null) {
			listaContatos.add(contato);
			return true;
		}
		return false;
	}

	@Override
	public boolean removerContato(Agenda contato) {
		for (Agenda agenda : listaContatos) {
			if (contato.equals(agenda)) {
				listaContatos.remove(contato);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean editarContato(Agenda contato, String nome, Long numero) {
		for (Agenda agenda : listaContatos) {
			if (agenda.getNome().equals(nome)) {
				if (nome != null) {
					agenda.setNome(nome);
				}
				if (numero != null) {
					agenda.setNumero(numero);
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Agenda> listaContatos() {
		System.out.println("-----Lista de contatos-----");
		if (listaContatos.isEmpty()) {
			System.out.println("Lista de contatos vazia!");
		} else {
			for (Agenda agenda : listaContatos) {
				System.out.println("Nome: " + agenda.getNome());
				System.out.println("Numero: " + agenda.getNumero());
			}
		}
		return null;
	}

}
