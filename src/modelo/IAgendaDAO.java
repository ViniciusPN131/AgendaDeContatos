package modelo;

import java.util.ArrayList;

public interface IAgendaDAO {
	
	public boolean adicionarContato(Agenda contato);
	
	public boolean removerContato(Agenda contato);
	
	public boolean editarContato(Agenda contato, String nome, Long numero);
	
	public ArrayList<Agenda> listaContatos();
	
}
