var btn_login = document.querySelector('#btn_login');
btn_login.addEventListener("click", function(){
 alert("Livros excluídos com sucesso!");
});

function chamaAlertIndex(){
    var alert = document.getElementById("alertIndex");
    alert.style.display= "block";
}

function verificaFormLogin(er, valor, input) {
   var btn = document.getElementById("btn_login");
   var tamanho = valor.length;
    if (er.test(valor) || tamanho<6) {
        //class="form-group has-error has-feedback"
        //elemento.style = "border: firebrick solid medium";
        //var div = input.parentNode;
        //div.className = "has-error has-feedback";
        //input = "title='Header' data-toggle='popover' data-trigger='hover' data-content='Some content'";
        input.className = "form-control is-invalid";
        btn.type = "button";
    } else
    {
        input.className = "form-control";
        btn.type = "submit";
    }
}
function verificaSenha(input)
{
    var valor = input.value;
    //var er = /[^0-9A-Za-z_.]/;
    var er = /[ \t]/;
    er.lastIndex = 0;
    verificaFormLogin(er, valor, input);
}


function verificaLogin(input)
{
    var valor = input.value;
    var er = /[^0-9A-Za-z_.]/;
    //var er = /[ \t]/;
    er.lastIndex = 0;
    verificaFormLogin(er, valor, input);
}

function Edita_nts() {
    var input = document.getElementsByClassName("nota");
    var i = 0;
    while (i < input.length)
    {
        input[i].disabled = false;
        i++;
    }

    document.getElementById("btn_salvar_notas").type = "submit";
    document.getElementById("editar_notas").style.display = "none";

}

function teste(a)
{
    a.popover();
    // alert("RODOU");
}

//onload= teste();


