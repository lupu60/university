/*! tires-stock - v0.0.0 - 2016-01-13 */
$(document).ready(function(){var a={id:"",customer_id:"",orderitems_id:""};$("#settings").click(function(){$("#settings_modal form").empty();for(var b in a)$("#settings_modal form").append('<div class="form-group '+b+'"><label for="'+b+'_content" class="control-label">'+b.toString().toUpperCase()+'</label><input id="'+b+'_content" type="text" value="'+a[b]+'" class="form-control"></div>');$("#settings_modal form #id_content").prop("disabled",!0)}),$("#send_settings").click(function(){var b=a;for(var c in b)b[c]=$("#settings_modal .form-group #"+c+"_content").val();b.location=window.location.href,$.ajax({type:"PUT",url:"/place_order",data:b,success:function(a){console.log(a)}})})});
//# sourceMappingURL=place_order.js.map