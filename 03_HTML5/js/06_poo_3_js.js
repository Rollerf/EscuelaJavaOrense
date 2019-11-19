//Notacion JSON: JavaScript Object Notation
//Lo que se puede almacenar en XML, se puede convertir a JSON y viceversa
//Todo se puede almacenar como JSON

var unObejeto = { }; //new Object();
var otroObj = {
    "prop_1" : "Propiedad uno",
    "prop_2" : "Propiedad dos",
    "prop_3" : "Propiedad tres",
    "prop_4" : "Propiedad cuatro",
    toString: function(){
        var strProp = "Lista de propiedades:";
        for(var i=1; i<20; i++){
            if(typeof(this["prop_" + i]) !== "undefined")
                strProp+=this["prop_" + i] + "; ";
        }       
        return strProp;
        /*
        return "Propiedades: " + this.prop_1 + "; " + this.prop_2 + "; " +
        this.prop_3 + "; " + this.prop_4 + "; " + this.prop_5;
        */
    },
    toStringAllProp:function(){
        var strProp = "<br/>Lista de TODAS las propiedades: ";
        for(key in this){
            if(key.indexOf("prop_") >= 0)
                strProp += this[key] + "; ";
        }
        return strProp;
    },

    toStringAllZaira:function(){
        var largo = Object.keys(this).length;
        var strProp = "<br/>Lista propiedades Zaira: ";
        for(var i = 0; i<largo; i++){
            if(Object.keys(this)[i].indexOf("prop_") >=0){
                strProp += Object.values(this)[i];
            }
        }
        return strProp;
    }
}
otroObj.prop_5 = "Propiedad cinco";
otroObj.prop_9 = "Propiedad nueve";
var divTris = document.getElementById("contenido_tris");
divBis.innerHTML += otroObj.toString();
divBis.innerHTML += otroObj.toStringAllProp();
divBis.innerHTML += otroObj.toStringAllZaira();