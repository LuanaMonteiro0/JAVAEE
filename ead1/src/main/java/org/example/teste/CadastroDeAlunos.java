//Nomes: Luan marqueti, Luana Monteiro

package org.example.teste;

import jakarta.persistence.EntityManager;
import org.example.dao.AlunoDAO;
import org.example.modelo.Aluno;
import org.example.util.JPAUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class CadastroDeAlunos {

    public static void main(String[] args) {

        SpringApplication.run(CadastroDeAlunos.class, args);

        int opcao = -1;
        Scanner leitor = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();

        AlunoDAO alunoDAO = new AlunoDAO(em);

        do {
            exibirMenu();
            System.out.println("Digite a opção desejada: ");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    Aluno a = alunoDAO.criarAluno();
                    em.getTransaction().begin();
                    alunoDAO.cadastrarAluno(a);
                    em.getTransaction().commit();
                    break;
                case 2:
                    Scanner leitor2 = new Scanner(System.in);
                    System.out.println("Digite o nome do aluno: ");
                    String nome = leitor2.nextLine();
                    Aluno b = alunoDAO.buscarAlunoPeloNome(nome);
                    if (b != null) {
                        em.getTransaction().begin();
                        alunoDAO.excluirAluno(b);
                        em.getTransaction().commit();
                    } else {
                        System.out.println("Nome não consta no sistema.");
                    }
                    break;
                case 3:
                    Scanner leitor3 = new Scanner(System.in);
                    System.out.println("Digite o nome do aluno: ");
                    String nome2 = leitor3.nextLine();
                    Aluno c = alunoDAO.buscarAlunoPeloNome(nome2);
                    if (c != null) {
                        em.getTransaction().begin();
                        alunoDAO.alterarAluno(c);
                        em.getTransaction().commit();
                    } else {
                        System.out.println("Nome não consta no sistema.");
                    }
                    break;
                case 4:
                    Scanner leitor4 = new Scanner(System.in);
                    System.out.println("Digite o nome do aluno: ");
                    String nome3 = leitor4.nextLine();
                    Aluno d = alunoDAO.buscarAlunoPeloNome(nome3);
                    if (d != null) {
                        d.exibirDados();
                    } else {
                        System.out.println("Nome não consta no sistema.");
                    }
                    break;
                case 5:
                    alunoDAO.listarAlunos();
                    break;
                case 6:
                    alunoDAO.listarAlunosComStatusAprovado();
                    break;
                case 7:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }
        while(opcao != 7);
        System.exit(0);
    }

    public static void exibirMenu() {
        System.out.println("\n** CADASTRO DE ALUNOS **\n");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Excluir aluno");
        System.out.println("3 - Alterar aluno");
        System.out.println("4 - Buscar aluno pelo nome");
        System.out.println("5 - Listar todos os alunos");
        System.out.println("6 - Listar alunos (com status aprovação)");
        System.out.println("7 - FIM");
    }


}
