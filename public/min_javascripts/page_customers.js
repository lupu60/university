/*! tires-stock - v0.0.0 - 2016-01-13 */
$(document).ready(function(){var a={id:"",name:"",phone_no:""},b=$("#winter_table").DataTable({ajax:{type:"GET",url:"/customers",dataSrc:"tires"},columns:[{data:"id"},{data:"name"},{data:"phone_no"}]});$("#read, #update, #delete").prop("disabled",!0),$("#winter_table tbody").on("click","tr",function(){$(this).hasClass("selected")?($(this).removeClass("selected"),$("#read, #update, #delete").prop("disabled",!0)):(b.$("tr.selected").removeClass("selected"),$(this).addClass("selected"),$("#read, #update, #delete").prop("disabled",!1))}),$("#create").click(function(){$("#create_modal form").empty();for(var b in a)$("#create_modal form").append('<div class="form-group '+b+'"><label for="'+b+'_content" class="control-label">'+b.toString().toUpperCase()+'</label><input id="'+b+'_content" type="text" value="'+a[b]+'" class="form-control"></div>');$("#create_modal form #id_content").prop("disabled",!0)}),$("#send_create").click(function(){var b=a;for(var c in a)a[c]=$("#create_modal .form-group #"+c+"_content").val();$.ajax({type:"PUT",url:"/customers",data:b,success:function(a){console.log(a)}})}),$("#read").click(function(){$("#read_modal table thead tr").empty(),$("#read_modal table tbody tr").empty();for(var a in b.row(".selected").data())$("#read_modal table thead tr").append("<th>"+a.toString().toUpperCase()+"</th>"),$("#read_modal table tbody tr").append("<td>"+b.row(".selected").data()[a]+"</td>")}),$("#update").click(function(){$("#update_modal form").empty();for(var a in b.row(".selected").data())$("#update_modal form").append('<div class="form-group '+a+'"><label for="'+a+'_content" class="control-label">'+a.toString().toUpperCase()+'</label><input id="'+a+'_content" type="text" value="'+b.row(".selected").data()[a]+'" class="form-control"></div>');$("#update_modal form #id_content").prop("disabled",!0)}),$("#send_update").click(function(){var a=b.row(".selected").data();for(var c in b.row(".selected").data())a[c]=$("#update_modal .form-group #"+c+"_content").val();$.ajax({type:"POST",url:"/customers",data:a,success:function(a){console.log(a)}})}),$("#delete").click(function(){$.ajax({type:"DELETE",url:"/customers",data:{id:b.row(".selected").data().id},success:function(a){console.log(a)}}),b.row(".selected").remove().draw(!1)})});
//# sourceMappingURL=page_customers.js.map