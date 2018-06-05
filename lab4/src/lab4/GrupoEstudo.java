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

	private HashSet<Aluno> integrantes;

	// **************** Construtor *********************

	/**
	 * Constrói o Grupo recebendo como parâmetros Strings com o nome e inicializa o
	 * HashSet que guarda objetos da classe Aluno.
	 * 
	 * @param nome
	 *            Nome do Grupo.
	 */
	public GrupoEstudo(String nome) {
		if (nome == null) {
			throw new NullPointerException();
		}
		if (nome.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		
		this.nome = nome.toLowerCase();
		integrantes = new HashSet<>();
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
	 * Método que adiciona um aluno no conjunton de integrantes do grupo.
	 * 
	 * @param integrante
	 *            É o novo aluno a ser adicionado.
	 */
	public void adicionaAluno(Aluno novoIntegrante) {
		integrantes.add(novoIntegrante);
	}

	/**
	 * Método retorna uma String em forma de lista com todos os integrantes do grupo
	 * e suas informações.
	 * 
	 * @return Lista com as informações dos integrantes do grupo.
	 */
	public String listaAlunos() {
		String listaDeAlunos = "";

		for (Aluno alumn : integrantes) {
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
		} 
		
		return false;
	}

}