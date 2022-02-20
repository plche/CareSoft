package com.caresoft.clinicapp;

public interface UsuarioCompatibleConHIPAA {
	abstract boolean assignPIN(int PIN);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}
