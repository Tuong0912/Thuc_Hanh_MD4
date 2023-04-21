function showAll() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/city",
        success(data) {
            let context = `<table>
<tr>
<td>ID</td>
<td>Name</td>
<td>Acreage</td>
<td>GDP</td>
<td>Population</td>
<td>Description</td>
<td>Country</td>
<td colspan="2">Action</td>
</tr>`
            for (let i = 0; i < data.length; i++) {
                context += `<tr>
<td>${data[i].id}</td>
<td>${data[i].name}</td>
<td>${data[i].acreage}</td>
<td>${data[i].population}</td>
<td>${data[i].gdp}</td>
<td>${data[i].description}</td>
<td>${data[i].country.name}</td>
<td><button onclick="showFormView(${data[i].id})">View</button></td>
<td><button onclick="deleteById(${data[i].id})">Delete</button></td>

</tr>`
            }
            context += `</table>`
            document.getElementById("display").innerHTML = context;
        }
    })
}

function createFormCity() {

    let context = `<p>Create New City</p>
<table id="create">
    <tr>
        <td>Name</td>
        <td><input type="text" id="name"></td>
    </tr>
    <tr>
        <td>Acreage</td>
        <td><input type="text" id="acreage"></td>
    </tr>    
    <tr>
        <td>Population</td>
        <td><input type="text" id="population"></td>
    </tr>
    <tr>
        <td>Country</td>
        <td>
            <label>
                <select id="countries"></select>
            </label>
            <div id="country"></div>
        </td>
    </tr>
    <tr>
        <td>GDP</td>
        <td><input type="text" id="gdp"></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><textarea style="height: 49px" id="description"></textarea></td>
    </tr>
    <tr>
        <td><input type="submit" onclick="createCity()" value="Create"></td>
    </tr>
</table>`
    document.getElementById("display").innerHTML = context;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/country",
        success(data) {
            let text = ``
            for (let i = 0; i < data.length; i++) {
                text += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            text += ``
            document.getElementById("countries").innerHTML = text
        }

    })
}

function showFormView(id) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/city/" + id,
        success(data) {
            viewCity(data)
            $("#detail").show()
            $("#display").hide()
        }
    })
}

function viewCity(data) {
    let context = ` <h1>City Detail</h1> 
                  <p>Name: ${data.name} </p><br>
                  <p>Acreage: ${data.acreage} </p><br>
                  <p>Population: ${data.population} </p><br>
                  <p>GDP: ${data.gdp}      </p><br>
                  <p>Description: ${data.description} </p><br>
                  <p>Country:${data.country.name} </p><br>`
    document.getElementById("detail").innerHTML = context;
}

function createCity() {
    let name = $('#name').val()
    let acreage = $('#acreage').val()
    let population = $('#population').val()
    let countries = document.getElementById("countries").value
    let gdp = $('#gdp').val()
    let description = $('#description').val()
    let newCity = {
        name: name,
        acreage: acreage,
        population: population,
        gdp: gdp,
        description: description,
        country: {
            "id": countries
        }
    }
    console.log(newCity)
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        type: "POST",
        data: JSON.stringify(newCity),
        url: "http://localhost:8080/city/create",
        success(data) {
            showAll()
        }
    })
    event.defaultPrevented;
}

function deleteById(id) {
    if (confirm("Are you sure to delete this city ?")) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/city/" + id,
            success() {
                showAll()

            }
        })
    }
}
