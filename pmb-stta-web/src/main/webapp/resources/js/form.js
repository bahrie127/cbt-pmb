/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/20/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function () {
    var form =  $('form');

    form.submit(function(event){
        event.preventDefault();

        var data = $(this).serialize();
        var action = $(this).attr("action");
        var method = $(this).attr("method");

        var success = false;

        $.ajax({
            url: action,
            type: method,
            data : data,
            success: function(result) {
                if(action.match("/search")!=null){
                    $('#modal').modal('hide');
                    $('#bundleList').html(result);
                }else{
                    success = (result + "").toLowerCase() == "sukses" ? true : false;
                  //  alert(result);

                    //jika sukses matikan dialog
                    if(success){
                        $('#modal').modal('hide');
                        reload();
                    }
                }


            },
            error: function(xhr, status, error){
                alert(status);
            }
        });


        return success;
    })
});