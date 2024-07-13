package edu.cibertec.capitulo03th.dao.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Base64;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 20)
    private String usuario;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String clave;

    @Column(name = "nomCompleto")
    private String nombreCompleto;

    @Column
    private byte[] foto;

    @Transient
    private String fotoBase64;

    public UsuarioEntity() {
    }

    public UsuarioEntity(int id, String usuario, String clave,
                         String nombreCompleto) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFotoBase64() {
        String rpta = null;
        if (foto != null && foto.length > 0) {
            rpta = Base64.getEncoder().encodeToString(foto);
        }
        return rpta;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsuarioEntity{usuario=").append(usuario);
        sb.append(", clave=").append(clave);
        sb.append(", nombreCompleto=").append(nombreCompleto);
        sb.append('}');
        return sb.toString();
    }


}
