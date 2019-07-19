package br.up.cadastronoivos.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ClienteNoivos {

	@Id
	@SequenceGenerator(name = "CONTADOR_NOIVOS", sequenceName = "NUM_SEQ_NOIVOS", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_NOIVOS")
	private Integer id;

	@NotNull
	private String noivos;

	@NotNull
	private String salao;

	@NotNull
	private String localCerimonia;

	@NotNull
	private Date data;

	@NotNull
	private String telefone;

	@NotNull
	private String tipoContratação;

	@NotNull
	@DecimalMin (value = "5200", message = "Valor minimo do contrato é de R$5.200,00")
	private Double valorContrato;

	@NotNull
	private String valorPago;

	@NotNull
	@Min (value = 100)
	@Max (value = 200)
	private Integer numeroDeConvidados;

	public ClienteNoivos() {

	}

	public Integer getNumeroDeConvidados() {
		return numeroDeConvidados;
	}

	public void setNumeroDeConvidados(Integer numeroDeConvidados) {
		this.numeroDeConvidados = numeroDeConvidados;
	}

	public String getNoivo() {
		return getNoivos();
	}

	public void setNoivo(String noivos) {
		this.setNoivos(noivos);
	}

	public String getSalao() {
		return salao;
	}

	public String getLocalCerimonia() {
		return localCerimonia;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getTipoContratação() {
		return tipoContratação;
	}

	public Double getValorContrato() {
		return valorContrato;
	}

	public String getValorPago() {
		return valorPago;
	}

	public void setSalao(String salao) {
		this.salao = salao;
	}

	public void setLocalCerimonia(String localCerimonia) {
		this.localCerimonia = localCerimonia;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTipoContratação(String tipoContratação) {
		this.tipoContratação = tipoContratação;
	}

	public void setValorContrato(Double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNoivos() {
		return noivos;
	}

	public void setNoivos(String noivos) {
		this.noivos = noivos;
	}

}
