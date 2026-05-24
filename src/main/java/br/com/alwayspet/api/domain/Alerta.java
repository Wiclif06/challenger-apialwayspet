package br.com.alwayspet.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_alerta")
public class Alerta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max = 100)
    private String titulo;
    @Size(max = 500)
    private String descricao;
    @FutureOrPresent
    private LocalDate dataPrevista;
    @Enumerated(EnumType.STRING)
    private StatusAlerta status = StatusAlerta.PENDENTE;
    @ManyToOne(optional = false) @JoinColumn(name = "pet_id")
    private Pet pet;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getTitulo(){return titulo;} public void setTitulo(String titulo){this.titulo=titulo;}
    public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
    public LocalDate getDataPrevista(){return dataPrevista;} public void setDataPrevista(LocalDate dataPrevista){this.dataPrevista=dataPrevista;}
    public StatusAlerta getStatus(){return status;} public void setStatus(StatusAlerta status){this.status=status;}
    public Pet getPet(){return pet;} public void setPet(Pet pet){this.pet=pet;}
}
