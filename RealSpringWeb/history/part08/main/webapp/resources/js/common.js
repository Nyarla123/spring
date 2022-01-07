var util = {
    requestSync: function (url, param, method, callback) {
        $.ajax({
            method: method,
            url: url,
            dataType: "JSON",
            data: param,
            error: function () { alert("error"); },
            success: callback
        });
    },
    initSelectBox: function (id, groupCode, value, select, service) {
        if (groupCode == null) return;
        var reqData = { upcd: groupCode };
        
        let serv = "/common/getCodeList";
        
        //서비스가 있을경우 공통코드가 아닌 서비스로 값 조회
        if (service) serv = service;
        
        util.requestSync(serv, reqData, 'GET'
            , function (data) {
                let obj = $('#' + id).get(0);
                obj.options.length = 0;
                if (select == "Y") obj.add(new Option("-select-", ""));
                
                for (var i = 0; i < data.codeList.length; i++) {
                    var item = data.codeList[i];
                    if (item.CODE == value) {
                        obj.add(new Option(item.VALUE, item.CODE, true, true)); // 3번쨰 selected 4번쨰 선택
                    }
                    else {
                        obj.add(new Option(item.VALUE, item.CODE));
                    }
                }
            }
        );
    },
    showLoad : function(url, name) {
        $("#frame").load(url, function(response, status) {
            if(status == 'error') {
                $(this).html(response);
            } 
            $(".text-primary").text(name);
        });
    }
};






