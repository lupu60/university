$(document).ready(function() {
  var order = {
    "id":"",
    "customer_id": "",
    "orderitems_id": ""
  };
  $('#settings').click(function() {
    delete order.location;
    $('#settings_modal form').empty();
    for (var i in order) {
      $('#settings_modal form').append('<div class="form-group ' + i + '"><label for="' + i + '_content" class="control-label">' + i.toString().toUpperCase() + '</label><input id="' + i + '_content" type="text" value="' + order[i] + '" class="form-control"></div>');
    };
    $('#settings_modal form #id_content').prop('disabled', true);
  });
  $('#send_settings').click(function() {
    var send_order=order;
    for (var i in send_order) {
    send_order[i] = $('#settings_modal .form-group #' + i + '_content').val();
    };
    send_order.location = window.location.href;
    $.ajax({
      type: 'PUT',
      url: '/place_order',
      data: send_order,
      success: function(result) {
        console.log(result);
      },
    });
  });
});
