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
        url: '/cbt-pmb/hasilUjian',
        type: 'GET',
        success: function(result) {
            $('#bundleList').html(result);

        },
        error: function(xhr, status, error){
            alert(status);
        }
    });
};

$('#buttonRefreshHasil').click(function () {
    reload();
});

$('#buttonSearchHasil').click(function(){
    $.get('/cbt-pmb/ujian/search/form', function (data) {
        $('#fillMyModalPlus').html(data);
        $('#modal').modal('show');
    });
});
