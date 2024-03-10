//Nomes: Luan marqueti, Luana Monteiro

package org.example.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ra;
    private String email;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno() {
    }

    public Aluno(String nome, String ra, String email, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public void exibirDados(){
        System.out.println("Dados do aluno");
        System.out.println("Nome: " + this.nome);
        System.out.println("RA: " + this.ra);
        System.out.println("Email: " + this.email);
        System.out.println("Notas: " + this.nota1 + " - " + this.nota2 + " - " + this.nota3);
    }

    public String verificarSeAlunoFoiAprovado() {
        double media = (this.nota1 + this.nota2 + this.nota3) / 3;
        if (media < 4.0) {
            return "Situação: Reprovado";
        } else {
            if (media >= 4.0 && media < 6.0) {
                return "Situação: Recuperação";
            }
            return "Situação: Aprovado";
        }
    }
    public void exibirMedia() {
        double media = (this.nota1 + this.nota2 + this.nota3) / 3;
        System.out.println("Media: " + Math.round(media));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
}
