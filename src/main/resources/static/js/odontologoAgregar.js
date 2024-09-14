const form = document.getElementById("agregarForm");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const apellido = document.getElementById("apellido").value;
  const nombre = document.getElementById("nombre").value;
  const matricula = document.getElementById("matricula").value;
  const fecha = document.getElementById("fecha").value;


  const datosFormulario = {
    nombre,
    apellido,
    matricula,
    fechaIngreso: fecha
  };

  fetch(`odontologo/guardar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datosFormulario),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("Odontologo agregado con éxito");
      form.reset();
    })
    .catch((error) => {
      console.error("Error agregando odontologo:", error);
    });
});