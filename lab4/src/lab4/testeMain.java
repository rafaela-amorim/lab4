package lab4;

import java.util.HashMap;

public class testeMain {

	public static void main(String[] args) {
		HashMap<String, Aluno> alunos = new HashMap<>();
		
		Aluno eu = new Aluno("12345", "Rafa", "cc");
		alunos.put(eu.getMatricula(), eu);
		
		Aluno euzes = new Aluno("12345", "bunda", "cc");
		alunos.put(euzes.getMatricula(), euzes);
		
		System.out.println(alunos);
	}

}
