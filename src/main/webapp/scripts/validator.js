// validar formulario 

function validate() {
	//event.preventDefault();

	//const codigo = document.getElementById('codigo').value;
	const nome = document.getElementById('nome').value;
	const sexo = document.querySelector('input[name="sexo"]:checked').value;
	const dataNasc = document.getElementById('data_nasc').value;
	const cargoPretendido = document.getElementById('cargo_pretendido').value;
	const textoCurriculo = document.getElementById('texto_curriculo').value;
	
	document.forms["formContato"].submit();
}