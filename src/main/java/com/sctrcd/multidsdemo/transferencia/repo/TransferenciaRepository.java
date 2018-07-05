package com.sctrcd.multidsdemo.transferencia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sctrcd.multidsdemo.transferencia.domain.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
