var base_url='http://localhost:8080/';


function post(url, data,success) {
    $.ajax({
        type:'post',
        url:url,
        data:data,
        success:success

    })
};

function get(url,data,success) {
    $.ajax({
        type:'get',
        url:data,
        success:success
    })
}