package br.com.alwayspet.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "tb_responsavel")
public class Responsavel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max = 120)
    private String nome;
    @Email @NotBlank @Size(max = 140)
    private String email;
    @NotBlank @Size(max = 20)
    private String telefone;
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getTelefone(){return telefone;} public void setTelefone(String telefone){this.telefone=telefone;}
    public List<Pet> getPets(){return pets;} public void setPets(List<Pet> pets){this.pets=pets;}
}
