$(document).ready(function () {
    //Evento click del boton
    $("#btn_peticion_ajax_jq").click(function () {
        //Creamos la peticion AJAX:
        $.ajax({
            "url": "./datosjson",
            "type": "GET",
            "success": function (respuestaJson) {
                $("#div_datos_json").html(JSON.stringify(respuestaJson));
            },
            "error": function (jqXHR, textStatus, errorThrown) {
                console.error("No se ha podido obtener la info");
                console.error(jqXHR);
                console.error(textStatus);
                console.error(errorThrown);
                if (jqXHR.status === 404)
                    alert("URL no localizada");
            }
        });


    });

    $("#btn_peticion_ajax_post").click(function () {
        let nombre = document.getElementById("nombre").value;
        let email = document.getElementById("email").value;

        if ("" !== nombre && nombre.length > 1 && email !== "") {
            let expresionNombre = new RegExp("^[A-Z][a-z]+ ?[A-Za-z]*$");
            let expresionEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
            if(!expresionNombre.test(nombre)){
                alert("Primera letra mayus, minimo una minuscula ");
                return;
            }else if(!expresionEmail.test(email)){
                alert("Email invalido");
                return;
            }
            else{
                let datosUsuario = {
                    "nombre": nombre,
                    "email": email
                };
                $.post("./datosjson", datosUsuario,
                        function (resp) {
                            $("#div_datos_json").html(JSON.stringify(resp));

                        });
            }


        } else {
            alert("Los datos no son validos.");
        }



    });

});

