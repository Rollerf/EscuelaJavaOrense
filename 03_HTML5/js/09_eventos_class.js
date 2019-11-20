//Manera EcmaScript 5
function GestorEventosES5(inputId,btnId, divInfoId){
    this.input = document.getElementById(inputId);
    this.boton = document.getElementById(btnId);
    this.divInfo = document.getElementById(divInfoId);

    this.funCallbkAlPulsar = function(evento){
        this.input.value = "Tipo Evento: " + evento.type
    }
    this.funCallbkOnClick_2 = (evento) =>{
        this.input.style = "background-color: lightblue; ";
    }
    this.boton.addEventListener("click", this.funCallbkAlPulsar.bind(this));
    this.boton.addEventListener("click", this.funCallbkOnClick_2);
}
//Manera EcmaScript 2015 o ES6
class GestorEventosES6{
    constructor(inputId, btnId, divInfoId){
        this.input = document.getElementById(inputId);
        this.boton = document.getElementById(btnId);
        this.divInfo = document.getElementById(divInfoId);
        this.boton.addEventListener("click", this.funCallbkAlPulsar.bind(this));
        this.boton.addEventListener("click", this.funCallbkOnClick_2);
    }
    funCallbkAlPulsar(evento){
        this.input_value = "Tipo evento: " + evento.type;
    }
    funCallbkOnClick_2 = (evento) => {
        this.input.style = "background-color: lightblue; ";
    }
}