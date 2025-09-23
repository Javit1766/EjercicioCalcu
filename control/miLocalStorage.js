const CARRITO_KEY = "carrito";

const obtenerProductos = () => {
    const data = localStorage.getItem(CARRITO_KEY);
    return data ? JSON.parse(data) : [];
};

const guardarProductos = (lista) => {
    localStorage.setItem(CARRITO_KEY, JSON.stringify(lista));
};

const agregarProducto = (nombre, precio) => {
    const productos = obtenerProductos();
    productos.push({ nombre, precio });
    guardarProductos(productos);
};

export { obtenerProductos, guardarProductos, agregarProducto };
