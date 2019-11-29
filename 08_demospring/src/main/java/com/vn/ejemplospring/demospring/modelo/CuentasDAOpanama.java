package com.vn.ejemplospring.demospring.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasDAOpanama 
	extends JpaRepository<CuentaBanc, Integer>{
	
	// List<CuentaBanc> findByIban();
}
