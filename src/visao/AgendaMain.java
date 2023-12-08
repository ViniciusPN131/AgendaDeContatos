package visao;

import java.util.Scanner;

import controle.AgendaDAO;
import modelo.Agenda;

public class AgendaMain {

	static AgendaDAO aDAO = AgendaDAO.getInstancia();

	public static int opc = 1;

	public static void main(String[] args) {

		while (opc != 0) {
			menuInicial();

			switch (opc) {
			case 1: {
				Agenda contato = adicionarContato();
						
				if(contato!=null) {
					aDAO.adicionarContato(contato);
					System.out.println("Contato adicionado com sucesso!");
				}else {
					System.out.println("Valores inseridos invalidos!");
				}
			}
				break;
			case 2: {
				Agenda contato = adicionarContato();
				
				if(contato!=null) {
					aDAO.removerContato(contato);
					System.out.println("Contato removido com sucesso!");
				}else {
					System.out.println("Valores inseridos invalidos!");
				}
			}
				break;
			case 3: {

			}
				break;
			case 4: {
				aDAO.listaContatos();
			}
				break;
			}
		}

	}

//----------------------------MENUS-------------------------------------------------------
	public static Integer menuInicial() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("----------Bem Vindo a Agenda----------");
		System.out.println();
		System.out.println("como deseja continuar?");
		System.out.println("0-sair");
		System.out.println("1-Adicionar contato");
		System.out.println("2-Remover");
		System.out.println("3-Alterar umn contato");
		System.out.println("4-listar contatos");
		opc = leitura.nextInt();

		return opc;

	}
//-----------------------------METODOS------------------------------------------------------------
	
	public static Agenda adicionarContato() {
		Scanner leitura = new Scanner(System.in);
		Agenda contato = new Agenda();
		System.out.println("Digite o nome do contato: ");
		contato.setNome(leitura.nextLine());
		System.out.println("Digite o numero do contato: ");
		contato.setNumero(leitura.nextLong());
		if(contato.getNome()!=null&&contato.getNumero()!=null) {
			return contato;
		}
		return null;
		
	}
	public static Agenda removerContato() {
		Scanner leitura = new Scanner(System.in);
		Agenda contato = new Agenda();
		
		System.out.println("Digite nome do contato a ser excluido: ");
		contato.setNome(leitura.nextLine());
		System.out.println("Digite o numero do contato a ser deletado: ");
		contato.setNumero(leitura.nextLong());
		if(contato.getNome()!=null&&contato.getNumero()!=null) {
			return contato;
		}
		return null;
		
	}
	
}
