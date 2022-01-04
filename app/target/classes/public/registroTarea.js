document.getElementById('creartarea').addEventListener('click', registroTarea);
function registroTarea(e) {
    var tit = document.getElementById('titulo').value;
    var desc = document.getElementById('descripcion').value;
    var ima = document.getElementById('imagen').value;
    var id_u = document.getElementById('').value;
    
    axios.post('http://localhost:4567/registrarTarea', {
        titulo: idusu,
        descripcion: fecin,
        imagen: fecfin,
        id_usuario: mate,
        completed: false
    })

    .then(function (response) {
        alert("Registrando tarea");
        window.location.href = "/home?correo="+correo;
    })
    .catch(function (error) {
        console.log(error);
    });
  }