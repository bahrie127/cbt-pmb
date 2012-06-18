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
        url: '/cbt-pmb/soal',
        type: 'GET',
        success: function(result) {
            $('#bundleList').html(result);

        },
        error: function(xhr, status, error){
            alert(status);
        }
    });
};

$('#buttonAddSoal').click(function(){
    $.get('/cbt-pmb/soal/new', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});

$('#buttonRefreshSoal').click(function () {
    reload();
});

$('#buttonSearchSoal').click(function(){
    $.get('/cbt-pmb/soal/search/form', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});


$(function(){
    $('#buttonAddSoal,#buttonRefreshSoal,#buttonSearchSoal,#buttonPrintSoal').tooltip({
        placement:'top'
    });
});