
/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	Gnb Function	

/////////////////////////////////////////////////////////////////////////////////////////////////////////// */
$(function () {

    var device_state;

    $(window).load(responsiveFn).resize(responsiveFn);

    function responsiveFn() {
        var window_w = $(window).width() + 17;

        if (window_w >= 1200) {

            if (device_state != "pc") {
                device_state = "pc";

                $(".mgnb .close").trigger("click");

                $("#content .cont").removeAttr("style");
            }

        } else if (window_w < 1200 && window_w >= 900) {

            if (device_state != "tablet") {
                device_state = "tablet";

                if (!$(".favor_list").is(":visible")) {
                    $(".menu_list .close").trigger("click");
                }

                //cont min-height
                var leftHeight = $("#snb").height();
                $("#content .cont").css("min-height", leftHeight - 100);

            }

        } else if (window_w < 769) {

            if (device_state != "mobile") {
                device_state = "mobile";

                $("#content .cont").removeAttr("style");

            }

        }
    }

    var allmenu_focus = null;
    $(".allm > a").on("click", function () {
        allmenu_focus = $(this);
        $(".backscreen").show();
        $(".menu_list").show();
    })
    $(".menu_list .close").on("click focusout", function () {
        $(".backscreen").hide();
        $(".menu_list").hide();
        if (allmenu_focus) {
            allmenu_focus.focus();
        }
    })

    $(".gnb .gnb_wrap .d01 > ul > li").on("mouseenter focusin", function () {
        $(this).children("div").stop().slideDown();
        return false;
    })
    $(".gnb .gnb_wrap .d01 > ul > li").on("mouseleave focusout", function () {
        $(this).children("div").stop().slideUp();
        return false;
    })

    $("#snb .d02 > ul > li > a").on("click focusin", function () {
        $(this).parent().addClass("on").siblings().removeClass("on");
        $(this).parent().children("ul").slideDown().parent().siblings().children("ul").slideUp();
        if ($(this).next().length) return false;
        //return false;
    })
    $("#snb .d03 > li > a").on("click", function () {
        $(this).parent().addClass("cur").siblings().removeClass("cur");
        //return false;
    });

    var txt_loc02 = $(".loc > p > .d01").text();
    $("#snb .d02 > ul > li").each(function (dix) {
        var txt_a = $("> a", this).text();
        //console.log(txt_loc02 +"== "+txt_a);
        if (txt_loc02 == txt_a) {
            $(this).addClass("on").siblings().removeClass("on");
            $(this).children("ul").show();
        }
    });

    var txt_loc03 = $(".loc > p > .d02").text();

    $("#snb .d03 > li").each(function (dix) {
        var txt_a = $("a", this).text();
        if (txt_loc03 == txt_a) {
            $(this).addClass("cur").siblings().removeClass("cur");
        }
    });

    $("#header button.search_btn").on("click", function () {
        $(this).toggleClass("_close");
        $(".search").toggleClass("_show");
    });

    //INDEX SERVICE
    $('#gnb .gnb_wrap').clone(false).appendTo($("#allNav"));
    $('#allNav').find('.head').remove();


    //Mobile Navigation
	$('<div id="mobNav"><div class="box"><strong class="title">�꾩껜硫붾돱</strong><div class="binds"></div><a href="#" class="close">�リ린</a></div><span class="blind"></span></div>').prependTo($("#wrap"));
    $('#gnb .gnb_wrap').clone(false).appendTo($("#mobNav >.box > .binds"));
    $('#mobNav').find('.head').remove();
	
	$(".mob_btn").click(function(){
		$("body,html").stop().animate({"scrollTop":"0"},50,function(){
			$("#mobNav").show().stop().animate({"opacity":1},300,function(){
				$(this).find(">.box").stop().animate({"left":0},300); 
			});
			$("#wrap").height($(document).height()); /* 200601 */
			$("#mobNav").height($(document).height());		
		});

		/* 200601 */
		/* 由ъ궗�댁쫰��, 紐⑤컮�� 硫붾돱 �リ린 */
		$(window).resize(function(){
            winW = $(window).width();
            console.log(winW);
            if(winW > 1183){
                if($("#mobNav").css('display')=='block'){
                    $("#mobNav").hide();
                    $("#mobNav").find(">.box").css({"left":-100+"%"});
                    /*
                    $("#mobNav").find(">.box").stop().animate({"left":-100+"%"},200,function(){ 
                        $(this).parent().stop().animate({"opacity":0},200,function(){
                            $(this).hide();	
                        });
                        $("#wrap, #mobNav").removeAttr("style");
                    });	*/
                }
            }
        });

		return false;
	});

	$("#mobNav .box .close").click(function(){
		$("#mobNav").find(">.box").stop().animate({"left":-100+"%"},300,function(){ 
			$(this).parent().stop().animate({"opacity":0},300,function(){
				$(this).hide();	
			});
			$("#wrap, #mobNav").removeAttr("style");
		});	
		return false;
    });
    
    

    /* dep setting */
    $('#mobNav .d01 > ul > li').each(function(){
        if($(this).find('div.d02 > ul').length > 0){
            $(this).addClass('dep');
        }
    });
    $('#mobNav .d02 > ul > li').each(function(){
        if($(this).find('ul.d03').length > 0){
            $(this).addClass('dep');
        }
    });

    $gnb = $('#mobNav .gnb_wrap');
    $gnb_D01 = $('#mobNav .gnb_wrap').find(".d01");
    $gnb_D02 = $('#mobNav .gnb_wrap').find(".d02");
    $gnb_D03 = $('#mobNav .gnb_wrap').find(".d03");

    $gnb_D01.find('> ul > li > a').on('click',function(){
        $findD02 = $(this).next('div').find('.d02');
        if($findD02.find('>ul').css('display')=='block'){
            $gnb_D01.find('> ul > li > a').removeClass('open')
            $gnb_D02.find('> ul').stop().slideUp();            
        }else{            
            $gnb_D01.find('> ul > li > a').removeClass('open')
            $(this).addClass('open');
            $gnb_D02.find('> ul').stop().slideUp();
            $findD02.find('>ul').stop().slideDown();
        }
    });

    $gnb_D02.find('> ul > li.dep > a').on('click',function(){
        $findD03 = $(this).next('ul.d03');
        if($findD03.css('display')=='block'){
            $gnb_D02.find('> ul > li.dep > a').removeClass('open');
            $gnb_D03.stop().slideUp();         
        }else{  
            $gnb_D02.find('> ul > li.dep > a').removeClass('open');
            $(this).addClass('open');          
            $gnb_D03.stop().slideUp();         
            $findD03.stop().slideDown();
        }
		return false;
    });

	$(window).resize(function(){
		if($("#mobNav").is(":visible")){
			$("#wrap").height($(document).height()); /* 200601 */
			$("#mobNav").height($(document).height());
		} else {
			$("#wrap, #mobNav").removeAttr("style");	
		}
	});	
	


});

