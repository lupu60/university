function makeId() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (var i = 0; i < 5; i++) text += possible.charAt(Math.floor(Math.random() * possible.length));
    return text;
}

function makeValue() {
    return Math.floor((Math.random() * 9999) + 1);
}
$('#id').attr("value", makeId);
$('#value').attr("value", makeValue);

var client = {
    "id":'',
    "value":'',
}
$('#go').click(function() {
    $.ajax({
        type: 'POST',
        url: '/newClient',
        data: {
            id: makeId,
            value: makeValue
        },
        success: function(result) {
            console.log(result);
        },
    });
});