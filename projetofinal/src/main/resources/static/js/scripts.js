function validar() {
    var nome = formulario.nome.value;
    var email = formulario.email.value;
    var senha = formulario.senha.value;
    if (nome == "") {
        alert("Preencha o nome");
        formulario.nome.focus();
        return false;
    }
    if (email == "" || email.indexOf('@') == -1) {
        alert("Preencha o email");
        formulario.email.focus();
        return false;
    }
    if (senha == "" || senha.length <= 5) {
        alert("Preencha o campo senha com no minimo 6 caracteres");
        formulario.senha.focus();
        return false;
    }
}