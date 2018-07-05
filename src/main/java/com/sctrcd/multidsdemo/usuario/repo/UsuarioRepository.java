package com.sctrcd.multidsdemo.usuario.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sctrcd.multidsdemo.usuario.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
