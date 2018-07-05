package nix.api.dto;

public class TransferenciaDTO {

	private Integer id;
    private UsuarioDTO usuario;
    private String pagadorNome;
    private String pagadorBanco;
    private String pagadorAgencia;
    private String pagadorConta;
    private String beneficiarioNome;
    private String beneficiarioBanco;
    private String beneficiarioAgencia;
    private String beneficiarioConta;
    private Double valor;
    private String tipo;
    private String status;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
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
