package br.com.rompi.cliente.adapters.out.repository.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "client")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false, updatable=false)
    private long id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
}
