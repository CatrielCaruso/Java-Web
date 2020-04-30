/**
 * 
 */

var formu = document.getElementById('form');

formu.addEventListener("submit", function(e) {

    e.preventDefault();
	if(document.getElementById("clave").value == "" || document.getElementById("usuario").value == ""){
		console.log("error");
		document.getElementById("ingresar").className = 'error';
		setInterval(function(){			
			document.getElementById("ingresar").removeAttribute("class");
		}, 2000);
	} else {
		console.log("ok");
		document.getElementById("ingresar").className = 'exito';
		location.href = "../../Principal.jsp";
	}
	
});