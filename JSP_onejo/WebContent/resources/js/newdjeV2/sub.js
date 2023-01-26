$(function () {
    navCtl();
});


// 220224 泥�궗�덈궡�� �덉씠�댄뙘��
$(function () {

    $(".show").click(function () {
        var imgsrc = $(this).children("img").attr("src");
        $("#modalbox>img").attr("src", imgsrc);
        $("#modal").fadeIn();
    });

 
    $("#cl2, #modal").click(function () {
        $("#modal").fadeOut();
    });

});



function navCtl() {
    var sideCon = $('#sideContent');
    var sideLink = $('.sideNavi a');
    var sideSub = $('.sideNavi ul li ul');
    var current = $.trim($('#location strong').text());

    $('#sideContent a').focus(function () {
        $('#gnb >ul > li > ul').css('top', -500);
        $('.bgGnb').hide();
    });

    sideLink.each(function () {
        if ($(this).text() == current) {
            $(this).addClass('lock');
            if ($(this).parent().parent().size() > 0) {
                $(this).parent().parent().addClass('lock').prev('a').addClass('lock').next().slideToggle();
            }
            $(this).parents('.sideNavi').prev().addClass('on');
        }
    });
    sideLink
        .hover(
            function () {
                if ($(this).next('ul').size() > 0 && !$(this).hasClass('lock') && !$(this).hasClass('on')) {
                    sideSub.not('.lock').slideUp();
                    sideLink.removeClass('on');
                    $(this).addClass('on').next().slideToggle();
                }
            },
            function () {

            }, 300
        )
        .bind('click', function (ev) {
            if ($(this).next('ul').size() > 0) {
                ev.preventDefault();
                sideSub.not('.lock').slideUp();
                sideLink.removeClass('on');
                $(this).addClass('on').next().slideToggle();
            }

        });
    sideCon.bind('mouseleave blur', function () {
        sideLink.not('.lock').removeClass('on');
        sideSub.not('.lock').delay(300).slideUp();
    });

}


//sns
$(function () {
    $('.snsBox button.btnShare').click(function () {
        $(this).next().slideToggle(300);
    });

});

// document ready
$(function () {
    listsList();
    faqList();
	LNB();
});


// 由ъ뒪��
function listsList() {
    $('.listDetail .view > a').off('click');
    $('.listDetail .view > a').on('click', function () {
        var title = $(this).parent('.view');
        if (title.hasClass('on')) {
            $(".listDetail .view").removeClass("on");
        } else {
            title.addClass("on");
            $(".listDetail .view").not(title).removeClass("on");
        }
    });
}

// �먯＜臾삳뒗吏덈Ц(FAQ)
function faqList() {
    $('.faqDetail .faq > a').off('click');
    $('.faqDetail .faq > a').on('click', function () {
        var title = $(this).parent('.faq');
        if (title.hasClass('on')) {
            $(".faqDetail .faq").removeClass("on");
        } else {
            title.addClass("on");
            $(".faqDetail .faq").not(title).removeClass("on");
        }
    });
}

// �쇱そ硫붾돱
function LNB() {
	var $lnb = $(".lnb");
	var lnbLink = $('.lnb a');
	var current = $.trim($('.location strong').text());
	var paCurrent = $.trim($('.location .navi_0').text());

	$lnb.find('> li').each(function(){
		
		if($(this).find('ul.subLnb').length > 0){
			$(this).addClass("dep01");
			$(this).find(' > a').click(function(e){ //�쇱そ硫붾돱 �쇱퀜吏덈븣 留곹겕 �덊�寃�
				e.preventDefault();
			});
		}

		$(this).not('.on').find(' > a').click(function(e){
			
			find_li = $(this).parent('li');
			if(find_li.hasClass('open')){
				$lnb.find('> li').not('.on').find('.subLnb').stop().slideUp();
				setTimeout(function(){
					find_li.removeClass('open');
				},400);
			}else{
				$lnb.find('> li').removeClass('open');
				$lnb.find('> li').not('.on').find('.subLnb').stop().slideUp();
				$(this).next('.subLnb').stop().slideDown();
				find_li.addClass('open');
			}
		});
	});
	
	$('#menu h2').click(function() {
		if ($(window).width() <= 1299) {
			$(this).toggleClass('on').next().slideToggle(600);
		}
	});

	/* 諛섏쓳�� �뗮똿 */
	$(window).resize(function(){
		winSize = $(window).width();
		console.log(winSize);
		if(winSize > 1284 ){
			console.log("pc");
			$('#menu nav').css('display','block');
		}else{
			console.log("紐⑤컮��");
			$('#menu nav').css('display','none');
		}
	}).resize();

	$('#mobNav .d02 ul:not(.d03)').each(function(){
		$(this).find('.dep').each(function(){
			if($(this).find('ul.d03').length > 0){
				if($(this).find('> a').attr('target') != '_blank'){
					$(this).find('> a').attr('href','#');
				}
			}
		});
	});

}