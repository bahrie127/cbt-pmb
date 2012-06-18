/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/20/12
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */

var soal;

/**
 * kejadian ketika submit Soal
 */
$('form').submit(function (event) {
    event.preventDefault();

    var data = $(this).serializeObject();
    var action = $(this).attr("action");
    var method = $(this).attr("method");

//        console.log('data = ' + data);
//        console.log('action = ' + action);
//        console.log('method = ' + method);

    soal.kategori.id = $("#kategoriId").val();
    soal.pertanyaan = $("#pertanyaan").val();

    var kunci=$("#kunci").val();

    var status=false;
    if(kunci=="A")status=true;
    var jawabanA={
        pilihan:$("#jawabanA").val(),
        kebenaran:status
    };
    status=false;
    if(kunci=="B")status=true;
    var jawabanB={
        pilihan:$("#jawabanB").val(),
        kebenaran:status
    };
    status=false;
    if(kunci=="C")status=true;
    var jawabanC={
        pilihan:$("#jawabanC").val(),
        kebenaran:status
    };
    status=false;
    if(kunci=="D")status=true;
    var jawabanD={
        pilihan:$("#jawabanD").val(),
        kebenaran:status
    };

    soal.jawabans[0]=jawabanA;
    soal.jawabans[1]=jawabanB;
    soal.jawabans[2]=jawabanC;
    soal.jawabans[3]=jawabanD;

    var success = false;

    $.ajax({
        url:action,
        type:method,
        data:JSON.stringify(soal),
        contentType:"application/json; charset=utf-8",
        success:function (result) {
            success = (result + "").toLowerCase() == "sukses" ? true : false;
            alert(result);

            //jika sukses matikan dialog
            if (success) {
                $('#modal').modal('hide');
                reload();
            }

        },
        error:function (xhr, status, error) {
            alert(status);
        }
    });

    return success;
});

/**
 * inisialisasi awal soal
 * @param tipe
 */
function soalInit(p) {

//    console.info(t);

    //inisialisasi awal tipe
    soal = p;
    if (soal == null) {
        soal = {
            id:null,
            pertanyaan:null,
            kategori:null,
            isView:null,
            jawabans:null
        }
    }
    if (soal.kategori == null) {
        soal.kategori = { id:null, nama:null };
    }
    if (soal.jawabans == null) {
        soal.jawabans = new Array();
    }

}