function getWindow(url, w, h) {
    var position = "width=" + w + ",height=" + h + ",left=100,top=100,toolbar=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0";
    window.open(url, '', position);
}
/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////

�좏떥_寃���

/////////////////////////////////////////////////////////////////////////////////////////////////////////// */
$(function(){

	$('.search_btn button').click(function(){
		var confirm=$('#header .search').css('display');
		if(confirm=='block'){
			$('#header .search').fadeOut(100);
		}else{
			$('#header .search').fadeIn(100);
		};
	});
	$('.search_close button').click(function(){
		$('#header .search').hide();
		$(".search_btn button").focus();
	});
	
	function searchGo( frm ) {
								
		if( !frm.query.value ) {
			alert("寃��됱뼱瑜� �낅젰�댁＜�몄슂.");
			frm.query.focus();
			return false;
		}
		
		return true;
		
	}	


});


$(function(){

    // �ㅺ뎅�대━�ㅽ듃
    $(".lang").on("mouseenter focusin", function () {
        $(".lang").addClass('open');
        $(".lang > ul").stop().slideDown();
    })
    $(".lang").on("mouseleave focusout", function () {
        $(".lang").removeClass('open');
        $(".lang > ul").stop().slideUp();
    })

     $(window).scroll(function() {
		if ($(this).scrollTop() > 300) {
			$('#moveTop').fadeIn();
		} else {
			$('#moveTop').fadeOut();
		}
	});
	
	$("#moveTop a").click(function() {
		$('html, body').animate({
			scrollTop : 0
		}, 400);
		return false;
	});
});


