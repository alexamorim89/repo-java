package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Aluno;

public class Program {

	/*
	 * Em um portal de cursos online, cada usuário possui um código único,
	 * representado por um número inteiro. Cada instrutor do portal pode ter vários
	 * cursos, sendo que um mesmo aluno pode se matricular em quantos cursos quiser.
	 * Assim, o número total de alunos de um instrutor não é simplesmente a soma dos
	 * alunos de todos os cursos que ele possui, pois pode haver alunos repetidos em
	 * mais de um curso. O instrutor Alex possui três cursos A, B e C, e deseja
	 * saber seu número total de alunos. Seu programa deve ler os alunos dos cursos
	 * A, B e C do instrutor Alex, depois mostrar a quantidade total e alunos dele,
	 * conforme exemplo
	 * 
	 * EXEMPLO:
	 * 	Quantos alunos para o curso A? 3
		21
		35
		22
		Quantos alunos para o curso B? 2
		21
		50
		Quantos alunos para o curso C? 3
		42
		35
		13
		Total de alunos: 6
	 * 
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Aluno> set = new HashSet<Aluno>();
		
		System.out.print("Quantos alunos para o curso A? ");
		int quantidadeA = sc.nextInt();
		for (int i = 0; i < quantidadeA; i++) {
			int codigo = sc.nextInt();
			set.add(new Aluno(codigo));
		}
		
		System.out.print("Quantos alunos para o curso B? ");
		int quantidadeB = sc.nextInt();
		for (int i = 0; i < quantidadeB; i++) {
			int codigo = sc.nextInt();
			set.add(new Aluno(codigo));
		}
		
		System.out.print("Quantos alunos para o curso C? ");
		int quantidadeC = sc.nextInt();
		for (int i = 0; i < quantidadeC; i++) {
			int codigo = sc.nextInt();
			set.add(new Aluno(codigo));
		}
		System.out.print("Total de alunos: " + set.size());			
		
		sc.close();
	}
}