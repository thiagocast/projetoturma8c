function carregarUsuario() {
    var usuario = JSON.parse(localStorage.getItem("userlogado"));
    if ((usuario == null) || (usuario.gestor == 1)) {
        logout();
    } else {
        document.getElementById("foto").innerHTML = "<img alt='usuario sem foto' width='112px' height='112px' src=../imagens/" + usuario.linkFoto + ">";
        document.getElementById("dados").innerHTML = "<h3> " + usuario.nomeUsuario + "<br>" + usuario.racf + "<br>ID:" + usuario.id_usuario + "</h3>";
        carregarOcorrencias(JSON.stringify(usuario.id_usuario));
    }
}

function logout() {
    localStorage.clear();
    window.location = "../index.html";
}

function carregarOcorrencias(opcao) {
    fetch("http://localhost:8080/ocorrencias/colab/" + opcao)
        .then(res => res.json())
        .then(res => montartabela(res))
}

function montartabela(lista) {
    //montagem da estrutura de tabela
    var tabela =
        "<div class='row'>" +
        "    <div class='col-12'>" +
        "        <table align='center' border='1' width='80%'>" +
        "            <tr>" +
        "                <th>Atividade</th>" +
        "                <th>Data da Ocorrencia</th>" +
        "                <th>Numero de horas</th>" +
        "                <th>Descrição</th>" +
        "                <th>Status</th>" +
        "            </tr>";
    //Codigo pra preencher a tabela
    lista.forEach(i => {
        if (i.status == 0) {
            justificativa = "<button onclick='justificar(this.id)' value='" + JSON.stringify(i) + "' id='botaoJustificar_" + i.num_seq + "' type='button' class='btn btn-primary btn-sm'>Justificar</button>";
        }
        if (i.status == 1) {
            justificativa = "OK";
        }
        tabela +=
            "<tr>" + "<td>" + i.id_atividade.nome_atividade + "</td>" +
            "<td>" + i.data_oc + "</td>" +
            "<td>" + i.num_horas + "</td>" +
            "<td>" + i.descricao + "</td>" +
            "<td>" + justificativa + "</td>" +
            "</tr>";
    });

    //Fim da extração da tabela para fechamento das tags
    tabela +=
        "        </table>" +
        "    </div>" +
        "</div>";
    document.getElementById("resultado").innerHTML = tabela;
}

function justificar(id) {
    localStorage.removeItem("ocorrencia");
    var ocorrencia = document.getElementById(id).value;
    localStorage.setItem("ocorrencia", ocorrencia);
    window.location = "../html/justificativa.html";
}