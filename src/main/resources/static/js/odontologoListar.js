
const tableBody = document.querySelector("#odontologoTable tbody");
const editModal = new bootstrap.Modal(document.getElementById("editModal"));
const editForm = document.getElementById("editForm");
let currentOdontologoId;


function fetchOdontologos() {

  fetch(`odontologo/buscartodos`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      tableBody.innerHTML = "";


      data.forEach((odontologo, index) => {
        const row = document.createElement("tr");

        row.innerHTML = `
              <td>${odontologo.id}</td>
              <td>${odontologo.apellido}</td>
              <td>${odontologo.nombre}</td>
              <td>${odontologo.matricula}</td>
              <td>${odontologo.fechaIngreso}</td>
              <td>
                <button class="btn btn-primary btn-sm" onclick="editOdontologo(${odontologo.id}, '${odontologo.apellido}','${odontologo.nombre}', '${odontologo.matricula}',
                '${odontologo.fechaIngreso}')">Modificar</button>
                <button class="btn btn-danger btn-sm" onclick="deleteOdontologo(${odontologo.id})">Eliminar</button>
              </td>
            `;

        tableBody.appendChild(row);
      });
    })
    .catch((error) => {
      console.error("Error fetching data:", error);
    });
}

editOdontologo = function (
  id,
  apellido,
  nombre,
  matricula,
  fechaIngreso
) {
  currentOdontologoId = id;
  document.getElementById("editApellido").value = apellido;
  document.getElementById("editNombre").value = nombre;
  document.getElementById("editMatricula").value = matricula;
  document.getElementById("editFecha").value = fechaIngreso;
  editModal.show();
};

editForm.addEventListener("submit", function (event) {
  event.preventDefault();
  const apellido = document.getElementById("editApellido").value;
  const nombre = document.getElementById("editNombre").value;
  const matricula = document.getElementById("editMatricula").value;
  const fecha = document.getElementById("editFecha").value;


  fetch(`odontologo/modificar`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      id: currentPacienteId,
      nombre,
      apellido,
      matricula,
      fechaIngreso: fecha
      },
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("Odontologo modificado con éxito");
      fetchOdontologos();
      editModal.hide();
    })
    .catch((error) => {
      console.error("Error editando odontologo:", error);
    });
});

deleteOdontologo = function (id) {
  if (confirm("¿Está seguro de que desea eliminar este odontologo?")) {

    fetch(`odontologo/eliminar/${id}`, {
      method: "DELETE",
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        alert("Odontologo eliminado con éxito");
        fetchOdontologos();
      })
      .catch((error) => {
        console.error("Error borrando odontologo:", error);
      });
  }
};

fetchOdontologos();