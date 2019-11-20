
//jQuery se abrevia como $(...)
jQuery(document).ready(function(){
    jQuery("section").html(jQuery("section").html() +
    "<div><p>LEYENDA DE LO QUE SEA</p></div>"); 
    $(".articulo").append("<p>UN PARRAFO EN CADA ELEMENTO con class = 'articulo'</p>");
    $("tr").append("<td>Info</td>");//Anadir quinta columna
    //tr.setAttribute("style", "background-color:red")
    $("td:nth-child(5)").attr("style","background-color:red;color: white;");
    $("td:nth-child(5)").click(() => {
        alert('un click desde jQ');
    });
    $("#otro_menu").html("<h2>Menu de articulos</h2><br/><br/>");

    $("article").each( function(index){
      let idArticulo = "articulo_29juR_" + index
      $(this).attr("id",idArticulo);
      $(this).slideUp();

      $("#otro_menu").append(" <a id='enlace_" + idArticulo + "'href='#" + idArticulo + "'class=enlace-articulo>Articulo n " + index + "</a>");
      $("#enlace_" + idArticulo).click(function(){
        if(typeof(articuloActivo) === "undefined"){
          $("#" + idArticulo).slideDown(150);
        }else{
          $(articuloActivo).slideUp(800, function(){
            $("#" + idArticulo).slideDown(150);
          });
        }
        articuloActivo = $("#" + idArticulo);
      })
    }
      );
      var articuloActivo;
/*
      $(this).click(function(event) {
        var href = $('.enlace-articulo').attr('href');
        alert(href);
        event.preventDefault();
      });
*/
/*
      $("#menu_" + index).click(function(){
        $("#"+idArticulo).attr("style","display: default;");
      });
      */
      
    //$("article").attr("style","display:none;");


    /*
    $("article").
      $("#otro_menu").append("<a href='' class=''></a>") 
    $("#otro_menu").click(function(){
        //$("#otro_menu").fadeOut();
        //$("#otro_menu").slideUp();
        $(this).slideUp();
    })
    /*
    $( "#boton_uno" ).click(function() {
        $("#titulo_dos").animate({
          opacity: 0.25,
          left: "+=50",
          height: "toggle"
        }, 5000, function() {
          // Animation complete.
        });
      });
      */

});
