package com.sctrcd.multidsdemo.transferencia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="transferencia", schema="public")
public class Transferencia {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_transferencia", sequenceName = "seq_transferencia")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
    @Column(name="id")
    private Integer id;
//    private Usuario usuario;
    @Column(name="pagador_nome")
    private String pagadorNome;
    @Column(name="pagador_banco")
    private String pagadorBanco;
    @Column(name="pagador_agencia")
    private String pagadorAgencia;
    @Column(name="pagador_conta")
    private String pagadorConta;
    @Column(name="beneficiario_nome")
    private String beneficiarioNome;
    @Column(name="beneficiario_banco")
    private String beneficiarioBanco;
    @Column(name="beneficiario_agencia")
    private String beneficiarioAgencia;
    @Column(name="beneficiario_conta")
    private String beneficiarioConta;
    @Column
    private Double valor;
    @Column
    private String tipo;
    @Column
    private String status;

}
