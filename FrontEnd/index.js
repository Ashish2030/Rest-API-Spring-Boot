
var modal3 = document.getElementById("myModal3");
var btn3 = document.getElementById("myBtn3");
function func() {
    modal3.style.display = "block";
}
window.onclick = function (event) {

    if (event.target == modal3) {
        modal3.style.display = "none";

    }
}

function enable() {
    var Name = document.getElementById("a").value;
    var lastName = document.getElementById("l").value;
    var mob_no = document.getElementById("b").value;
    var email = document.getElementById("c").value;
    if (Name.length === 0 || mob_no.length !== 10 || email.length < 5 ) {
        alert("Invalid Input")
    }
    else {

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8080/user", true);
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {

            }
        };
        xhttp.setRequestHeader("Content-Type", "application/json");

        var json = {
            "firstName": Name,
            "lastName":lastName,
            "number": mob_no,
            "email": email,
        };
        xhttp.send(JSON.stringify(json));
    }

    setTimeout(function () { window.location.reload(); }, 200);
}
function load()
{
    var xhttp1 = new XMLHttpRequest();
    xhttp1.open("GET", "http://localhost:8080/user", true);
    xhttp1.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var list=JSON.parse(this.responseText);
            var temp=document.getElementById('append');
            var count=1;
              for (var i = 0; i < list.length; i++) {
                  count++;
                var table = document.createElement('tr');
                var temp22 = document.createElement('td');
                var temp2 = document.createElement('td');
                temp2.classList.add("l");
                temp2.style.width = "8px";
                var temp3 = document.createElement('td');
                temp3.classList.add("l");
                var temp44 = document.createElement('td');
                temp44.classList.add("l");
                var temp4 = document.createElement('td');
                temp4.classList.add("l");
               
                var temp5 = document.createElement('td');
                var temp6 = document.createElement('td');
                temp22.innerHTML = list[i].id;
                temp22.style.display = "none";
                temp2.innerHTML = list[i].lastName;
                temp3.innerHTML = list[i].number;
                temp4.innerHTML = list[i].email;
                temp44.innerHTML=list[i].firstName
                temp5.innerHTML = '<button class="mn"  onclick="deleteRow(this)">Delete</Button>'
                temp6.innerHTML = '<button class="mn"  onclick="EditRow(this)">Edit</Button>'
                table.appendChild(temp22);
                 table.appendChild(temp44);
                table.appendChild(temp2);
                table.appendChild(temp3);
                table.appendChild(temp4);
                table.appendChild(temp5);
                table.appendChild(temp6);
                temp.appendChild(table);
            }
                  if(count==1)
            {
                temp.style.display="none";
            }
            else
            {
                temp.style.display="block";
            }
        }
    };
    xhttp1.send()
}
function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    var m = document.getElementById('append').rows[i].cells[0].innerHTML;
    var url = "http://localhost:8080/delete/" + m;
    console.log(url);
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", url, true);
    xhr.onload = function () {
    }
    xhr.send(null);
    setTimeout(function () { window.location.reload(); }, 600);
}
function l() 
{
var id=document.getElementById("id").value;
   var Name = document.getElementById("First").value;
    var lastName = document.getElementById("Last").value;
    var mob_no = document.getElementById("mob").value;
    var email = document.getElementById("email").value;
    if (Name.length === 0 || mob_no.length !== 10 || email.length < 5 ) {
        alert("Invalid Input")
    }
    else {

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "http://localhost:8080/user", true);
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {

            }
        };
     xhttp.setRequestHeader("Content-Type", "application/json");
        var json = {
            "id":id,
            "firstName": Name,
            "lastName":lastName,
            "number": mob_no,
            "email": email,
        };
        xhttp.send(JSON.stringify(json));
    }
    setTimeout(function () { window.location.reload(); }, 200);
}
function EditRow(r){
    var xhttp1 = new XMLHttpRequest();
    var i = r.parentNode.parentNode.rowIndex;
    var m = document.getElementById('append').rows[i].cells[0].innerHTML;
    document.getElementById('id').value = m;
    m = document.getElementById('append').rows[i].cells[1].innerHTML;
    document.getElementById('First').value = m;
    m = document.getElementById('append').rows[i].cells[2].innerHTML;
    document.getElementById('Last').value = m;
    m = document.getElementById('append').rows[i].cells[3].innerHTML;
    document.getElementById('mob').value = m;
    m = document.getElementById('append').rows[i].cells[4].innerHTML;
    document.getElementById('email').value = m;
    func();
 
}
function update()
{
   var id=document.getElementById("id").value;
    var Name = document.getElementById("First").value;
 console.log(id+" "+Name);
    var lastName = document.getElementById("Last").value;
    var mob_no = document.getElementById("mob").value;
    var email = document.getElementById("email").value;
    if (Name.length === 0 || mob_no.length !== 10 || email.length < 5 ) 
    {
        alert("Invalid Input")
    }
    else {
        
        var xhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/edit/" +id;
        xhttp.open("PUT", url, true);
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {

            }
        };
     xhttp.setRequestHeader("Content-Type", "application/json");
        var json = {
            "id":id,
            "firstName": Name,
            "lastName":lastName,
            "number": mob_no,
            "email": email,
        };
        xhttp.send(JSON.stringify(json));
    }
    setTimeout(function () { window.location.reload(); }, 200);
}


 
