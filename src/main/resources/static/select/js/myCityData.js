var myCityData= '';
$.ajax({
    url:"/getCitys1",
    type :"get",
    dataType : "JSON",
    data : {},
    success: function(data){
        myCityData=data;
        $('#cityMR').hsCheckData({
            isShowCheckBox: true,
            minCheck: 1,//默认为0，不限最少选择个数
            maxCheck: 12,//默认为0，不限最多选择个数
//        data: cityData
            data: myCityData,
        });
        showCharts();
    }
})

// var myCityData=[
//     {"上海":"上海"},
//     {"北京":"北京"},
//     {"重庆":"重庆"},
//     {"深圳":"深圳"},
//     {"秦皇岛":"秦皇岛"},
//     {"测试":"测试"}
// ]