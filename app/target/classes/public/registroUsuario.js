document.getElementById('crear').addEventListener('click', crearUsuario);
function crearUsuario(e) {
    var apellidos = document.getElementById('apellidos').value;
    var nombres = document.getElementById('nombres').value+" "+apellidos;
    var correo = document.getElementById('correo').value;
    var clave = document.getElementById('clave').value;
        
    axios.post('https://powerfulltest-il.herokuapp.com/registrarUsuario', {
        nombre: nombres,
        correo_e: correo,
        clave: clave,
        completed: false
    })

    .then(function (response) {
        alert("Creando cuenta...");
        window.location.href = "/acceso";
    })
    .catch(function (error) {
        console.log(error);
    });
  }