package com.meatapp.enums;

public enum PaymentOptions {

	MON("MON","Dinheiro"),
	DEB("DEB","Cartão de Crédito"),
	REF("REF","Cartão de Refeição");
    
	private String label;
	private String value;
	
    PaymentOptions(String value, String label ){
    	this.value = value;
    	this.label = label;
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static PaymentOptions toEnum(String label) {
		
		if (label == null) {
			return null;
		}
		
		for (PaymentOptions x : PaymentOptions.values()) {
			if (label.equals(x.getValue())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + label);
	}
}
