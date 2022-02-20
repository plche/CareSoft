package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioAdmin extends Usuario implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA {

	// Dentro de la clase:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    private int usuarioAdminPIN;
    
    // PARA HACER: Implementar un constructor que tome un ID y un rol
    public UsuarioAdmin(Integer employeeID, String role) {
    	super(employeeID.intValue());
    	this.employeeID = employeeID;
    	this.role = role;
    	securityIncidents = new ArrayList<String>();
    }
    
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
    @Override
    public boolean assignPIN(int usuarioAdminPIN) {
    	setUsuarioAdminPIN(usuarioAdminPIN);
    	return (usuarioAdminPIN >= 100000)? true : false;
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	boolean result = (usuarioAdminPIN == confirmedAuthID.intValue())? true : false;
    	if (!result) authIncident();
    	return result;
    }
    
    // PARA HACER: ¡Implementar AdminCompatibleConHIPAA
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	return getSecurityIncidents();
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
	public void authIncident() {
        String report = String.format(
            "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", 
            new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }

	// PARA HACER: Setters y Getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	public int getUsuarioAdminPIN() {
		return usuarioAdminPIN;
	}

	public void setUsuarioAdminPIN(int usuarioAdminPIN) {
		this.usuarioAdminPIN = usuarioAdminPIN;
	}
}
