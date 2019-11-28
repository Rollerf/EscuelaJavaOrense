"use strict";
var lenguaje = "JavaScript";
var textoExtra = " con Tipado fuerte OPCIONAL";
console.log("TypeScript es " + lenguaje + textoExtra);
var UnaClase{
	constructor(private propiedad:String){
		
	}
	public getPropiedad() : String {
		return this.propiedad;
	}
	
}
let unObjeto: UnaClase = new UnaClase("Tiene POO");
textoExtra = 2000;
console.log ("   " + unObj.getPropiedades());
