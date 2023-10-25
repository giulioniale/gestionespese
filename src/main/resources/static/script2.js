const findAllProdotti= 'http://localhost:8080/controllerUtente/findAll';

    function addScontrino() {
        document.getElementById("aggiungiRiga").style.display = "none";
        var bodyTabella = document.getElementById("tbody");
        var newRiga = bodyTabella.insertRow(bodyTabella.length);
        var cell0= newRiga.insertCell(bodyTabella.length);
        

        fetch(findAllProdotti).then(prodotto=> {
            console.log(prodotto)

            const select = document.getElementById()
        })

    }
document.getElementById("aggiungiRiga").addEventListener("click", addScontrino);
