function operarArrays(arrX, arrY, opera) {
    //Comprobamos que el tamano de los arrays son el mismo 
    if (arrX.length == arrY.length) {
        //Declaramos un array
        //A diferencia de let de ES6, que si es ambito a nivel de bloque.
        var arrayResult = new Array(arrX.length);//Una manera de crear array. Si es posible declarar array con espacio definido para optimizar
        for (let i = 0; i < arrX.length; i++) {
            arrayResult[i] = opera(arrX[i], arrY[i]);
        }
    }
    return arrayResult;
}
//Ejemplos de array
//Declaramos un array
/*
var arrayResultado = new Array(); //Una manera de crear array
var arrayResultado = []; //Otra declaracion de array vacio con notacion JSON
                        //No indicamos el tamano porque en realidad los arrays de javascript son como los
                        //ArrayList<Object> de Java. se parece mas incluso a un HashMap<Integer,Object>
arrayEjemplo.push("Primer elemento");
arrayEjemplo[10] = "lo que sea";
*/