$(document).ready(function () {
    $('.single-item').slick({
        infinite: true,
        speed: 1000,
        slidesToShow: 1,
        adaptiveHeight: true,
        autoplay: true,
        auotoplaySpeed: 1000,
        arrows: false
    });

    $('#fullpage').fullpage({
        autoScrolling: true,
        scrollHorizontally: true
    });

    $(".imo_div").click(function () {
        if ($(".imo_div").hasClass("off")) {
            $(".imo_two").animate({
                bottom: "+=70",
            }, 1000);
            $(".imo_three").animate({
                bottom: "+=140",
            }, 1000);
            $(".imo_four").animate({
                bottom: "+=210",
            }, 1000);
            $(".imo_div").removeClass("off");
            $(".imo_div").addClass("on");
        } else if ($(".imo_div").hasClass("on")) {
            $(".imo_two").animate({
                bottom: "-=70",
            }, 1000);
            $(".imo_three").animate({
                bottom: "-=140",
            }, 1000);   
            $(".imo_four").animate({
                bottom: "-=210",
            }, 1000);
            $(".imo_div").removeClass("on");
            $(".imo_div").addClass("off");
        }
    });


    $(function () {
        $(".header_img").click(function () {
            if ($(".login").hasClass("no_open")) {
                $('ul:first', this).show();
                $(".login").removeClass("no_open");
                $(".login").addClass("open");
            } else {
                $('ul:first', this).hide();
                $(".login").removeClass("open");
                $(".login").addClass("no_open");
            }


        });
    });


    $(".register_agree").click(function () {


        if ($("input:checkbox[name=term1]:checked").length !=
            $("input:checkbox[name=term1]").length) {
            alert("약관 전부 동의해주세요!");
        } else {
            location.href = 'createid.html';
        }

    });

    $(".register_no_agree").click(function () {
        location.href = 'login.html';
    });
    $('.check_all').click(function () {
        if ($("input:checkbox[name=term2]").is(":checked") != true) {
            $("input[name=term1]:checkbox").prop("checked", false);
        } else {
            $("input[name=term1]:checkbox").prop("checked", true);

        }
    });
    


    url = "samsung_phone.json";


    $(".ab").click(function () {
        alert("ㅎㅇ");
        var count = $(this).val();
        alert("성공");
        // if($(this).hasClass("no_check")){
        //     check=0;  //체크할때
        // }else{
        //     check=1;
        // }
        $.ajax({
            url: url,
            type: "GET",
            cache: false,
            success: function (data, status) {
                    checkJSON(data, count);

                        $('.new_box').click(function(){

                            var one = $(this).val();
                            $.ajax({
                                url: url,
                                type: "GET",
                                cache: false,
                                success: function (data, status) {
                                    
                                    imgJSON(data,one,count);
                                    
                                }
                        });
                    });
            
        }});



    });
    


});


function checkJSON(xmlDOM, val) {
    var row = xmlDOM.phone;
    var idx = 0;

    if ($('.phone_hide  div').hasClass("box" + val)) {
        idx-=$('.phone_hide div').length;
        $('.box' + val).remove();
        return;
    }
    for (i = 0; i<row.length; i++) {
        if (val == row[i].value1 ) {
            $(".phone_hide").append("<div class='box" + val + " span"+idx+" box_min'><input type='checkbox' class='new_box "+val+"' name='boxbox' value='" + row[i].cal + "'><span class='span"+idx+"'>" + row[i].name + "</span></div>");
            idx++;
        }
    }
    

};


function imgJSON(xmlDOM, val,two){
    var row = xmlDOM.phone;
    if ($('.phone_img_hide  div').hasClass("box"+val+"box"+two)) {
        $('.box'+val+'box'+two).remove();
        return;
    };

    for(i=0;i<row.length;i++){
        if(val == row[i].cal  && two ==row[i].value1){
            $(".phone_img_hide").append("<div class='phone_img box"+val+"box"+two+" box"+two+"'><img src='"+row[i].image+"' style='width:200px;height:200px'/><div class='img_name'>"+row[i].name+"</div></div>");
            $(".phone_img_hide").append();
            return;
        }
    }
}







