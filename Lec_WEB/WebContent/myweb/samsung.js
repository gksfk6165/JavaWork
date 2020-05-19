url = "samsung_phone.json";


$("input:checkbox").click(function () {
    var count = $(this).val();
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


function check_login(){
    var id = $(".system").val();
    var pw = $(".1234").val();
    if(id ==""){
        $(".check").text("아이디를 입력해주세요");
        return;
    }
    if( pw==""){
        $(".check").text("비밀번호를  입력해주세요");
        return;
        
    }


    if(id =="system" && pw=="1234"){
       alert("로그인 성공~~");
       $("form").submit();
       $(".system").val("");
       $(".1234").val("");
       return;

    }else{
        alert("로그인 실패~~")
        $(".system").val("");
       $(".1234").val("");
       return;
    }



}
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

$(".create_ok").click(function(){
    var id = $(".id_check").val();
    var pw = $(".pw_check").val();
    var email = $(".email_check").val();
    var juso = $(".juso").val();

    checking(id,pw,email,juso);


});

function checking(id,pw,email,juso){

    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if(id !="" && pw !=""){

        if(regExp.test(email)){

            if(juso != ""){
               location.href="main.html";
            }
            else{
                alert("주소를 입력해주세요");
            }

        }else{
            alert("이메일 양식이 어긋납니다.")
        }

    }else{
        alert("아이디 와 비밀번호를 다시 확인해주세요");
    }
}



var slideIndex = 1;
        showSlides(slideIndex);
        
        function plusSlides(n) {
          showSlides(slideIndex += n);
        }
        
        function currentSlide(n) {
          showSlides(slideIndex = n);
        }
        
        function showSlides(n) {
          var i;
          var slides = document.getElementsByClassName("mySlides");
          var dots = document.getElementsByClassName("dot");
          if (n > slides.length) {slideIndex = 1}    
          if (n < 1) {slideIndex = slides.length}
          for (i = 0; i < slides.length; i++) {
              slides[i].style.display = "none";  
          }
          for (i = 0; i < dots.length; i++) {
              dots[i].className = dots[i].className.replace(" active", "");
          }
          slides[slideIndex-1].style.display = "block";  
          dots[slideIndex-1].className += " active";
        }
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

        