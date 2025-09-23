import { obtenerProductos, guardarProductos } from "../../control/miLocalStorage.js";

function formularioCompras() {
    const contenedor = document.createElement("section");
    contenedor.className = "contenedor-formulario";

    const total = document.createElement("h3");
    total.className = "total-monto";
    total.textContent = "Q. 0.00";
    contenedor.appendChild(total);

    const contInputs = document.createElement("div");
    contInputs.className = "contenedor-inputs";

    const inputNombre = document.createElement("div");
    inputNombre.contentEditable = true;
    inputNombre.className = "input-nombre";
    contInputs.appendChild(inputNombre);

    const inputPrecio = document.createElement("div");
    inputPrecio.contentEditable = true;
    inputPrecio.className = "input-precio";
    contInputs.appendChild(inputPrecio);

    const btnAgregar = document.createElement("button");
    btnAgregar.className = "btn-agregar";
    btnAgregar.textContent = "Agregar";
    contInputs.appendChild(btnAgregar);

    contenedor.appendChild(contInputs);

    const listaProductosCont = document.createElement("div");
    listaProductosCont.className = "lista-productos";
    contenedor.appendChild(listaProductosCont);

    btnAgregar.addEventListener("click", () => {
        const nombre = inputNombre.textContent.trim();
        const precio = parseFloat(inputPrecio.textContent.trim());

        if (!nombre || isNaN(precio)) return;

        const item = document.createElement("div");
        item.className = "item-producto";
        item.textContent = `${nombre} - Q. ${precio.toFixed(2)}`;
        listaProductosCont.appendChild(item);

        const productos = obtenerProductos();
        productos.push({ nombre, precio });
        guardarProductos(productos);
    });

    return contenedor;
}

export { formularioCompras };
