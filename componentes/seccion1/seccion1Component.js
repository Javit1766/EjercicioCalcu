function seccion1() {
    const section = document.createElement("section");
    section.className = "seccion1";

    const total = document.createElement("h2");
    total.id = "total";
    total.textContent = "Q 0.00";
    section.appendChild(total);

    section.appendChild(document.createElement("hr"));

    const subtitulo = document.createElement("h3");
    subtitulo.textContent = "Lista de Compras";
    section.appendChild(subtitulo);

    const lista = document.createElement("ul");
    lista.id = "lista-compras";
    section.appendChild(lista);

    section.appendChild(document.createElement("hr"));

    return section;
}

export { seccion1 };
