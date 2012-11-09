/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/21/12
 * Time: 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(
    function () {
    }
);

function detailClick(url,pilihan,jurusan){
//    console.log("detailClick " + url + "?id=" + id);

    $.ajax({
        url: url + "?pilihan=" + pilihan+"&jurusan="+jurusan,
        type: 'GET',
        success: function(result) {
            $('#fillMyModalPlus').html(result);
            $('#modal').modal('show');
        }
    });
}