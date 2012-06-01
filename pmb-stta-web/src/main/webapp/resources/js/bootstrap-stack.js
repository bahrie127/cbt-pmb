$(document).ready(function () {

    //distributor
    var accordianToggleDistributor = $('#accordianToggleDistributor');
    var accordianToggleDeposit = $('#accordianToggleDeposit');
    var accordianToggleDiskon = $('#accordianToggleDiskon');
    var accordianToggleMerek = $('#accordianToggleMerek');
    var accordianTogglePelanggan = $('#accordianTogglePelanggan');
    var accordianToggleTipe = $('#accordianToggleTipe');
    var accordianToggleTransaksi = $('#accordianToggleTransaksi');
    var accordianToggleBank = $('#accordianToggleBank');
    var accordianToggleCash = $('#accordianToggleCash');
    var accordianTogglePenjualan = $('#accordianTogglePenjualan');
    var accordianTogglePembelian = $('#accordianTogglePembelian');
    var accordianToggleOngkosKirim = $('#accordianToggleOngkosKirim');
    var accordianToggleKategori = $('#accordianToggleKategori');
    var accordianToggleUkuran = $('#accordianToggleUkuran');
    var accordianToggleWarna = $('#accordianToggleWarna');
    var accordianToggleRoleGroup = $('#accordianToggleRoleGroup');
    var accordianToggleUser = $('#accordianToggleUser');
    var accordianHeadingLaporan = $('#accordianHeadingLaporan');

    /**
     * Distributor Action
     */

    accordianToggleDistributor.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/distributor/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/distributor', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleDeposit.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/deposit/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/deposit', function (data) {
            $('#bundleList').html(data);

        });
    });

    accordianToggleDiskon.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/diskon/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/diskon', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleMerek.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/merek/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/merek', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianTogglePelanggan.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/pelanggan/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/pelanggan', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleTipe.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/tipe/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/tipe', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleTransaksi.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/transaksi/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/transaksi', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleBank.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/bank/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/bank', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleCash.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/cash/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/cash', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianTogglePenjualan.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/penjualan/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/penjualan', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianTogglePembelian.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/pembelian/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/pembelian', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleOngkosKirim.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/ongkoskirim/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/ongkoskirim', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleKategori.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/kategori/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/kategori', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleUkuran.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/ukuran/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/ukuran', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleWarna.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/warna/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/warna', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleRoleGroup.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/roleGroup/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/roleGroup', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianToggleUser.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/user/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/user', function (data) {
            $('#bundleList').html(data);
        });
    });

    accordianHeadingLaporan.click(function () {
        $('#myCarousel').remove();
        $.get('/flatout/report/navbar', function (dataNavBar) {
            $('#bundleNavbar').html(dataNavBar);
        });
        $.get('/flatout/chart', function (data) {
            $('#bundleList').html(data);
        });
    });

    $('div.pagination ul li').click(function(){
        $(this).addClass('active');
    });
});

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
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

var reload = function(){};


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

$(function(){


    $('a[data-stack|="dashboard"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="barang"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="distributor"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="pelanggan"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="deposit"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="transaksi"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="laporan"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="setting"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
    });

    $('a[data-stack|="setting"]').click(function(){
        $(this).removeClass('badge-inverse').addClass('badge-warning');
        $('a[data-stack|="dashboard"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="barang"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="distributor"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="pelanggan"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="deposit"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="transaksi"]').removeClass('badge-warning').addClass('badge-inverse');
        $('a[data-stack|="laporan"]').removeClass('badge-warning').addClass('badge-inverse');
    });




});

