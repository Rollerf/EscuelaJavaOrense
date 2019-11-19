//Nomenclatura tipica de function en variable
let suma = function suma(x, y) {
    return x + y;
}
//Nomenclatura tipica de function
function multiplica(x, y) {
    return x * y;
}
//Nomenclatura de objeto Function
let divide = new Function("x", "y", "return x/y;");

//Nomenclatura de funcion flecha
let resta = (x, y) => {
    return x - y;
}
function hacerPunto(x,y){
    //Usando templates strings de ES6
    return `(${x},${y})`;
}