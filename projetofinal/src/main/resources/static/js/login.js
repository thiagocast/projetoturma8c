function login() {
    var dados = {
        racf: document.getElementById("username").value,
        senha: document.getElementById("password").value,
    };
    var mensagem = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(dados)
    };
    fetch("http://localhost:80/login", mensagem)
        .then(res => res.json())
        .then(res => {
            if (res.gestor == 0) {
                window.location = "./html/colaborador.html";
            }
            if (res.gestor == 1) {
                window.location = "./html/gestor.html";
            }
            delete res.senha;
            localStorage.setItem("userlogado", JSON.stringify(res));
        })
        .catch(err => {
            window.alert("Usuario/Senha invalido");
        });
}

function clearcache() {
    localStorage.clear();
}