package br.com.rompi.cliente.adapters.out.repository.entity;

import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "address")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, updatable=false)
    private long id;
    @Column
    private String cep;
    @Column
    private String logradouro;
    @Column
    private String bairro;
    @Column
    private String localidade;
    @Column
    private String uf;
}
