/**
 * confirmar a exclusão de um candidato
 */

function confirm(id){
	let resposta = confirm("tem certeza que deseja excluir esse candidato?")
	if(resposta === true){
		 window.location.href = "delete?id="+ id
	}
}