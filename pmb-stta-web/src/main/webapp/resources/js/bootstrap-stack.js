$(document).ready(function () {

    //distributor
    var accordianToggleDistributor = $('#accordianToggleDistributor');
    var accordianToggleKategori = $('#accordianToggleKategori');
    var accordianToggleSoal = $('#accordianToggleSoal');
    var accordianToggleUploadSoal = $('#accordianToggleUploadSoal');
    var accordianToggleUser = $('#accordianToggleUser');
    var accordianToggleHasil = $('#accordianToggleHasil');
    var accordianToggleSetting = $('#accordianToggleSetting');
    var accordianToggleGrade = $('#accordianToggleGrade');
    var accordianToggleStatistik = $('#accordianToggleStatistik');
    var accordianToggleKajur = $('#accordianToggleKajur');
    /**
     * Distributor Action
     */

    accordianToggleKategori.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/kategori/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/kategori', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });

    accordianToggleSoal.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/soal/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/soal', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });

    accordianToggleUploadSoal.click(function () {
        $.get('/cbt-pmb/soal/form', function (data) {
            $('#fillMyModalPlus').html(data);
            $('#modal').modal('show');
        });
    });

    accordianToggleUser.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/user/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/user', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });

    accordianToggleHasil.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/hasilUjian/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/hasilUjian', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });

    accordianToggleSetting.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/setting/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/setting', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });

    accordianToggleGrade.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/grade/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/grade', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });
    accordianToggleKajur.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/kajur/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/kajur', function (data) {
            $('#list2').html("");
            $('#bundleList').html(data);
        });
    });

    accordianToggleStatistik.click(function () {
        $('#myCarousel').remove();
        $.get('/cbt-pmb/statistik/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/cbt-pmb/statistik/pertama', function (data) {
            $('#bundleList').html(data);
        });
        $.get('/cbt-pmb/statistik/kedua', function (data) {
            $('#list2').html(data);
        });
    });


    $('div.pagination ul li').click(function () {
        $(this).addClass('active');
    });
});

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

var reload = function () {
};


//-----------------------------theme chart-------------------------------------

