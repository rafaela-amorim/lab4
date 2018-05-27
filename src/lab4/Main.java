package lab4;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Sistema sis = new Sistema();
		
		// Próprios do main
		
		boolean keepGoing = true;
		
		boolean go;	// aux
		
		char option;
		
		// auxiliares
		String mat;	
		
		String nomeAluno;
		
		String curso;
		
		String nomeGrupo;
		
		//*********
		
		while (keepGoing) {
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
			
			go = true;
			
			switch (option) {
			case 'C':
				System.out.println("Matrícula: ");
				mat = in.nextLine();
				
				System.out.println("Nome: ");
				nomeAluno = in.nextLine();
				
				System.out.println("Curso: ");
				curso = in.nextLine();
				
				System.out.println(sis.cadastraAluno(mat, nomeAluno, curso) + System.lineSeparator());
				break;
			
			case 'E':
				System.out.println("Matrícula: ");
				mat = in.nextLine();
				
				System.out.println(sis.buscaAluno(mat) + System.lineSeparator());
				break;
			
			case 'N':
				System.out.println("Grupo: ");
				nomeGrupo = in.nextLine();
				
				System.out.println(sis.cadastraGrupo(nomeGrupo) + System.lineSeparator());
				break;
				
			case 'A':
				while (go) {
					System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
					option = in.next().toUpperCase().charAt(0);
					in.nextLine();
					
					switch (option) {
					case 'A':
						System.out.println("Matrícula: ");
						mat = in.nextLine();
						
						System.out.println("Grupo: ");
						nomeGrupo = in.nextLine();
						
						System.out.println(sis.alocaAlunoEmGrupo(mat, nomeGrupo) + System.lineSeparator());
						
						go = false;
						break;
						
					case 'I':
						System.out.println("Grupo: ");
						nomeGrupo = in.nextLine();
						
						System.out.println(sis.imprimeGrupo(nomeGrupo) + System.lineSeparator());
						
						go = false;
						break;
					
					default:
						System.out.println("OPÇÃO INVÁLIDA\n");
						break;
					}
				}
				
				break;
				
			case 'R':
				System.out.println("Matrícula: ");
				mat = in.nextLine();
				
				System.out.println(sis.respondeQuestao(mat) + System.lineSeparator());
				break;
			
			case 'I':
				System.out.println(sis.listaQuemRespondeu() + System.lineSeparator());
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

}

