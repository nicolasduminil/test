package eu.srb.test;

import java.io.Serializable;
import java.util.HashMap;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AccountBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private float amount;
	private String msg;
	private HashMap<String, Float> accountAmountPairs = new HashMap<String, Float>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getMsg() {
		return msg;
	}

	public void deposit() {
		float theSum = amount;
		if (accountAmountPairs.containsKey(name)) {
			theSum = accountAmountPairs.get(name).floatValue() + theSum;
		}
		accountAmountPairs.put(name, Float.valueOf(theSum));
		msg = "The money have been deposited to " + name + ", the balance of the account is " + theSum;
	}
}
