package org.bwillard.ccsf.course.cs211s.assn5.guicode2.employee_mvc;

import java.awt.event.*;
import java.util.ArrayList;

/* the controller */
public class EmployeeProcessor {
	
	private Department salesDepartment;
	private EmployeeFrame display;
	
	public EmployeeProcessor(EmployeeFrame display, Department salesDepartment) {
		this.salesDepartment = salesDepartment;
		this.display = display;
		
		this.display.addAddEmployeeListener(new AddEmployeeListener());
		this.display.addRunPayrollListener(new RunPayrollListener());
		
	}
	
	public class AddEmployeeListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			String name = display.getName();
			String id = display.getID();
			Employee.PayType type = display.getPayType();
			Payer payer;
			if(type==Employee.PayType.SALARY) {
				payer = new SalaryPayer();
			} else {
				payer = new HourlyPayer();
			}
			
			Employee s = new Employee(name, id, payer);
			salesDepartment.addEmployee(s);
			
			display.clearInputs();
			display.updateDisplayOutput(salesDepartment.toString());
		}
	}
	
	public class RunPayrollListener implements ActionListener {
		public void actionPerformed(ActionEvent evvent) {
			display.updateDisplayOutput(salesDepartment.runPayroll());
		}
	}
	

}
