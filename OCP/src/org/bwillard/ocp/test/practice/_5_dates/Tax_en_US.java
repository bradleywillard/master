package org.bwillard.ocp.test.practice._5_dates;

import java.util.Locale;
import java.util.ResourceBundle;


public class Tax_en_US extends java.util.ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { {"tax", new UsTaxCode()} };
	}
	
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("resourceBundle.tax", Locale.US);
		System.out.println(rb.getObject("tax"));
	}
	
	class UsTaxCode {
		
	}

}
