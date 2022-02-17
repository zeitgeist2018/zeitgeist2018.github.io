function get(url, callback) {
    getRequest("GET", callback).send();
}

function post(url, data, callback) {
    getRequest("POST", url, callback).send(data);
}


function getRequest(method, url, callback) {
    const xhr = new XMLHttpRequest();
    xhr.open(method, url);

    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (callback)
                callback(xhr.responseText);
        }
    };
    return xhr
}
