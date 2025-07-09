function valid(message, regex, value) {

    if (regex.test(value)) {
        return "";
    } else {
        return "\n" + message;
    }

}

async function showError(response) {
    try {
        let erro = await response.json();
        alert(erro.message);
    } catch (error) {
        alert("erro inesperado.");
    }
}

function closeSession(){
    sessionStorage.clear();
    location.href = "/index.html";
}
