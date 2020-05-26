package com.raul.examen.examen.Domain;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema = "public",name = "cat_categoria")
public class Categoria {

    @Id
    @Column(name = "c_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCategoria;

    @Size(max = 30,message="El nombre no debe tener mas de 30 caracteres")
    @NotEmpty(message="Este campo no puede quedar vacio")
    @Column(name="s_categoria")
    private String categoria;

    @OneToMany(mappedBy = "categoria",fetch=FetchType.EAGER)
    private List<Libro> libros;

    public Categoria(){

    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
