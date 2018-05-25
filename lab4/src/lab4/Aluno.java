package lab4;

/**
 * Classe que representa um aluno, possui matícula, nome e curso. Cada aluno é
 * identificao pela sua matrícula.
 * 
 * @author Rafaela de Amorim - 117.210.299
 *
 */
public class Aluno {
	// **************** Atributos *********************
	private String matricula;

	private String nome;

	private String curso;

	// **************** Construtor *********************

	/**
	 * Constrói um objeto Aluno recebendo como parâmetros strings que são,
	 * respectivamente, a matrícula, o nome e o curso.
	 * 
	 * @param mat
	 *            Matrícula do Aluno.
	 * @param nome
	 *            Nome do Aluno.
	 * @param curso
	 *            Curso que o aluno estuda.
	 */
	public Aluno(String mat, String nome, String curso) {
		if (nome == null || mat == null || curso == null) {
			throw new NullPointerException();

		} else if (nome.trim().length() == 0) {
			throw new IllegalArgumentException();

		} else if (nome.trim().length() == 0) {
			throw new IllegalArgumentException();

		} else if (nome.trim().length() == 0) {
			throw new IllegalArgumentException();

		} else {
			this.matricula = mat;
			this.nome = nome;
			this.curso = curso;
		}
	}

	// **************** Métodos *********************
	/**
	 * Método que retorna uma String com o nome do Aluno.
	 * 
	 * @return String com o nome do Aluno.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que retorna uma String com a matrícula do Aluno.
	 * 
	 * @return String com a matrícula do Aluno.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Método que retorna uma String com o curso do Aluno.
	 * 
	 * @return String com o curso do Aluno.
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Método que retorna uma representação textual do aluno, contém, em ordem, sua
	 * matrículam seu nome e seu curso. A reprentação está na forma: 999 - NOME DO
	 * ALUNO - CURSO
	 * 
	 * @return String com as informações do aluno.
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}

	/**
	 * Método que gera um inteiro para cada Objeto Aluno. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Método que compara se um objeto é igual e este objeto Aluno. Dois Alunos são
	 * iguais se tiverem a mesma matrícula.
	 * 
	 * @return Retorna true, se forem iguais, senão, retorna false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Aluno) {
			Aluno novoAluno = (Aluno) obj;
			return getMatricula().equals(novoAluno.getMatricula());
		} else {
			return false;
		}
	}
}