package lab4;

import java.util.HashSet;

/**
 * Essa classe representa um Grupo de Estudos que possui um nome, um tema e um
 * conjunto de integrantes, representados por objetos da classe Aluno.
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class GrupoEstudo {
	// **************** Atributos *********************
	private String nome;

	private String tema;

	private HashSet<Aluno> integrantes;

	// **************** Construtor *********************

	/**
	 * Constrói o Grupo recebendo como parâmetros Strings com, respectivamente, o
	 * nome e o tema do grupo, e inicializa o HashSet que guarda objetos da classe
	 * Aluno.
	 * 
	 * @param nome
	 *            Nome do Grupo.
	 * @param tema
	 *            Tema do Grupo.
	 */
	public GrupoEstudo(String nome, String tema) {
		if (nome == null || tema == null) {
			throw new NullPointerException();

		} else if (nome.trim().length() == 0) {
			throw new IllegalArgumentException();

		} else if (tema.trim().length() == 0) {
			throw new IllegalArgumentException();

		} else {
			this.nome = nome.toLowerCase();
			this.tema = tema;
			integrantes = new HashSet<>();
		}
	}

	// **************** Métodos *********************

	/**
	 * Método que retorna o nome do Grupo.
	 * 
	 * @return String com o nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que retorna o tema do Grupo.
	 * 
	 * @return String com o tema.
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Método que adiciona um aluno no conjunton de integrantes do grupo.
	 * 
	 * @param integrante
	 *            É o novo aluno a ser adicionado.
	 */
	public void adicionaAluno(Aluno novoIntegrante) {
		integrantes.add(novoIntegrante);
	}
	
	public String listaAlunos() {
		String listaDeAlunos = "";
		
		for (Aluno alumn: integrantes) {
			listaDeAlunos += "* " + alumn.toString() + System.lineSeparator();
		}
		
		return listaDeAlunos.trim();
	}
	/**
	 * Método que gera um inteiro para representar o objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método que compara se um objeto é igual a este objeto de GrupoEstudo. Dois
	 * objetos GrupoEstudo são iguais se possuírem o mesmo nome.]
	 * 
	 * @return Retorna true se os objetos forem iguais, senão, retorna false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GrupoEstudo) {
			GrupoEstudo grupo = (GrupoEstudo) obj;
			return getNome().equals(grupo.getNome());
		} else {
			return false;
		}
	}

}