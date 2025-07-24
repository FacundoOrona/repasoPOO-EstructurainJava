let nombre = "Facundo";
alert(`Hola, ${nombre}, ¡bienvenido al juego!`);

let numeroSecreto = 6;
let numeroUsuario = prompt("Me indicas un numero del 1 al 10 por favor:");

console.log(numeroUsuario);

if (numeroUsuario == numeroSecreto) {
    alert('Acertaste el numero, el cual era: ' + numeroSecreto);
    alert(`Ustede habia indicado el numero ${numeroUsuario}`)
} else {
    alert('No Acertaste el numero')
}
