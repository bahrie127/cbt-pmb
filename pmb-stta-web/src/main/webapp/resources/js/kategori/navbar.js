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
        url: '/cbt-pmb/kategori',
        type: 'GET',
        success: function(result) {
            $('#bundleList').html(result);

        },
        error: function(xhr, status, error){
            alert(status);
        }
    });
};

$('#buttonAddKategori').click(function(){
    $.get('/cbt-pmb/kategori/new', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});

$('#buttonRefreshKategori').click(function () {
    reload();
});

$('#buttonSearchKategori').click(function(){
    $.get('/cbt-pmb/kategori/search/form', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});


$(function(){
    $('#buttonAddKategori,#buttonRefreshKategori,#buttonSearchKategori,#buttonPrintKategori').tooltip({
        placement:'top'
    });
});