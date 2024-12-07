package br.com.alura.screensound.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Artista artista;

    private String titulo;

    public Musica(String tituloMusica) {
        this.titulo = tituloMusica;
    }

    public Musica() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }



    @Override
    public String toString() {
        return "Musica: " + titulo +
                ", Artista: " + artista.getNome();
    }
}
