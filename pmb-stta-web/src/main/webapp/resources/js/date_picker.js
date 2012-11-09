/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/27/12
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
function initDatePicker(textId){
//    $( "#" + textId ).datepicker( "option", "dateFormat","dd-mm-yy" );

    $( "#" + textId ).datepicker({
        changeMonth: true,
        changeYear: true
    });

    $( "#" + textId).change(function() {
        $( "#" + textId ).datepicker( "option", "dateFormat","dd-mm-yy" );
    });
}