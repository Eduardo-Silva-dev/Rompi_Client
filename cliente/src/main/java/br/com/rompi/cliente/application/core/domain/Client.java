package br.com.rompi.cliente.application.core.domain;

public class Client {

    private long id;

    private String nome;

    private String sobrenome;

    private Address address;

    public Client() {
    }

    public Client(long id, String nome, String sobrenome, Address address) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
