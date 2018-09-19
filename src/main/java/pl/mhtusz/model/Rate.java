package pl.mhtusz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String currency;
	private String code;
	private Double mid;

	public Rate() {}
	
	@Override
	public String toString() {
		return "Rate [id=" + id + ", currency=" + currency + ", code=" + code + ", mid=" + mid + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getMid() {
		return mid;
	}
	public void setMid(Double mid) {
		this.mid = mid;
	}
	
	
	
}
