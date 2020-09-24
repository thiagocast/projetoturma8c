function carregarUsuario() {
    var usuario = JSON.parse(localStorage.getItem("userlogado"));
    if ((usuario == null) || (usuario.gestor == 0)) {
        window.location = "../index.html";
    } else {
        document.getElementById("foto").innerHTML = "<img alt='usuario sem foto' width='112px' height='112px' src=../imagens/" + usuario.linkFoto + ">";
        document.getElementById("dados").innerHTML = "<h3> " + usuario.nomeUsuario + "<br>RACF: " + usuario.racf + "<br></h3>";
    }
}

function logout() {
    localStorage.clear();
    window.location = "../index.html";
}

function montartabela(lista) {
    //montagem da estrutura de tabela
    var tabela =
        "<div class='row'>" +
        "    <div class='col-12'>" +
        "        <table align='center' border='1' width='80%'>" +
        "            <tr>" +
        "                <th>Nome do Usuario</th>" +
        "                <th>Racf</th>" +
        "                <th>Atividade</th>" +
        "                <th>Data da Ocorrencia</th>" +
        "                <th>Numero de horas</th>" +
        "                <th>Descrição</th>" +
        "            </tr>";
    //Codigo pra preencher a tabela
    lista.forEach(i => {
        tabela +=
            "<tr>" + "<td>" + i.id_usuario.nomeUsuario + "</td>" +
            "<td>" + i.id_usuario.racf + "</td>" +
            "<td>" + i.id_atividade.nome_atividade + "</td>" +
            "<td>" + i.data_oc + "</td>" +
            "<td>" + i.num_horas + "</td>" +
            "<td>" + i.descricao + "</td> </tr>";
    });

    //Fim da extração da tabela para fechamento das tags
    tabela +=
        "        </table>" +
        "    </div>" +
        "</div>";
    document.getElementById("resultado").innerHTML = tabela;
}

function filtrarOcorrencia() {
    var opcao = document.getElementById("comboOcorrencias").value;
    if (opcao == "0" || opcao == "1") {
        fetch("http://localhost:8080/ocorrencias/" + opcao)
            .then(res => res.json())
            .then(res => montartabela(res))
            .catch(err => {
                window.alert("Sem registros");
            });
    }
}