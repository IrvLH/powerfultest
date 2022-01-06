document.getElementById('acceder').addEventListener('click', accederCuenta);
function accederCuenta(e) {
    var correo = document.getElementById('correoAcc').value;
    var clave = document.getElementById('contra').value;
        
    axios.post('https://powerfulltest-il.herokuapp.com/accesoUsuarios', {
        correo_e: correo,
        clave: clave,
        completed: false
    })

    .then(function (response) {
        alert(response.data);
        window.location.href = "/home?correo="+correo;
    })
    .catch(function (error) {
        alert("Oops error");
        console.log(error);
    });
  }