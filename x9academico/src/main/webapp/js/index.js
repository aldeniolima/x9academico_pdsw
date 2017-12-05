function Edita_nts(){
    var input = document.getElementsByClassName("nota");
    var i=0;
    while(i< input.length)
    {
        input[i].disabled=false;
        i++;
    }
    
    document.getElementById("btn_salvar_notas").type="submit";
    document.getElementById("editar_notas").style.display="none";
    
}

function teste()
{
    alert("RODOU");
}

//onload= teste();


