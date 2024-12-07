package br.com.alura.screensound.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;
    @OneToMany(mappedBy = "artista", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Musica> musicas = new ArrayList<>();

    public Artista(String nome, TipoArtista tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Artista() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getListaMusicas() {
        return musicas;
    }

    @OneToMany(mappedBy = "artista")
    public void setListaMusicas(List<Musica> listaMusicas) {
        this.musicas = listaMusicas;
    }

    @Override
    public String toString() {
        return "Artista: " + nome + '\'' +
                ", Tipo: " + tipo +
                ", Lista de Musicas: " + musicas;
    }
}
