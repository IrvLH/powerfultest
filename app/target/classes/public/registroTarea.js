document.getElementById('creartarea').addEventListener('click', registroTarea);
function registroTarea(e) {
    var tit = document.getElementById('titulo').value;
    var desc = document.getElementById('descripcion').value;
    var ima = document.querySelector('input[type=file]');
    let params = new URLSearchParams(location.search);
    var id_u = params.get('idUsuario');
    var correo = params.get('correo');
    
    if(ima.files[0]!=null){
        var file = ima.files[0], reader = new FileReader();
        reader.onloadend = function(){
            var ar64 = reader.result.replace(/^data:.+;base64,/, '');
            console.log(ar64);
            
            axios.post('https://powerfulltest-il.herokuapp.com/registrarTarea', {
                titulo: tit,
                descripcion: desc,
                imagen: ar64,
                id_usuario: id_u,
                completed: false
            })
            .then(function (response) {
                alert("Registrando tarea");
                window.location.href = "/home?correo="+correo;
            })
            .catch(function (error) {
                console.log(error);
            });
        };
        reader.readAsDataURL(file);
    }else{
        axios.post('https://powerfulltest-il.herokuapp.com/registrarTarea', {
                titulo: tit,
                descripcion: desc,
                id_usuario: id_u,
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
}