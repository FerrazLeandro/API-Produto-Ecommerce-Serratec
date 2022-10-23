package org.br.serratec.repository;

import org.br.serratec.domain.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long> {

}
