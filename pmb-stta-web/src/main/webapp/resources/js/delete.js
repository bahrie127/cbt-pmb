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

function buttonDeleteClick(url, id){
//    console.log(url + "?id=" + id);

    $.ajax({
        url: url + "?id=" + id,
        type: 'DELETE',

        success: function(result) {

            alert(result);
            reload();
        }
    });

}