/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////

�명꽣 �щ씪�대뵫 諛뺤뒪	

/////////////////////////////////////////////////////////////////////////////////////////////////////////// */
$(function(){     
    $('.ftBtn_wrap button.ftBtn').click(function() {
        $siteList =  $(this).next('.ft_site');
        if($(this).hasClass('open')){
            $(this).removeClass('open');
            $siteList.stop().slideUp();    
        }else{             
            $(this).addClass('open');          
            $siteList.stop().slideDown();    
        }
    });
});


var scale = 1;
 
function scaleIn() {
scale *= 1.03;
zoom(scale);
}
 
function scaleOut() {
scale /= 1.03;
zoom(scale);
}

function scaleInit() {
scale = 1;
zoom(scale);
}
 
function zoom(scale) {

	var wrap = document.getElementById("wrap");
	wrap.style.zoom = scale;  // IE
	wrap.style.webkitTransform = 'scale('+scale+')';  // Webkit(chrome)
	wrap.style.webkitTransformOrigin = '0 0';
	wrap.style.mozTransform = 'scale('+scale+')';  // Mozilla(firefox)
	wrap.style.mozTransformOrigin = '0 0';
	wrap.style.oTransform = 'scale('+scale+')';  // Opera
	wrap.style.oTransformOrigin = '0 0';
}


$(function () {
	// 蹂��섏깮��!!!
	var menuRight = 228;
	var searchTop = 90;
	// �⑥닔�앹꽦!!!
	function test() {
		var winWidth = $(window).width();
        if (winWidth > 767 && winWidth < 1200) {
            menuRight = 228;
			searchTop = 90;
        }
	}
    function check() {
        // �⑥닔�몄텧!!!!
		test();
        $(".sitemap_btn").click(function () {
            $(".menu_all").css("display", "block");
            //$(".gnb_dim_m").addClass("on");
			
		});
		
        $(".btn_search").click(function () {
            $(".search_wrap").css("display", "block");			
            $(".search_wrap").stop().animate({
                "top": "80px"
            }, 300)
			//$(".gnb_dim_m").addClass("on");
        });
		
		$(".btn_closed").click(function () {
			$(".menu_all").css("display", "none");
			$(".search_wrap").css("display", "none");
			$(".sitemap_btn").focus();
			//$(".gnb_dim_m").removeClass("on");
        });	
		
    }
		
	check();
});

