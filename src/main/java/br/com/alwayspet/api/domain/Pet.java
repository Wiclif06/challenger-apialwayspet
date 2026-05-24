package br.com.alwayspet.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_pet")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max = 80)
    private String nome;
    @Enumerated(EnumType.STRING) @NotNull
    private Especie especie;
    @Size(max = 80)
    private String raca;
    @PastOrPresent
    private LocalDate dataNascimento;
    @ManyToOne(optional = false) @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alerta> alertas = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public Especie getEspecie(){return especie;} public void setEspecie(Especie especie){this.especie=especie;}
    public String getRaca(){return raca;} public void setRaca(String raca){this.raca=raca;}
    public LocalDate getDataNascimento(){return dataNascimento;} public void setDataNascimento(LocalDate dataNascimento){this.dataNascimento=dataNascimento;}
    public Responsavel getResponsavel(){return responsavel;} public void setResponsavel(Responsavel responsavel){this.responsavel=responsavel;}
    public List<Alerta> getAlertas(){return alertas;} public void setAlertas(List<Alerta> alertas){this.alertas=alertas;}
}
