package com.vn.ejemplospring.demospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vn.ejemplospring.demospring.modelo.CuentaBanc;
import com.vn.ejemplospring.demospring.modelo.CuentasDAOpanama;

@RestController
@CrossOrigin(origins = "*")
public class ServicioBancarioREST {

	// Nosotros NO instanciamos, lo hace Spring
	// Nosotros NO gestionamos la dependencia, >>
	// Tampo asignamos el valor, >>
	// Esto es la inyección de dependencias
	@Autowired
	private CuentasDAOpanama repo;

	// Nos permite capturar varios médodos HTTP
	@RequestMapping(path = "/cuentas", method = { RequestMethod.POST /* , OTRO_METODO, ... */ })
	// Sólo el método POST
	// @PostMapping
	public CuentaBanc crearCuentaAingenuo(@RequestBody CuentaBanc cuenta) {

		System.out.println(">>> CuentaBanc recibida !" + cuenta.toString());
		return repo.save(cuenta);
	}

	@RequestMapping(path = "/cuentas", method = RequestMethod.GET)
	public List<CuentaBanc> obtenerTodas() {
		System.out.println(">>>> GET todas cuentas");
		return repo.findAll();
	}

	@DeleteMapping("/cuentas/{id}") // http://localhost:8080/cuentas/3
	public void eliminarCuenta(@PathVariable Integer id) {
		repo.deleteById(id);
		System.out.println(">>>> DELETE " + id);
	}
	// TODO:Hacer el PUT para modificar
	@PutMapping("/cuentas/{id}")
	public CuentaBanc modificarCuenta(
			@PathVariable Integer id,
			@RequestBody CuentaBanc cuentaModif) {
		
		if(cuentaModif.getId() == id) {
			repo.save(cuentaModif);
			System.out.println(">>>> Put/Modificar " + id);
			return repo.save(cuentaModif);
		}else {
			System.out.println(">>>> Put/Modificar " + id +
					" e " + cuentaModif.getId() + " no son iguales");
			return null;
		}
	}
	
}
