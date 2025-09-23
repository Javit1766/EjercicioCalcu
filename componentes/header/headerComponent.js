function header() {
    const header = document.createElement("header");
    header.className = "header";

    const titulo = document.createElement("h2");
    titulo.textContent = "Lista de compras";
    titulo.className = "titulo1";
    header.appendChild(titulo);

    const descarga = document.createElement("a");
    descarga.textContent = "";
    descarga.className = "descarga";
    header.appendChild(descarga);

    return header;
}

export { header };
