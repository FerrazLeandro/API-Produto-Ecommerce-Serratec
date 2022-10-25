package org.br.serratec.dto;

import java.util.HashSet;
import java.util.Set;

import org.br.serratec.domain.Perfil;
import org.br.serratec.domain.Usuario;
import org.br.serratec.domain.UsuarioPerfil;

import io.swagger.annotations.ApiModelProperty;


public class UsuarioDto {
	@ApiModelProperty(value="Identificador único do usuário")
    private Long id;
	@ApiModelProperty(value="Nome do usuário")
    private String nome;
	@ApiModelProperty(value="E-mail do usuário")
    private String email;
	@ApiModelProperty(value="Perfis do usuário")
    private Set<Perfil> perfis;

    public UsuarioDto(Long id, String nome, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public UsuarioDto() {
        super();
    }
    public UsuarioDto(Usuario usuario) {
        super();
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.perfis = new HashSet<>();
        for(UsuarioPerfil usuarioPerfil:usuario.getUsuarioPerfis()) {
            this.perfis.add(usuarioPerfil.getPerfil());
        }
    }

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Perfil> getPerfis() {
        return perfis;
    }
    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}
