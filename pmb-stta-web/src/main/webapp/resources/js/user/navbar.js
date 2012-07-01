
/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/19/12
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */

//    defaultkan funsgsi reload ke reload user
reload = function(){
    $.ajax({
        url: '/cbt-pmb/user',
        type: 'GET',
        success: function(result) {
            $('#bundleList').html(result);

        },
        error: function(xhr, status, error){
            alert(status);
        }
    });
};

$('#buttonAddUser').click(function(){
    $.get('/cbt-pmb/user/new', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('toggle');
    });
});

$('#buttonRefreshUser').click(function () {
    reload();
});


$(function(){
    $('#buttonAddUser,#buttonRefreshUser').tooltip({
        placement:'top'
    });
});