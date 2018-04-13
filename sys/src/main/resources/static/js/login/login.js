$(document).ready(function () {
    $("#login").on('click', function () {
        login();
    });
    // 支持回车键查询
    $(document).keypress(function(event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if (keycode == '13') {
            login();
        }
    });
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        login();
    }
});

function login() {
    /* $.ajax({
     type: "POST",
     url:  "/login/login",
     data: $('#signupForm').serialize(),
     success: function (r) {
     if (r.code == 0) {
     var index = layer.load(1, {
     shade: [0.1, '#fff'] //0.1透明度的白色背景
     });
     parent.location.href = '/index';
     } else {
     layer.msg(r.msg);
     }
     },
     });*/

    //禁用超链接
    $('a').addClass('disabled');
    $.ajax({
        url : "/login/login",
        type : "POST",
        dataType : "json",
        data : $('#signupForm').serialize(),
        beforeSend : function() {

        },
        complete : function(jqXHR, textStatus) {
        },
        success : function(result) {
            if(result.code==0) {
                var index = layer.load(1, {
                    shade: [0.1,'#fff'] //0.1透明度的白色背景
                });
                parent.location.href = '/login/index';
            }else {
                layer.msg(result.message);
            }

        },
        error : function(jqXHR, textStatus, errorMsg) {
            layer.msg(errorMsg);
        }
    });
    $('a').removeClass('disabled');
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}