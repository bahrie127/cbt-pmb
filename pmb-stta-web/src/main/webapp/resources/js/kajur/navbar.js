
/**
 * Created by IntelliJ IDEA.
 * Kajur: latief
 * Date: 3/19/12
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */

//    defaultkan funsgsi reload ke reload user
reload = function(){
    $.ajax({
        url: '/cbt-pmb/kajur',
        type: 'GET',
        success: function(result) {
            $('#bundleList').html(result);

        },
        error: function(xhr, status, error){
            alert(status);
        }
    });
};

$('#buttonAddKajur').click(function(){
    $.get('/cbt-pmb/kajur/new', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('toggle');
    });
});

$('#buttonRefreshKajur').click(function () {
    reload();
});


$(function(){
    $('#buttonAddKajur,#buttonRefreshKajur').tooltip({
        placement:'top'
    });
});