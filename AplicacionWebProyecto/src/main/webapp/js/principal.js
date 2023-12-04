/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let btnCS = document.getElementById("btnCS");
let btnComentar = document.getElementById("btnComentar");

btnCS.addEventListener("click", function(){
    alert("Cerrando Sesion");
     window.location.href = 'Inicio.jsp';
});

btnComentar.addEventListener("click", function(){
    alert("Comentando");
    window.location.reload();
});

