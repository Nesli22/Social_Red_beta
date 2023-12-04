/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let btnIS = document.getElementById("btnIS");

btnIS.addEventListener("click", function () {

    let url = "http://localhost:8080/AplicacionWebProyecto/SvInicioSesion";

    fetch(url)
            .then(response => response.json())
            .then(data => console.log(data));
    alert("Iniciando Sesion");

}

);

