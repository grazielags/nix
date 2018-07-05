package nix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPagadorNome() {
		return pagadorNome;
	}
	public void setPagadorNome(String pagadorNome) {
		this.pagadorNome = pagadorNome;
	}
	public String getPagadorBanco() {
		return pagadorBanco;
	}
	public void setPagadorBanco(String pagadorBanco) {
		this.pagadorBanco = pagadorBanco;
	}
	public String getPagadorAgencia() {
		return pagadorAgencia;
	}
	public void setPagadorAgencia(String pagadorAgencia) {
		this.pagadorAgencia = pagadorAgencia;
	}
	public String getPagadorConta() {
		return pagadorConta;
	}
	public void setPagadorConta(String pagadorConta) {
		this.pagadorConta = pagadorConta;
	}
	public String getBeneficiarioNome() {
		return beneficiarioNome;
	}
	public void setBeneficiarioNome(String beneficiarioNome) {
		this.beneficiarioNome = beneficiarioNome;
	}
	public String getBeneficiarioBanco() {
		return beneficiarioBanco;
	}
	public void setBeneficiarioBanco(String beneficiarioBanco) {
		this.beneficiarioBanco = beneficiarioBanco;
	}
	public String getBeneficiarioAgencia() {
		return beneficiarioAgencia;
	}
	public void setBeneficiarioAgencia(String beneficiarioAgencia) {
		this.beneficiarioAgencia = beneficiarioAgencia;
	}
	public String getBeneficiarioConta() {
		return beneficiarioConta;
	}
	public void setBeneficiarioConta(String beneficiarioConta) {
		this.beneficiarioConta = beneficiarioConta;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}
