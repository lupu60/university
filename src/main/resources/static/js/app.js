$(document).ready(function() {
    $.ajax({
        url: "/webapi"
    }).then(function(data, status, jqxhr) {
       $('#hello').append(data);
       console.log(jqxhr);
    });
});