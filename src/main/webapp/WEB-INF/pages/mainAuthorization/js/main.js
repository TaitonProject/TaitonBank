var xhr = new XMLHttpRequest();

var body = 'name=' + encodeURIComponent(name) +
    '&password=' + encodeURIComponent(password);

xhr.open("POST", '/home', true)
xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')

xhr.onreadystatechange = function() {
    if (xhr.readyState != 4)
        console.log("reguest 400");
    return;
}
xhr.send(body);