$(document).ready(function() {
  var tire = {
    "id": "",
    "brand": "",
    "size": "",
    "profile": "",
    "speed_rating": "",
    "quantity": "",
    "price": "",
  };
  /*=======================================
  =            Table generator            =
  =======================================*/
  var table = $('#winter_table').DataTable({
    "ajax": {
      "type": "GET",
      "url": "/winter_tire",
      "dataSrc": "tires"
    },
    "columns": [{
      "data": "id"
    }, {
      "data": "brand"
    }, {
      "data": "size"
    }, {
      "data": "profile"
    }, {
      "data": "speed_rating"
    }, {
      "data": "quantity"
    }, {
      "data": "price"
    }]
  });

  /*=================================
  =            test zone            =
  =================================*/

  /*-----  End of test zone  ------*/
  /*-----  End of Table generator  ------*/
  /*===================================
  =            Style table            =
  ===================================*/

  //  new FixedHeader( table, {
  //     "offsetTop": 50
  // } );

  $('#read, #update, #delete').prop('disabled', true);
  $('#winter_table tbody').on('click', 'tr', function() {
    if ($(this).hasClass('selected')) {
      $(this).removeClass('selected');
      $('#read, #update, #delete').prop('disabled', true);
    } else {
      table.$('tr.selected').removeClass('selected');
      $(this).addClass('selected');
      $('#read, #update, #delete').prop('disabled', false);
    }
  });


  /*-----  End of Style table  ------*/
  /*============================
  =            CRUD            =
  ============================*/
  /*==============================
  =            Create            =
  ==============================*/
  $('#create').click(function() {
    $('#create_modal form').empty();
    for (var i in tire) {
      $('#create_modal form').append('<div class="form-group ' + i + '"><label for="' + i + '_content" class="control-label">' + i.toString().toUpperCase() + '</label><input id="' + i + '_content" type="text" value="' + tire[i] + '" class="form-control"></div>');
    };
    $('#create_modal form #id_content').prop('disabled', true);
  });
  $('#send_create').click(function() {
    var create = tire;
    for (var i in tire) {
      tire[i] = $('#create_modal .form-group #' + i + '_content').val();
    };
    $.ajax({
      type: 'PUT',
      url: '/winter_tire',
      data: create,
      success: function(result) {
        console.log(result);
      },
    });
  });
  /*-----  End of Create  ------*/
  /*============================
  =            Read            =
  ============================*/
  $('#read').click(function() {
    $('#read_modal table thead tr').empty();
    $('#read_modal table tbody tr').empty();
    for (var i in table.row('.selected').data()) {
      $('#read_modal table thead tr').append("<th>" + i.toString().toUpperCase() + "</th>");
      $('#read_modal table tbody tr').append("<td>" + table.row('.selected').data()[i] + "</td>");
    };
  });
  // /*-----  End of Read  ------*/
  // /*==============================
  // =            Update            =
  // ==============================*/
  $('#update').click(function() {
    $('#update_modal form').empty();
    for (var i in table.row('.selected').data()) {
      $('#update_modal form').append('<div class="form-group ' + i + '"><label for="' + i + '_content" class="control-label">' + i.toString().toUpperCase() + '</label><input id="' + i + '_content" type="text" value="' + table.row('.selected').data()[i] + '" class="form-control"></div>');
    };
    $('#update_modal form #id_content').prop('disabled', true);
  });
  $('#send_update').click(function() {
    var update = table.row('.selected').data();
    for (var i in table.row('.selected').data()) {
      update[i] = $('#update_modal .form-group #' + i + '_content').val();
    };
    $.ajax({
      type: 'POST',
      url: '/winter_tire',
      data: update,
      success: function(result) {
        console.log(result);
      },
    });
  });
  // /*-----  End of Update  ------*/
  // /*==============================
  // =            Delete            =
  // ==============================*/
  $('#delete').click(function() {
    $.ajax({
      type: 'DELETE',
      url: '/winter_tire',
      data: {
        id: table.row('.selected').data()['id']
      },
      success: function(result) {
        console.log(result);
      },
    });
    table.row('.selected').remove().draw(false);
  });
  /*-----  End of Delete  ------*/
  /*-----  End of CRUD  ------*/
});
