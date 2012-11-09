/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/19/12
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */

//    defaultkan funsgsi reload ke reload deposit
reload = function(){
    $.ajax({
        url: '/flatout/distributor',
        type: 'GET',
        success: function(result) {
            $('#bundleList').html(result);

        },
        error: function(xhr, status, error){
            alert(status);
        }
    });
};

$('#buttonAddDistributor').click(function(){
    $.get('/flatout/distributor/new', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});

$('#buttonRefreshDistributor').click(function () {
    reload();
});

$('#buttonSearchDistributor').click(function(){
    $.get('/flatout/distributor/search/form', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});


$(function(){
    $('#buttonAddDistributor,#buttonRefreshDistributor,#buttonSearchDistributor,#buttonPrintDistributor').tooltip({
        placement:'top'
    });
});