function XSS_Check(strTemp, level) {     
    if ( level == undefined || level == 0 ) {
      strTemp = strTemp.replace(/\<|\>|\"|\'|\%|\;|\(|\)|\&|\+|\-/g,"");		
    }
    else if (level != undefined && level == 1 ) {
      strTemp = strTemp.replace(/\</g, "&lt;");
      strTemp = strTemp.replace(/\>/g, "&gt;");
    }
    return strTemp;
  }


//寃��됱뿏吏�
function searchEngine() {
    if( searchForm.qt.value == "" ) {
      searchForm.qt.focus();
      return false;
    }
     searchForm.qt.value=XSS_Check(searchForm.qt.value,'1'); 
     return true;
}



//紐⑤컮�� 寃��됱뿏吏�
function siteSearchEngine() {
    if( siteSearchForm.topSearch_2.value == "" ) {
      alert("寃��됱뼱瑜� �낅젰�섏떗�쒖삤");
      siteSearchForm.topSearch_2.focus();
      return false;
    }
      return true;
}    



function sendSns(sns)
{
    var o;
    var _url = encodeURIComponent(location.href);
    var _txt = encodeURIComponent(document.title);
    var _br  = encodeURIComponent('\r\n');
 
    switch(sns)
    {
        case 'facebook':
            o = {
                method:'popup',
                url:'http://www.facebook.com/sharer/sharer.php?u=' + _url
            };
            break;
 
        case 'twitter':
            o = {
                method:'popup',
                url:'http://twitter.com/intent/tweet?text=' + _txt + '&url=' + _url
            };
            break;
 
        case 'me2day':
            o = {
                method:'popup',
                url:'http://me2day.net/posts/new?new_post[body]=' + _txt + _br + _url + '&new_post[tags]=epiloum'
            };
            break;
 
        case 'kakaotalk':
            o = {
                method:'web2app',
                param:'sendurl?msg=' + _txt + '&url=' + _url + '&type=link&apiver=2.0.1&appver=2.0&appid=dev.epiloum.net&appname=' + encodeURIComponent('�쒓뎅援먯쑁怨쇱젙�됯���'),
                a_store:'itms-apps://itunes.apple.com/app/id362057947?mt=8',
                g_store:'market://details?id=com.kakao.talk',
                a_proto:'kakaolink://',
                g_proto:'scheme=kakaolink;package=com.kakao.talk'
            };
            break;
 
        case 'kakaostory':
            o = {
                method:'web2app',
                param:'posting?post=' + _txt + _br + _url + '&apiver=1.0&appver=2.0&appid=dev.epiloum.net&appname=' + encodeURIComponent('�쒓뎅援먯쑁怨쇱젙�됯���'),
                a_store:'itms-apps://itunes.apple.com/app/id486244601?mt=8',
                g_store:'market://details?id=com.kakao.story',
                a_proto:'storylink://',
                g_proto:'scheme=storylink;package=com.kakao.story'
            };
            break;
 
        case 'band':
            o = {
                method:'web2app',
                param:'create/post?text=' + _txt + _br + _url,
                a_store:'itms-apps://itunes.apple.com/app/id542613198?mt=8',
                g_store:'market://details?id=com.nhn.android.band',
                a_proto:'bandapp://',
                g_proto:'scheme=bandapp;package=com.nhn.android.band'
            };
            break;
 
        default:
            alert('吏��먰븯吏� �딅뒗 SNS�낅땲��.');
            return false;
    }
 
    switch(o.method)
    {
        case 'popup':
            window.open(o.url, "sns", 'width=626,height=436');
            break;
 
        case 'web2app':
            if(navigator.userAgent.match(/android/i))
            {
                // Android
                setTimeout(function(){ location.href = 'intent://' + o.param + '#Intent;' + o.g_proto + ';end'}, 100);
            }
            else if(navigator.userAgent.match(/(iphone)|(ipod)|(ipad)/i))
            {
                // Apple
                setTimeout(function(){ location.href = o.a_store; }, 200);          
                setTimeout(function(){ location.href = o.a_proto + o.param }, 100);
            }
            else
            {
                alert('�� 湲곕뒫�� 紐⑤컮�쇱뿉�쒕쭔 �ъ슜�� �� �덉뒿�덈떎.');
            }
            break;
    }
}

function goPrint() {
	 window.print(); 
 }

function goFrnd() {
	window.open('/dje/frnd/Finsert.do', 'frnd', 'width=410 height=550');
}

//�뱀랬�쎌젏 蹂댁셿 target=_blank �띿꽦 �쇱떆 rel="noopener noreferrer" 異붽� �ㅽ겕由쏀듃 2019-08-08 �≪쁺�� 
function noOpenerReferrer(){
   $('[target*=_blank]').attr('rel','noopener noreferrer');
} 