const form = document.getElementById("formulario");

const campos = ["nombre", "email", "contra", "edad", "telefono", "direccion", "ciudad", "cp", "dni"];

const validaciones = {
    nombre: val => val.length >= 6 && val.includes(" "),
    email: val => /^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(val),
    contra: val => /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/.test(val),
    edad: val => parseInt(val) >= 18,
    telefono: val => /^\d{7,}$/.test(val) && !/[ ()-]/.test(val),
    direccion: val => /[a-zA-Z]/.test(val) && /\d/.test(val) && val.length >= 5 && val.includes(" "),
    ciudad: val => val.length >= 3,
    cp: val => val.length >= 3,
    dni: val => /^\d{7,8}$/.test(val),
};

const mensajes = {
    nombre: "Debe tener más de 6 letras y al menos un espacio.",
    email: "Debe ser un email válido.",
    contra: "Al menos 8 caracteres, incluyendo letras y números.",
    edad: "Debe ser un número mayor o igual a 18.",
    telefono: "Mínimo 7 dígitos sin guiones, paréntesis ni espacios.",
    direccion: "Al menos 5 caracteres, con letras, números y un espacio.",
    ciudad: "Debe tener al menos 3 caracteres.",
    cp: "Debe tener al menos 3 caracteres.",
    dni: "Debe tener 7 u 8 dígitos.",
};

// Validación en blur/focus
campos.forEach(campo => {
    const input = document.getElementById(campo);
    input.addEventListener("blur", () => {
        const valor = input.value.trim();
        const valido = validaciones[campo](valor);
        const errorDiv = document.getElementById(`error-${campo}`);
        errorDiv.textContent = valido ? "" : mensajes[campo];
    });
    input.addEventListener("focus", () => {
        document.getElementById(`error-${campo}`).textContent = "";
    });
});

form.addEventListener("submit", function (e) {
    e.preventDefault();
    let errores = [];
    let datos = [];

    // Validar cada campo
    campos.forEach(campo => {
        const input = document.getElementById(campo);
        const valor = input.value.trim();
        const valido = validaciones[campo](valor);
        const errorDiv = document.getElementById(`error-${campo}`);

        if (!valido) {
            errores.push(`${campo.toUpperCase()}: ${mensajes[campo]}`);
            errorDiv.textContent = mensajes[campo];
        } else {
            errorDiv.textContent = "";
            datos.push(`${campo.toUpperCase()}: ${valor}`);
        }
    });

    // Validar coincidencia de contraseñas
    const pass1 = document.getElementById("contra").value.trim();
    const pass2 = document.getElementById("contra2").value.trim();
    const errorContra2 = document.getElementById("error-contra2");

    if (pass1 !== pass2) {
        errores.push("Las contraseñas no coinciden.");
        errorContra2.textContent = "Las contraseñas no coinciden.";
    } else {
        errorContra2.textContent = "";
    }

    // Mostrar errores o datos
    if (errores.length > 0) {
        alert("Errores:\n" + errores.join("\n"));
    } else {
        alert("Formulario enviado correctamente:\n" + datos.join("\n"));
        form.reset();
    }
});



let titulo=document.getElementById('titulo-form');
let nombreCompleto=document.getElementById('nombre');
nombreCompleto.focus();

nombreCompleto.addEventListener('input', function () {
    titulo.innerHTML = `<p>HOLA ${nombreCompleto.value.toUpperCase()}</p>`;
});