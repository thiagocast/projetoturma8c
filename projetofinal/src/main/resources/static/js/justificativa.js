function carregarJustificativa() {
    var ocorrencia = JSON.parse(localStorage.getItem("ocorrencia"));
    if ((ocorrencia == null) || ocorrencia.status == 1) {
        window.location = "../html/colaborador.html";
    } else {
        document.getElementById("foto").innerHTML = "<img alt='usuario sem foto' width='112px' height='112px' src=../imagens/" + ocorrencia.id_usuario.linkFoto + ">";
        document.getElementById("dados").innerHTML = "<h3> " + ocorrencia.id_usuario.nomeUsuario + "<br>" + ocorrencia.id_usuario.racf + "<br>ID:" + ocorrencia.id_usuario.id_usuario + "</h3>";
        document.getElementById("idusuario").innerHTML = ocorrencia.id_usuario.id_usuario;
        formularioOcorrencias();
    }
}

function logout() {
    localStorage.clear();
    window.location = "../index.html";
}

function voltar() {
    localStorage.removeItem("ocorrencia");
    window.location = "../html/colaborador.html";
}

function formularioOcorrencias() {
    var ocorrencia = JSON.parse(localStorage.getItem("ocorrencia"));
    if ((ocorrencia == null)) {
        window.location = "../html/colaborador.html";
    } else {
        document.getElementById("data").innerHTML = ocorrencia.data_oc;
        document.getElementById("qtdhoras").innerHTML = ocorrencia.num_horas;
        document.getElementById("botaoatualizar").innerHTML = "<button onclick=atualizarJustificativa(" + ocorrencia.num_seq + ") type='button' class='btn btn-primary btn-lg'>Atualizar</button>";;
        var atividades = new Object();
        fetch("http://localhost:8080/atividades/")
            .then(res => res.json())
            .then(res => {
                var dropdown = "<select id='selecaoatividade' class='form-control'>";

                res.forEach(i => {
                    if (i.nome_atividade == "Outros") {
                        dropdown += "<option selected value='" + i.id_atividade + "'>" + i.nome_atividade + "</option>";
                    } else {
                        dropdown += "<option value='" + i.id_atividade + "'>" + i.nome_atividade + "</option>";
                    }
                });
                dropdown += "</select>";
                document.getElementById("atividade").innerHTML = dropdown;
            })
            .catch(err => window.alert("Erro ao recuperar atividades"));
    }
}

function atualizarJustificativa(id) {
    var mensagem = {
        "num_seq": id.toString(),
        "id_atividade": {
            "id_atividade": document.getElementById("selecaoatividade").value
        },
        "id_usuario": {
            "id_usuario": document.getElementById("idusuario").innerHTML
        },
        "data_oc": document.getElementById("data").innerHTML,
        "num_horas": document.getElementById("qtdhoras").innerHTML,
        "descricao": document.getElementById("descricao").value,
        "ponto_manual": document.getElementById("ajustemanual").value,
        "status": "1"
    };
    mensagem = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(mensagem)
    };
    fetch("http://localhost:8080/atualizarocorrencia", mensagem);
    //window.location = "../html/colaborador.html";
}