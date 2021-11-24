package pension.managment.system2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pension_details")
public class PensionDetails implements Serializable  {

	private static final long serialVersionUID = 1173511369703296438L;

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pensioner_id;
	
	@Column
	private double amount;
	
	@Column
	private double charges;
	
	@Column
	private String bankType;
	
	@Column
	private int statusCode;
	
	public PensionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PensionDetails(int pensioner_id, double amount, double charges, String bankType, int statusCode) {
		super();
		this.pensioner_id = pensioner_id;
		this.amount = amount;
		this.charges = charges;
		this.bankType = bankType;
		this.statusCode = statusCode;
	}

	public int getPensioner_id() {
		return pensioner_id;
	}

	public void setPensioner_id(int pensioner_id) {
		this.pensioner_id = pensioner_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "pensionDetails [pensioner_id=" + pensioner_id + ", amount=" + amount + ", charges=" + charges
				+ ", bankType=" + bankType + ", statusCode=" + statusCode + "]";
	}
	
	
	
}
