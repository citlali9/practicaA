/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Busqueda() {
    
    var nombre = document.getElementById("ingresa").value;
    
    $.post("utilBusqueda",{
         nombre: nombre
         
        }, function(data){
            console.log("Vamos Bien"); 
            
        }
    );
}
