package lab4;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	static Sistema sis = new Sistema();
	
	// auxiliares
	static String mat;	
	
	static String nomeAluno;
	
	static String curso;
	
	static String nomeGrupo;
	
	static char option;
	
	// *********
	
	public static void main(String[] args) {
		
		boolean keepGoing = true;
		
		while (keepGoing) {
			
			opcoesIniciais();
						
			switch (option) {
			case 'C':
				cadastraAluno();
				break;
			
			case 'E':
				exibeAluno();
				break;
			
			case 'N':
				novoGrupo();
				break;
				
			case 'A':
				alocaOuImprime();				
				break;
				
			case 'R':
				respondeuQuestao();
				break;
			
			case 'I':
				listaQuemRespondeu();
				break;
			
			case 'O':
				keepGoing = false;
				break;
			
			default:
				System.out.println("OPÇÃO INVÁLIDA!\n");
				break;
			}
		}
	}
	
	// *******
	
	/**
	 * Método para cadastrar Aluno no Sistema.
	 */
	private static void cadastraAluno() {
		System.out.println("Matrícula: ");
		mat = in.nextLine();
		
		System.out.println("Nome: ");
		nomeAluno = in.nextLine();
		
		System.out.println("Curso: ");
		curso = in.nextLine();
		
		System.out.println(sis.cadastraAluno(mat, nomeAluno, curso) + System.lineSeparator());
	}
	
	/**
	 * Exibe Aluno de acordo com a matrícula passada, se a matrícula estiver cadastrada.
	 */
	private static void exibeAluno() {
		System.out.println("Matrícula: ");
		mat = in.nextLine();
		
		System.out.println(sis.buscaAluno(mat) + System.lineSeparator());
	}
	
	/**
	 * Cadastra novo Grupo de Estudo no sistema
	 */
	private static void novoGrupo() {
		System.out.println("Grupo: ");
		nomeGrupo = in.nextLine();
		
		System.out.println(sis.cadastraGrupo(nomeGrupo) + System.lineSeparator());
	}
	
	/**
	 * Aloca um aluno já cadastrado em um Grupo de Estudo também já cadastrado.
	 */
	private static void alocaAluno() { 
		System.out.println("Matrícula: ");
		mat = in.nextLine();
		
		System.out.println("Grupo: ");
		nomeGrupo = in.nextLine();
		
		System.out.println(sis.alocaAlunoEmGrupo(mat, nomeGrupo) + System.lineSeparator());
	}
	
	/**
	 * Imprime os integrantes de um Grupo de Estudo já cadastrado.
	 */
	private static void imprimeGrupo() {
		System.out.println("Grupo: ");
		nomeGrupo = in.nextLine();
		
		System.out.println(sis.imprimeGrupo(nomeGrupo) + System.lineSeparator());
	}
	
	/**
	 * Oferece ao usuário as opções de alocar um Aluno em um Grupo ou Imprimir Grupo.
	 */
	private static void alocaOuImprime() {
		boolean go = true;
		
		while (go) {
			System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
			option = in.next().toUpperCase().charAt(0);
			in.nextLine();
			
			switch (option) {
			case 'A':
				alocaAluno();
				go = false;
				break;
			case 'I':
				imprimeGrupo();
				go = false;
				break;
			
			default:
				System.out.println("OPÇÃO INVÁLIDA\n");
				break;
			}
		}
	}
	
	/**
	 * Adiciona Aluno à lista de quem respondeu questões.
	 */
	private static void respondeuQuestao() {
		System.out.println("Matrícula: ");
		mat = in.nextLine();
		
		System.out.println(sis.respondeQuestao(mat) + System.lineSeparator());
	}
	
	/**
	 * Lista as informações dos Alunos que responderam questões.
	 */
	private static void listaQuemRespondeu() {
		System.out.println(sis.listaQuemRespondeu() + System.lineSeparator());
	}
	
	/**
	 * Exibe as opções iniciais do Menu.
	 */
	private static void opcoesIniciais() {
		System.out.println("(C)adastrar Aluno" + System.lineSeparator() +
				   		   "(E)xibir Aluno" + System.lineSeparator() +
				   		   "(N)ovo Grupo" + System.lineSeparator() +
				   		   "(A)locar Aluno no Grupo e Imprimir Grupos" + System.lineSeparator() +
				   		   "(R)egistrar Aluno que Respondeu" + System.lineSeparator() +
				   		   "(I)mprimir Alunos que Responderam" + System.lineSeparator() +
				   		   "(O)ra, vamos fechar o programa!" + System.lineSeparator());

		System.out.println("Opção> ");
		option = in.next().toUpperCase().charAt(0);
		in.nextLine();
	}
}
