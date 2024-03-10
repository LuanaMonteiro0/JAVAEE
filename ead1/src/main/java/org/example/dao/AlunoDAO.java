//Nomes: Luan marqueti, Luana Monteiro

package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoDAO {

    private EntityManager em;

    public AlunoDAO(EntityManager em) {
        this.em = em;
    }
    public Aluno criarAluno() {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Dados do Aluno:");
        System.out.println("Digite o nome: ");
        String n = leitor.nextLine();
        System.out.println("Digite o ra: ");
        String r = leitor.nextLine();
        System.out.println("Digite o email: ");
        String e = leitor.nextLine();
        System.out.println("Digite o nota1: ");
        double n1 = leitor.nextDouble();
        System.out.println("Digite o nota2: ");
        double n2 = leitor.nextDouble();
        System.out.println("Digite o nota3: ");
        double n3 = leitor.nextDouble();

        Aluno a = new Aluno(n, r, e, n1, n2, n3);
        return a;
    }
    public void cadastrarAluno(Aluno aluno) {
        this.em.persist(aluno);
    }

    public void excluirAluno(Aluno aluno) {
        this.em.remove(aluno);
    }

    public void alterarAluno(Aluno a) {

        a.exibirDados();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Novos dados");
        System.out.println("Digite o nome: ");
        a.setNome(leitor.nextLine());
        System.out.println("Digite o ra: ");
        a.setRa(leitor.nextLine());
        System.out.println("Digite o email: ");
        a.setEmail(leitor.nextLine());
        System.out.println("Digite o nota1: ");
        a.setNota1(leitor.nextDouble());
        System.out.println("Digite o nota2: ");
        a.setNota2(leitor.nextDouble());
        System.out.println("Digite o nota3: ");
        a.setNota3(leitor.nextDouble());

    }


    public Aluno buscarAlunoPeloNome(String nome) {
        String dados = "SELECT a FROM Aluno a WHERE a.nome = :nomeAluno";
        try {
            return this.em.createQuery(dados, Aluno.class).setParameter("nomeAluno", nome).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public void listarAlunosComStatusAprovado() {

        String jpql = "SELECT a FROM Aluno a";
        List<Aluno> lista = new ArrayList<>();
        lista = this.em.createQuery(jpql, Aluno.class).getResultList();
        for (Aluno aluno : lista) {
            if (aluno.verificarSeAlunoFoiAprovado().compareTo("Situação: Aprovado") == 0) {
                aluno.exibirDados();
                aluno.exibirMedia();
                System.out.println(aluno.verificarSeAlunoFoiAprovado());
            }
        }

    }

    public void listarAlunos(){

        String jpql = "SELECT a FROM Aluno a";
        List<Aluno> lista = new ArrayList<>();
        lista = this.em.createQuery(jpql, Aluno.class).getResultList();
        for (Aluno aluno : lista) {
            aluno.exibirDados();
            aluno.exibirMedia();
            System.out.println(aluno.verificarSeAlunoFoiAprovado());
        }

    }

}