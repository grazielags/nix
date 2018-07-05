package com.sctrcd.multidsdemo.usuario.domain;

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

@Table(name="usuario", schema="public")
public class Usuario {

	@Id
    @SequenceGenerator(allocationSize = 1, name = "seq_usuario", sequenceName = "seq_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @Column(name="id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

}
