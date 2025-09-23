function descargar(nombreContenedor){
    const div = document.getElementById(nombreContenedor);
    html2canva(div).then(canvas => {
        const enlace = document.createElement("a");
        enlace.href = canvas.toDataURL("image/png");
        enlace.dowland = "hola_mundo.png";
        enlace.click();
    })
}

export { descargar }