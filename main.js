import { loadHtmlSectionDownload } from "./control/seccionDowland/dowland.js";

document.addEventListener("DOMContentLoaded", () => {
    loadHtmlSectionDownload();
});
import { obtenerProductos, guardarProductos } from "./control/miLocalStorage.js";
import { header } from "./componentes/header/headerComponent.js";
import { formularioCompras } from "./componentes/formulario/formularioComponent.js";

function seccion() {
    let productos = obtenerProductos();

    if (!productos || productos.length === 0) {
        productos = [];
        guardarProductos(productos);
    }

    const contenedor = document.createElement("div");
    contenedor.appendChild(header());
    contenedor.appendChild(formularioCompras());

    return contenedor;
}

document.body.appendChild(seccion());