Highcharts.theme = {
    colors:["#DDDF0D", "#7798BF", "#55BF3B", "#DF5353", "#aaeeee", "#ff0066", "#eeaaee",
        "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
    chart:{
        backgroundColor:{
            linearGradient:[0, 0, 0, 400],
            stops:[
                [0, 'rgb(96, 96, 96)'],
                [1, 'rgb(16, 16, 16)']
            ]
        },
        borderWidth:0,
        borderRadius:15,
        plotBackgroundColor:null,
        plotShadow:false,
        plotBorderWidth:0
    },
    title:{
        style:{
            color:'#FFF',
            font:'16px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
        }
    },
    subtitle:{
        style:{
            color:'#DDD',
            font:'12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
        }
    },
    xAxis:{
        gridLineWidth:0,
        lineColor:'#999',
        tickColor:'#999',
        labels:{
            style:{
                color:'#999',
                fontWeight:'bold'
            }
        },
        title:{
            style:{
                color:'#AAA',
                font:'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
            }
        }
    },
    yAxis:{
        alternateGridColor:null,
        minorTickInterval:null,
        gridLineColor:'rgba(255, 255, 255, .1)',
        lineWidth:0,
        tickWidth:0,
        labels:{
            style:{
                color:'#999',
                fontWeight:'bold'
            }
        },
        title:{
            style:{
                color:'#AAA',
                font:'bold 12px Lucida Grande, Lucida Sans Unicode, Verdana, Arial, Helvetica, sans-serif'
            }
        }
    },
    legend:{
        itemStyle:{
            color:'#CCC'
        },
        itemHoverStyle:{
            color:'#FFF'
        },
        itemHiddenStyle:{
            color:'#333'
        }
    },
    labels:{
        style:{
            color:'#CCC'
        }
    },
    tooltip:{
        backgroundColor:{
            linearGradient:[0, 0, 0, 50],
            stops:[
                [0, 'rgba(96, 96, 96, .8)'],
                [1, 'rgba(16, 16, 16, .8)']
            ]
        },
        borderWidth:0,
        style:{
            color:'#FFF'
        }
    },


    plotOptions:{
        line:{
            dataLabels:{
                color:'#CCC'
            },
            marker:{
                lineColor:'#333'
            }
        },
        spline:{
            marker:{
                lineColor:'#333'
            }
        },
        scatter:{
            marker:{
                lineColor:'#333'
            }
        },
        candlestick:{
            lineColor:'white'
        }
    },

    toolbar:{
        itemStyle:{
            color:'#CCC'
        }
    },

    navigation:{
        buttonOptions:{
            backgroundColor:{
                linearGradient:[0, 0, 0, 20],
                stops:[
                    [0.4, '#606060'],
                    [0.6, '#333333']
                ]
            },
            borderColor:'#000000',
            symbolStroke:'#C0C0C0',
            hoverSymbolStroke:'#FFFFFF'
        }
    },

    exporting:{
        buttons:{
            exportButton:{
                symbolFill:'#55BE3B'
            },
            printButton:{
                symbolFill:'#7797BE'
            }
        }
    },

    // scroll charts
    rangeSelector:{
        buttonTheme:{
            fill:{
                linearGradient:[0, 0, 0, 20],
                stops:[
                    [0.4, '#888'],
                    [0.6, '#555']
                ]
            },
            stroke:'#000000',
            style:{
                color:'#CCC',
                fontWeight:'bold'
            },
            states:{
                hover:{
                    fill:{
                        linearGradient:[0, 0, 0, 20],
                        stops:[
                            [0.4, '#BBB'],
                            [0.6, '#888']
                        ]
                    },
                    stroke:'#000000',
                    style:{
                        color:'white'
                    }
                },
                select:{
                    fill:{
                        linearGradient:[0, 0, 0, 20],
                        stops:[
                            [0.1, '#000'],
                            [0.3, '#333']
                        ]
                    },
                    stroke:'#000000',
                    style:{
                        color:'yellow'
                    }
                }
            }
        },
        inputStyle:{
            backgroundColor:'#333',
            color:'silver'
        },
        labelStyle:{
            color:'silver'
        }
    },

    navigator:{
        handles:{
            backgroundColor:'#666',
            borderColor:'#AAA'
        },
        outlineColor:'#CCC',
        maskFill:'rgba(16, 16, 16, 0.5)',
        series:{
            color:'#7798BF',
            lineColor:'#A6C7ED'
        }
    },

    scrollbar:{
        barBackgroundColor:{
            linearGradient:[0, 0, 0, 20],
            stops:[
                [0.4, '#888'],
                [0.6, '#555']
            ]
        },
        barBorderColor:'#CCC',
        buttonArrowColor:'#CCC',
        buttonBackgroundColor:{
            linearGradient:[0, 0, 0, 20],
            stops:[
                [0.4, '#888'],
                [0.6, '#555']
            ]
        },
        buttonBorderColor:'#CCC',
        rifleColor:'#FFF',
        trackBackgroundColor:{
            linearGradient:[0, 0, 0, 10],
            stops:[
                [0, '#000'],
                [1, '#333']
            ]
        },
        trackBorderColor:'#666'
    },

    // special colors for some of the demo examples
    legendBackgroundColor:'rgba(48, 48, 48, 0.8)',
    legendBackgroundColorSolid:'rgb(70, 70, 70)',
    dataLabelsColor:'#444',
    textColor:'#E0E0E0',
    maskColor:'rgba(255,255,255,0.3)'
};

var highchartsOptions = Highcharts.setOptions(Highcharts.theme);


//
//$(function(){
//    $('#chevron1').toggle(
//        function (){
//            $('#chevron1a').hide();
//        },
//        function (){
//            $('#chevron1a').show();
//        }
//    );
//});


//animasi sidebar

$(function () {


    $('a[data-stack|="dashboard"]').click(function () {
        $(this).addClass('btn-danger');

        $('a[data-stack|="barang"]').removeClass('btn-danger');

    });

    $('a[data-stack|="barang"]').click(function () {
        $(this).addClass('btn-danger');

        $('a[data-stack|="dashboard"]').removeClass('btn-danger');

    });

//    $('a[data-stack|="distributor"]').click(function(){
//        $(this).removeClass('badge-inverse').addClass('badge-warning');
//        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
//    });
//
//    $('a[data-stack|="pelanggan"]').click(function(){
//        $(this).removeClass('badge-inverse').addClass('badge-warning');
//        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
//    });
//
//    $('a[data-stack|="deposit"]').click(function(){
//        $(this).removeClass('badge-inverse').addClass('badge-warning');
//        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
//    });
//
//    $('a[data-stack|="transaksi"]').click(function(){
//        $(this).removeClass('badge-inverse').addClass('badge-warning');
//        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
//    });
//
//    $('a[data-stack|="laporan"]').click(function(){
//        $(this).removeClass('badge-inverse').addClass('badge-warning');
//        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
//    });
//
//    $('a[data-stack|="setting"]').click(function(){
//        $(this).removeClass('badge-inverse').addClass('badge-warning');
//        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
//        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
//    });


});