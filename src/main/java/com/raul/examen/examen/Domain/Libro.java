package com.raul.examen.examen.Domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(schema = "public",name="cat_libro")
public class Libro {

    @Id
    @Column(name = "c_libro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoLibro;

    @Column(name = "s_titulo")
    private String titulo;

    @Column(name = "s_autor")
    private String autor;

    @Column(name = "f_ingreso")
    private Date fecha;

    @Column(name = "b_estado")
    private Boolean estado;

    @Column(name = "s_isbn")
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public Libro() {
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
