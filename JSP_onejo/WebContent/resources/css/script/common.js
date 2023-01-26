
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
function MM_showHideLayers2() {
  var i,p,v,obj,args=MM_showHideLayers2.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
	if (obj.style) { obj=obj.style; v=(v=='show')?'':(v=='none')?'none':v; }
	obj.display=v;}
}
function MM_openBrWindow(theURL,winName,features) { //v2.0

  window.open(theURL,winName,features);

}
// �뷀꽣 �대┃�� �ㅽ뻾�섎뒗 �묒뀡 媛� �섏씠吏��먯꽌 �꾩슂�� 留ㅼ냼�� �ъ젙��
function Load()
{
    if(event.keyCode==13)
    {   
       	enterDown();
    }
}

function enterDown()
{
	//searchStr�� �ъ빱�ㅺ� �덉쑝硫� 寃��� �ㅽ뻾
	//goSearch();
}

// KeyUp �대깽��
function keyUp()
{
	return;
}

// 寃��됯껐怨� �섏씠吏�
function goSearch()
{
	var forms = document.searchForm;
	
	if( forms.searchStr.value == null || forms.searchStr.value == "" )
	{
		alert("寃��됱뼱瑜� �낅젰�섏꽭��");
		forms.searchStr.focus();
		return false;
	} 
	
	window.open("", "search", "width=720 height=600 scrollbars=yes");
	forms.method = "POST";
	forms.target = "search";
	forms.action = "/search.do";
	forms.submit();
}

//���ъ씠利� ��
//寃���
function doSearch() {
	var searchForm = document.search; 

	if (searchForm.query.value == "") {
		alert("寃��됱뼱瑜� �낅젰�섏꽭��.");
		searchForm.query.focus();
		return;
	}
	if(searchForm.selectCollection.value=="ALL"){
		searchForm.collection.value = "ALL";
	}else{
		searchForm.collection.value = searchForm.selectCollection.value;
	}
	//searchForm.startDate.value = "";
	//searchForm.endDate.value = "";
	//searchForm.range.value = "A";
	//searchForm.startCount.value = 0;
	//searchForm.searchField.value = "ALL";
	//searchForm.sort.value = "DATE";
	 searchForm.action = "/search/search.jsp";

	//searchForm.target = "_blank";

	searchForm.submit();
}

//寃��됯껐怨� �뷀꽣
function onSearch()
{
	if( event.keyCode == 13) goSearch();
}

//�뷀꽣 泥댄겕	
function pressCheck() {   
	if (event.keyCode == 13) {
		return doSearch();
	}else{
		return false;
	}
}

//諛섏쓳�� 紐⑤컮��
//寃���
function doSearch_m() {
	var searchForm = document.search; 

	if (searchForm.query_m.value == "") {
		alert("寃��됱뼱瑜� �낅젰�섏꽭��.");
		searchForm.query_m.focus();
		return;
	}
	if(searchForm.selectCollection.value=="ALL"){
		searchForm.collection.value = "ALL";
	}else{
		searchForm.collection.value = searchForm.selectCollection.value;
	}
	//searchForm.startDate.value = "";
	//searchForm.endDate.value = "";
	//searchForm.range.value = "A";
	//searchForm.startCount.value = 0;
	//searchForm.searchField.value = "ALL";
	//searchForm.sort.value = "DATE";

 	 searchForm.query.value = searchForm.query_m.value;
	 searchForm.action = "/search/search.jsp";

	//searchForm.target = "_blank";

	searchForm.submit();
}

//�뷀꽣 泥댄겕	
function pressCheck_m() {   
	if (event.keyCode == 13) {
		return doSearch_m();
	}else{
		return false;
	}
}

//================= 誘몃땲由ъ뒪�� 留덉슦�ㅼ삤踰� =====================
function selMiniList(listID, listNum)
{
	for(i=1;i<10;i++)
	{
		var id = listID+i;
		if(document.getElementById(id) != null)
			document.getElementById(id).style.display = "none";
	}
	var id = listID+listNum;
	document.getElementById(id).style.display = "block";
}


//================= �앹뾽愿��� =====================
function getCookieKL( name ) 
{
	var nameOfCookie = name + "=";
	var x = 0;
	while ( x <= document.cookie.length ) 
	{
		var y = (x+nameOfCookie.length);
		if ( document.cookie.substring( x, y ) == nameOfCookie ) 
		{
			if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
				endOfCookie = document.cookie.length;
			return unescape( document.cookie.substring( y, endOfCookie ) ); 
		}
		x = document.cookie.indexOf( " ", x ) + 1;
		if ( x == 0 )
			break; 
	}
	return ""; 
}


//================= 硫붾돱愿��� =====================
function leftMenuView(idx)
{ 
	var str = "" + idx;

	for(i=100; i<150; i++)
	{
		if(document.getElementById("LMenu" + i))
		{
			hide_menu = document.getElementById("LMenu"+i);
			// 3�먮━ �댁긽 idx�쇰븣 �묐걹 �섎굹�� �섎씪�멸쾬怨� �쇱튂�섎뒗寃껋� 諛붾줈 �곸쐞 硫붾돱�대�濡� 媛먯텛吏� �딅뒗��.
			if(str.length >= 3 && isPrnt(str, i))
			{
				hide_menu.style.display = 'block';
			}
			else
			{
				hide_menu.style.display = 'none';
			}
		}
	}
	subMenu = document.getElementById("LMenu"+idx);
	if(subMenu != null)
		subMenu.style.display = 'block'; 
}

function isPrnt(str, idx)
{
	var subStr = str.substring(1,str.length-1);
	if(parseInt(subStr) == idx)
		return true;

	if(subStr.length >= 3 && isPrnt(subStr, idx))
		return true;

	return false;
}

function viewSiteMap(url){
 	if(document.getElementById("layerSiteMap").style.visibility == "hidden") 
 	{
  		document.getElementById("layerSiteMap").style.visibility = "visible";
  		document.getElementById("SiteMapFrm").src =url;  
 	}
 	else
 	{
  		document.getElementById("layerSiteMap").style.visibility = "hidden";
 	}
}

var prevIdx = 0;
function subMenuView(idx)
{ 
	hide_menu = document.getElementById("subMenu"+prevIdx);
	if(hide_menu != null && hide_menu.style.display  == 'block')
		hide_menu.style.display = 'none';
				
	subMenu = document.getElementById("subMenu"+idx);
	if(subMenu != null)
	{
		subMenu.style.display = 'block'; 
		prevIdx = idx
	}
}

//================= 硫붾돱愿��� =====================
function isValidSN(jumin1, jumin2)
{
	var ssn1 = jumin1;
	var ssn2 = jumin2;
	var ssn=ssn1+ssn2;
	a = new Array(13);
	for (var i=0; i < 13; i++) 
	{
		a[i] = parseInt(ssn.charAt(i));
	}
	var k = 11 - (((a[0] * 2) + (a[1] * 3) + (a[2] * 4) + (a[3] * 5) + (a[4] * 6) + (a[5] * 7) + (a[6] * 8) + (a[7] * 9) + (a[8] * 2) + (a[9] * 3) + (a[10] * 4) + (a[11] * 5)) % 11);
	if (k > 9)
	{
		k -= 10;
	}
	if (k == a[12])
		return true;
	else
		return false;	
}
function goLogin()
{
	//var forms = document.tmpForm;

	//forms.target = "tmpFrm";
	//forms.action = "/login/login/loginPop.jsp";
	//forms.submit();
	location.href="/index.do?m=0701&s=dje";
}
function eduLogin()
{
	var forms = document.boardForm;

	forms.action = "/eduLogin.do";
	forms.submit();
}

function goMsg()
{
	//alert("硫붿떊�� �낃렇�덉씠�쒗썑 �щ같�� �덉젙�낅땲��");
	var forms = document.tmpForm;

	forms.target = "tmpFrm";
	forms.action = "/msg.do";
	forms.submit();
	
}

function siteMap()
{
	window.open("/sitemap.do","login","width=900 height=620 scrollbars=yes");
}

// 濡쒓렇�몄꽌踰� �꾨찓�몄씠 �욎뿉 遺숈뼱�쇳븿
function chgInfo()
{
	var forms = document.tmpForm;
	
	forms.target = "tmpFrm";
	forms.action = "/chgInfoPop.jsp";
	forms.submit();
}

// �먮즺愿�由ъ옄�깆뿉�� �ъ슜�� 吏곸썝李얘린
function empSrch(reqUsrID, reqUsrNM, reqDeptCD, reqDeptNM, reqEMail, reqPhone)
{
	var url = "/sub/dje/dataMng/empSrch.jsp?usrID="+reqUsrID+"&usrNM="+reqUsrNM+"&deptCD="+reqDeptCD+"&deptNM="+reqDeptNM+"&email="+reqEMail+"&phone="+reqPhone;
	window.open(url, "empSrch", "width=550, height=500, scrollbars=yes");
}

// 沅뚰븳�ㅼ젙 李� �ㅽ뵂
function popupAuth(url, ele)
{
	var cnts = eval("document."+ele).value;
	url = url+"?Ele="+ele+"&Cnts="+cnts;

	window.open(url, '','width=600,height=400, scrollbars=yes, resizable=yes');
}

function allSrch(reqUsrID, reqUsrNM, reqDeptCD, reqDeptNM, reqEMail, reqPhone)
{
	var url = "/sub/dje/dataMng/allSrch.jsp?usrID="+reqUsrID+"&usrNM="+reqUsrNM+"&deptCD="+reqDeptCD+"&deptNM="+reqDeptNM+"&email="+reqEMail+"&phone="+reqPhone;
	window.open(url, "empSrch", "width=550, height=500, scrollbars=yes");
}

// �ㅽ듃留곸쓽 str1�� �대떦�섎뒗 臾몄옄�댁쓣 str2濡� 諛붽씔��.
// �ъ슜踰�.
// var str = 臾몄옄��.replaceAll("a", "1");  <-- 臾몄옄�� �댁뿉�� 'a'瑜� 李얠븘 �꾨� '1'濡� 諛붽씀�쇰뒗 �섎�
/*String.prototype.replaceAll = function(str1, str2)
{
  	var temp_str = "";

  	if (this.trim() != "" && str1 != str2)
  	{
    	temp_str = this.trim();

   	 	while (temp_str.indexOf(str1) > -1)
    	{
      		temp_str = temp_str.replace(str1, str2);
    	}
  	}
  return temp_str;
}*/

// 臾몄옄�댁쓣 �쒕쾲 諛붽씔��.
function replace(msrc,sstr,rstr) {
       var idx,sleft,sright;

       msrc+="";
       sstr+="";
       rstr+="";
       idx=msrc.indexOf(sstr);
       if (idx > -1) {
              sleft = msrc.substring(0,idx) + rstr;
              sright = msrc.substring(idx+sstr.length);
              return sleft + replace(sright,sstr,rstr);
       } else {
              return msrc;
       }
}

//================= �좎쭨 �좏깮 =====================
  function Popup_Date(reqRY, reqCallBack)
  {
	
	var wWidth = 300;
    var wHeight = 300;
    var wTop = (screen.height-100)/2; //200;//((screen.height - 100) - wHeight) / 2 ;
    var wLeft = (screen.width)/2 //200; //(screen.width - wWidth) / 2;
    

	
	 var screenWidth = screen.availwidth;
        var screenHeight = screen.availheight;

    var wTarget = 'KLFRAME_CALENDAR';
    var wAddr =  '/calendar/main.do';

    wAddr = wAddr + '?R=' + reqRY
    wAddr = wAddr + '&T=S'
	if(reqCallBack != null)
		wAddr += '&CallBack=' + reqCallBack;

    wNewWin = window.open(wAddr, wTarget,'toolbar=no,menubar=no,location=no,directories=no,status=no,scrollbars=no,resizable=yes,width='+wWidth+',height='+wHeight+',top='+wTop+',left='+wLeft+'');
    wNewWin.focus();
  }
  
  //================= �좎쭨 �좏깮(��/��) =====================
  function Popup_Date_Month(reqRY, reqCallBack)
  {
    var wWidth = 300;
    var wHeight = 300;
    var wTop = ((screen.height - 100) - wHeight) / 2 ;
    var wLeft = (screen.width - wWidth) / 2;

    var wTarget = 'KLFRAME_CALENDAR';
    var wAddr =  '/calendar/mainMonth.do';

    wAddr = wAddr + '?R=' + reqRY
    wAddr = wAddr + '&T=S'
	if(reqCallBack != null)
		wAddr += '&CallBack=' + reqCallBack;

    wNewWin = window.open(wAddr, wTarget,'toolbar=no,menubar=no,location=no,directories=no,status=no,scrollbars=no,resizable=yes,width='+wWidth+',height='+wHeight+',top='+wTop+',left='+wLeft+'');
    wNewWin.focus();
  }
  //================= �좎쭨 �좏깮(��/��) =====================

  
  function Popup_Period(reqR, reqIdx)
  {
    var wWidth = 300;
    var wHeight = 300;
    var wTop = ((screen.height - 100) - wHeight) / 2 ;
    var wLeft = (screen.width - wWidth) / 2;

    var wTarget = 'KLFRAME_CALENDAR';
     var wAddr =  '/calendar/main.do';

    wAddr = wAddr + '?R=' + reqR
    wAddr = wAddr + '&Idx=' + reqIdx
    wAddr = wAddr + '&T=P'

    wNewWin = window.open(wAddr, wTarget,'toolbar=no,menubar=no,location=no,directories=no,status=no,scrollbars=no,resizable=yes,width='+wWidth+',height='+wHeight+',top='+wTop+',left='+wLeft+'');
    wNewWin.focus();
  }
  
  function pdInitl (reqIdx){
	  
	  $("#SDate"+reqIdx).val("");
	  $("#EDate"+reqIdx).val("");
	  
	  $("input[name=col"+reqIdx+"Cnts]").val("");
	  
  }
  //================= �좎쭨 �좏깮 =====================

  function Popup_Date(reqRY)
  {
	
	var wWidth = 300;
    var wHeight = 300;
    var wTop = (screen.height-100)/2; //200;//((screen.height - 100) - wHeight) / 2 ;
    var wLeft = (screen.width)/2 //200; //(screen.width - wWidth) / 2;
    

	
	 var screenWidth = screen.availwidth;
     var screenHeight = screen.availheight;

    var wTarget = 'KLFRAME_CALENDAR';
    var wAddr =  '/calendar/main.do';

    wAddr = wAddr + '?R=' + reqRY
    wAddr = wAddr + '&T=S'

    wNewWin = window.open(wAddr, wTarget,'toolbar=no,menubar=no,location=no,directories=no,status=no,scrollbars=no,resizable=yes,width='+wWidth+',height='+wHeight+',top='+wTop+',left='+wLeft+'');
    wNewWin.focus();
	
  }
  
//================= �앹뾽李� 而⑦듃濡� 愿��� =====================
function setCookieKL( name, value, expiredays ) 
{
	var todayDate = new Date();
	todayDate.setDate( todayDate.getDate() + expiredays );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
}

function getCookieKL( name ) 
{
	var nameOfCookie = name + "=";
	var x = 0;
	while ( x <= document.cookie.length ) 
	{
		var y = (x+nameOfCookie.length);
		if ( document.cookie.substring( x, y ) == nameOfCookie ) 
		{
			if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
				endOfCookie = document.cookie.length;
			return unescape( document.cookie.substring( y, endOfCookie ) ); 
		}
		x = document.cookie.indexOf( " ", x ) + 1;
		if ( x == 0 )
			break; 
	}
	return ""; 
}

function open_layer(frameName, name, seq)
{
	document.all[name].style.visibility = "visible";
	eval("document."+frameName).location.replace('/popupL.do?popType=L&seq='+seq);
} 

function open_PopN( name)
{
	document.all[name].style.visibility = "visible";
} 


function closePopN(name)
{
	document.all[name].style.visibility = "hidden";
	closeWin(name);
}

function closePopNDay(name)
{
	document.all[name].style.visibility = "hidden";
	setCookieKL( name, "done" , 1);
	closeWinDay(name);
}

function closeLayer(name)
{
	document.all[name].style.visibility = "hidden";
	closeWin(name);
}



function closeLayerDay(name)
{
	document.all[name].style.visibility = "hidden";
	setCookieKL( name, "done" , 1);
}

function closeWin(name)
{
	self.close();
}

function closeWinDay(name)
{
	self.close();
	setCookieKL( name, "done" , 1);
}
//================= �앹뾽李� 而⑦듃濡� 愿��� =====================

// �꾨젅�� �ъ씠利� 議곗젅
function selfResize(reqDiv, reqFrm)
{ 
	dataobj = document.getElementById(reqDiv) //

    dataobj.style.top=0 
    dataobj.style.left=0 

    pagelength=dataobj.offsetHeight
    pagewidth=dataobj.offsetWidth

    parent.document.getElementById(reqFrm).height=pagelength  
    parent.document.getElementById(reqFrm).width=pagewidth 
} 

//�고렪踰덊샇 寃���
function openZipcode(reqZip, reqAddr1)
{
	var url = "/common/zipcode.do?zipCode="+reqZip+"&addr="+reqAddr1;
	window.open(url,'','width=450,height=350,scrollbars=yes');
}

// �꾩닔�낅젰�ㅻ쪟泥댄겕
function cmnErrCertChk(reqForm, reqName, reqFoucs)
{
	if(reqForm.value == "")
	{
		alert(reqName +" �낅젰�댁＜�몄슂");
		reqForm.value = "";
		if(reqForm != null && reqFoucs != "N")
			reqForm.focus();
		return false;
	}
	return true;
}

// �レ옄�낅젰�ㅻ쪟泥댄겕
function numErrChk(reqForm, reqMsg)
{
	if(isNaN(reqForm.value) || reqForm.value=="")
	{
		if(reqMsg == null ) reqMsg = "";
		alert(reqMsg+"�レ옄留� �낅젰�좎닔 �덉뒿�덈떎");
		reqForm.value = "0";
		reqForm.focus();
		return false;
	}
	return true;
}
function cmnErrNumChk(reqForm)
{
	if(isNaN(reqForm.value) || reqForm.value=="")
	{
		if(reqMsg == null ) reqMsg = "";
		alert("�レ옄留� �낅젰�좎닔 �덉뒿�덈떎");
		reqForm.value = "0";
		reqForm.focus();
		return false;
	}
	return true;
}

// �곷Ц�좏슚�깆껜��
function engErrChk(reqForm, reqMsg)
{
	var eng_check = /^[a-zA-Z]+$/;

	if(!eng_check.test(reqForm.value) )
	{
		if(reqMsg == null ) reqMsg = "";
		alert(reqMsg+"�곷Ц留� �낅젰�� �� �덉뒿�덈떎.");
		
		return false;
	}
	return true;
}

// �곷Ц,�レ옄 �쇳빀�ъ슜 (��, 泥リ��먮뒗 �곷Ц,�レ옄留� 媛���, �뱀닔湲고샇以� -留� �덉슜)
function engNumErrChk(reqForm, reqMsg)
{
	// �곷Ц鍮꾧탳臾몄옄��
	var eng_check = /^[0-9a-zA-Z-]+$/;
	
	// �먮낯�낅젰
	var inputStr = reqForm.value;
	// 泥リ���
	var firstStr = inputStr.substr(0,1);
	// �섎㉧吏�湲���
	var etcStr = inputStr.substr(1,inputStr.length);
	
	if(etcStr==""){
		alert(reqMsg+"怨듬갚�� �낅젰�섏떎 �� �놁뒿�덈떎.");
		return false;
	}
	/*if(!eng_check.test(firstStr))
	{
		alert(reqMsg+"泥リ��먮뒗 �곷Ц留� �낅젰�� �� �덉뒿�덈떎.");
		return false;
	}*/

	if(isNaN(etcStr))
	{
		// �낅젰媛믪뿉�� �レ옄 �쒓굅
		strInput = etcStr.split("1").join("").split("2").join("").split("3").join("").split("4").join("").split("5").join("").split("6").join("").split("7").join("").split("8").join("").split("9").join("").split("0").join("");
		if(!eng_check.test(strInput)){
			if(reqMsg == null ) reqMsg = "";
			alert(reqMsg+"�곷Ц �먮뒗 �レ옄留� �낅젰�� �� �덉뒿�덈떎.");
			
			return false;
		}
	}
	
	return true;
}

// �대찓�� �좏슚�� 寃���
function CheckEMail (emailStr) 
{  
	// �꾩옄硫붿씪 �⑦꽩. �ъ슜�먯씠由�@�꾨찓�� �� �뺤떇�� 寃��ы븿  
	var emailPat=/^(.+)@(.+)$/;
	// �ы븿�섏� 留먯븘�쇳븷 �뱀닔臾몄옄�� ( ) < > @ , ; : \ " . [ ]  
	var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";  
	// �ы븿�� �� �덈뒗 �뱀닔臾몄옄�� (�섎㉧吏�)  
	var validChars="\[^\\s" + specialChars + "\]";  
	// �꾨옒�� 寃쎌슦�� �ъ슜�� �대쫫�� �곗샂�쒓� �덈뒗 寃쎌슦. RFC�쒖��ы빆��  
	var quotedUser="(\"[^\"]*\")"; 
	// �꾨찓�� ���� IP瑜� �ъ슜�� �섏엳��  
	// �덈� �ㅼ뼱 laday@[210.120.253.10]�� �щ컮瑜� 硫붿씪 二쇱냼 "[", "]"�� 諛섎뱶�� �꾩슂 
	var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/;  
	// 湲곕낯�곸씤 �꾪넗誘뱀뿉 �대떦��  
	var atom=validChars + '+';  
	// �ъ슜�먮줈 �ъ슜�� �� �덈뒗 臾몄옄瑜� �섑���  
	var word="(" + atom + "|" + quotedUser + ")";  
	// �ъ슜�먯쓽 �⑦꽩�� �섑���. �꾩쓽 �뚮뱶媛� .�⑥쐞濡� �щ윭媛� �� �섏엳��  
	var userPat=new RegExp("^" + word + "(\\." + word + ")*$");  
	// �꾨옒�� 寃껋� �쇰컲�곸씤 �꾨찓�� �⑦꽩�� �대떦��  
	var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$");  
	// @�� 湲곗��쇰줈 �ъ슜�먯� �꾨찓�몄쑝濡� �섎닎. �몄쓽瑜� �꾪븿  
	var matchArray=emailStr.match(emailPat);  
	if (matchArray==null) 
	{    
	// �먭컻 �댁긽 �먮뒗 @�� �꾩삁 �녿뒗 寃쎌슦   
		alert("硫붿씪二쇱냼 �뺤떇�� �섎せ�섏뼱 �덉뒿�덈떎 (怨듬갚 諛� @怨� .�� �뺤씤�� 蹂댁꽭��)");    
		return false; 
	}  
	var user=matchArray[1];  
	var domain=matchArray[2];  
	// �ъ슜�� 遺�遺꾩씠 �쒕�濡� �섏뿀�붿� 寃���  
	if (user.match(userPat)==null) 
	{    
		alert("硫붿씪 �꾩씠�붽� �щ컮瑜댁� �딆뒿�덈떎");    
		return false;  
	} 
	// �꾨찓�� 遺�遺꾩씠 IP濡� �섏뼱 �덈뒗 寃쎌슦 
	var IPArray=domain.match(ipDomainPat);  
	if (IPArray!=null) 
	{    
		for (var i=1;i<=4;i++) 
		{      
			if (IPArray[i]>255) 
			{        
				alert("IP 二쇱냼 �뺤떇�� �щ컮瑜댁� �딆뒿�덈떎");        
				return false;      
			}    
		}    
		return true;  
	}  
	// �꾨찓�� �대쫫�� �щ낵由� �ㅼ엫�� 寃쎌슦 �щ컮瑜댁� �딆쓬  
	var domainArray=domain.match(domainPat);  
	if (domainArray==null) 
	{    
		alert("�꾨찓�� �뺤떇�� �щ컮瑜댁� �딆뒿�덈떎");   
		return false; 
	}  
	// �꾨찓�� �뺤떇 寃��ъ뿉 �듦낵�덈뜑�쇰룄, 留덉�留� �멸컻 �먮뒗 �먭컻�� 臾몄옄(com, net, kr�깅벑)  
	// 源뚯� �щ컮瑜몄� 寃���. 理쒖긽�� �꾨찓�몄� 諛섎뱶�� �멸��� �꾨땲硫� �� 湲��먯엫  
	var atomPat=new RegExp(atom,"g");  
	var domArr=domain.match(atomPat);  
	var len=domArr.length;  
	if (domArr[domArr.length-1].length<2 ||    domArr[domArr.length-1].length>3) 
	{    
		alert("�꾨찓�� 二쇱냼�� 留덉�留� �꾨뱶�� 諛섎뱶�� �멸��� �꾨찓�� �먮뒗 �먭��� �섎씪�댁뼱�� �⑸땲��.");    
		return false; 
	}  
	// �몄뒪�몄씠由꾩씠 �덈뒗吏� 寃���  
	if (len<2) 
	{    
		alert("�몄뒪�� �대쫫�� 議댁옱�섏� �딆뒿�덈떎. �몄뒪�� �대쫫�� 諛섎뱶�� 2湲��� �댁긽�댁뼱�� �⑸땲��");    
		return false;  
	}  
	
	return true;
}	

// 硫붾돱諛붾줈媛�湲�
function quickMenu(obj)
{
	var strUrl = obj.options[obj.selectedIndex].value;
	if(strUrl != ""){
		location.href = strUrl;
	}
}

//�ъ씠�몃컮濡쒓�湲�
function quickSite(obj)
{
	var strUrl = obj.options[obj.selectedIndex].value;
	if(strUrl != ""){
		window.open(strUrl);
	}
}
 
function chkMenuAuth(auth){
	if( auth == "2" ){
		alert("�뚯썝留� �대엺�� �� �덈뒗 硫붾돱�낅땲��. �뚯썝媛��낇썑 �댁슜�섏꽭��.");
	}else if (auth == "3" ){
		alert("援먯쭅�먮쭔 �대엺�� �� �덈뒗 硫붾돱�낅땲��. 援먯쭅�� 濡쒓렇�� �� �댁슜�섏꽭��.");
	}else if (auth == "1" ){
		alert("�ㅻ챸�몄쬆�� �대엺�� �� �덈뒗 硫붾돱�낅땲��. �꾩씠�� 濡쒓렇�� �� �댁슜�섏꽭��.");
	}else if (auth == "4" ){
		alert("硫붾돱�대엺 沅뚰븳�� �놁뒿�덈떎.");
	}
	location.href = "/login.do?m=0906";
}

function showAllBanner()
{
	document.getElementById("all_banner_wrap").style.display='block';
}

function hideAllBanner()
{
	document.getElementById("all_banner_wrap").style.display='none';
}

// �낅젰 �띿뒪�� 湲몄씠 諛� �レ옄 泥댄겕
function chkNLength(reqForm, reqLength, reqChkNum)
{
	var val 		= eval("document."+reqForm);
	var str 		= val.value;
	var strByte 	= 0;
	var strLength 	= 0;
	
	// �レ옄 泥댄겕
	if(reqChkNum == "int")
	{
		if(isNaN(val.value))
		{
			alert("�レ옄留�  �낅젰�좎닔 �덉뒿�덈떎");
			val.value = "";
			return;
		}
	}
	
	for(var i=0;i<str.length;i++)
	{
		var ch = str.charAt(i);
		// �쒓�
		if(escape(ch).length > 4)
			strByte = strByte+2;
		else
			strByte++;
		
		if(strByte <= reqLength)
			strLength = i+1;
	}
	
	if(strByte > reqLength)
	{
		if(reqChkNum == "int")
			alert(reqLength + "�먮━ �대궡 �レ옄留� �낅젰�댁＜�몄슂");
		else
			alert("�쒓�"+parseInt(reqLength/2) + "�� �곷Ц"+reqLength+"�� �댁긽 �낅젰�섏떎�� �놁뒿�덈떎");
		
		val.value = str.substr(0, strLength);
	}
}
//url 蹂듭궗
function copyThis() {
	
	var IE = (document.all)?true:false;

	var curPage = document.location.href; 

	var IE11 = navigator.userAgent.search('Trident');

	if(IE || IE11!= -1){ //�듭뒪硫�
		window.clipboardData.setData("Text", curPage);
		alert(curPage+" 媛� 蹂듭궗�섏뿀�듬땲��.");
	}else{ //洹� �� 釉뚮씪�곗�硫�
		temp = prompt("Ctrl+C瑜� �뚮윭 �대┰蹂대뱶濡� 蹂듭궗�섏꽭��", curPage);
	}
}



//�숈쁺�� �낅줈��
function vodUpload(){
	var url = "/vod/up/Uploader.html";		
	//window.open(url , "uploader", "width=450, height=550").focus();
	window.open(url , "uploader", "width=450px, height=550px");
	
	
}
//�숈쁺�� return
function ResultAction(value)
{

	var result="";
	for(var i in value){
		if (i=="ukey") {
			document.getElementById("filePath").value = value[i];	
		}
		if (i=="filename") {
			document.getElementById("fileNM").value = value[i];
		}
	}
}

//�볤�蹂닿린 異붽�
function moreReply2(size) {
	document.getElementById('btnMore').style.display = 'none';
	for (i=5;i<size;i++) {
		document.getElementById('replay_more'+i).style.display = 'block';
	}
	
		 
}

//湲곌컙�쒓탳�� 珥덈벑 異붽�
function goTTmWrite() {
	window.open("/ttm/loginForm.do", "loginForm", "width=500 height=320");
}

//湲곌컙�쒓탳�� 以묐벑 異붽�
function goTTmMiddleWrite() {
	window.open("/ttmMiddle/loginForm.do", "loginForm", "width=500 height=320");
}

//湲곌컙�쒓탳�� 以묐벑 異붽�
function goTTmKinderWrite() {
	window.open("/ttmMiddle2/loginForm.do", "loginForm", "width=500 height=320");
}

//RSS 蹂듭궗
var sUserAgent = navigator.userAgent.toLowerCase();
var isOpera = sUserAgent.indexOf("opera") > -1;
var isIE = sUserAgent.indexOf("compatible") > -1
        && sUserAgent.indexOf("msie") > -1
        && !isOpera;
     
//IE 泥댄겕
var IE=(document.all)?true:false;
//IE11 泥댄겕
var IE11=sUserAgent.search('trident');

function copyUrl(url) {
    if(isIE || IE || IE11 != -1){
        window.clipboardData.setData('Text',url);
        window.alert("RSS �쇰뱶 二쇱냼媛� 蹂듭궗 �섏뿀�듬땲��.");
    } else {
	    try {
	        thisMovie('clipboardPoter').setClipBoard(url);
	    } catch(e) {
//	        if(isIE) {
//	            window.clipboardData.setData('Text',url);
//	            window.alert("二쇱냼媛� 蹂듭궗 �섏뿀�듬땲��.(JS)");
//	        }
	    	temp = prompt("蹂듭궗�댁꽌 �곗떆��", url);
			alert('蹂� 釉뚮씪�곗��먯꽌�� �대┰蹂대뱶 蹂듭궗湲곕뒫�� 吏��먮릺吏� �딆뒿�덈떎.');
	    }
	}
}

function Rssboard(url) {
	copyUrl(url);
}

function wrapWindowByMask(url) {

    // �붾㈃�� �믪씠�� �덈퉬瑜� 援ы븳��.
    var maskHeight = $(document).height();  
    // var maskWidth = $(document).width();
    var maskWidth = window.document.body.clientWidth;

    var mask = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
    var loadingImg = '';
    if(url == "/boardCnts/boardExcel.do"){
    	loadingImg += "<div id='loadingImg' style='position:absolute; left:50%; top:170%; display:none; z-index:10000;'>";
    }else{
    	loadingImg += "<div id='loadingImg' style='position:absolute; left:50%; top:50%; display:none; z-index:10000;'>";
    }
    loadingImg += " <img src='/images/common/viewLoading.gif'/>"; 
    loadingImg += "</div>";   

    //�붾㈃�� �덉씠�� 異붽� 
    $('body')
        .append(mask)
        .append(loadingImg)

    //留덉뒪�ъ쓽 �믪씠�� �덈퉬瑜� �붾㈃ 寃껋쑝濡� 留뚮뱾�� �꾩껜 �붾㈃�� 梨꾩슫��.
    $('#mask').css({
            'width' : maskWidth
            , 'height': maskHeight
            , 'opacity' : '0.3'
    });  

    //留덉뒪�� �쒖떆
    $('#mask').show();    

    //濡쒕뵫以� �대�吏� �쒖떆
    $('#loadingImg').show();

}

function closeWindowByMask() {
    $('#mask, #loadingImg').hide();
    $('#mask, #loadingImg').remove();   
}


function boardExcelDownload(url){
	wrapWindowByMask(url);
	setTimeout(function(){ boardExcelDownloadLoading(url); }, 3000);
}

function boardExcelDownloadLoading(url){
	location.href = url;
	closeWindowByMask();
}

function goBannerDiv(div) {
	if (div=='1') {
    	document.getElementById("bannerDiv1").style.display = "block";
    	document.getElementById("bannerDiv2").style.display = "none";
    	document.getElementById("bannerDiv3").style.display = "none";
    	document.getElementById("bannerDiv4").style.display = "none";
	} else if (div=='2') {
		document.getElementById("bannerDiv1").style.display = "none";
    	document.getElementById("bannerDiv2").style.display = "block";
    	document.getElementById("bannerDiv3").style.display = "none";
    	document.getElementById("bannerDiv4").style.display = "none";
	} else if (div=='3') {
		document.getElementById("bannerDiv1").style.display = "none";
    	document.getElementById("bannerDiv2").style.display = "none";
    	document.getElementById("bannerDiv3").style.display = "block";
    	document.getElementById("bannerDiv4").style.display = "none";
	} else if (div=='4') {
		document.getElementById("bannerDiv1").style.display = "none";
    	document.getElementById("bannerDiv2").style.display = "none";
    	document.getElementById("bannerDiv3").style.display = "none";
    	document.getElementById("bannerDiv4").style.display = "block";
	} else {
		document.getElementById("bannerDiv1").style.display = "block";
    	document.getElementById("bannerDiv2").style.display = "none";
    	document.getElementById("bannerDiv3").style.display = "none";
    	document.getElementById("bannerDiv4").style.display = "none";
	}
}

//�뱀랬�쎌젏 蹂댁셿 target=_blank �띿꽦 �쇱떆 rel="noopener noreferrer" 異붽� �ㅽ겕由쏀듃 
function noOpenerReferrer(){
   $('a[target*=_blank]').attr('rel','noopener noreferrer');
} 

//蹂몄껌 硫붿씤 ��,�덊봽�� 硫붾돱 , �숆탳�꾪솴寃��� , 諛곕꼫由ъ뒪�� 
function noOpenerReferrerMainMenu(){
	//��
	$('#ul_gnb_1').find('a[target*=_blank]').attr('rel','noopener noreferrer');
	//�덊봽��
	$('.lnb').find('a[target*=_blank]').attr('rel','noopener noreferrer');
	//�숆탳 寃���
	$('#schlSrch').find('a[target*=_blank]').attr('rel','noopener noreferrer');
	//諛곕꼫由ъ뒪��
	$('.banner_box').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

// 湲곕줉愿� �듬찓�� 
function noOpenerReferrerRecQuick(){
	$('#quick_menu').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

// 湲곕줉愿� �ъ쟾�뺣낫怨듯몴 
function noOpenerReferrerRec0202(){
	$('#contents').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

// �숆탳湲됱떇 �듬찓�� 
function noOpenerReferrerSupplQuick(){
	$('#quick').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

// 援먯쑁媛먯떎 �명꽣 
function noOpenerReferrerDirectFooter(){
	$('.area_footer').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

// 援먯쑁�쒕룞蹂댄샇醫낇빀�쇳꽣 �명꽣
function noOpenerReferrerForteacherFooter(){
	$('.footer_icon').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

// �숆탳蹂닿굔 硫붿씤
function noOpenerReferrerHealthMain(){
	$('.btn').find('a[target*=_blank]').attr('rel','noopener noreferrer');
}

//�뱀랬�쎌젏 蹂댁셿 target=_blank �띿꽦 �쇱떆 rel="noopener noreferrer" 異붽� �ㅽ겕由쏀듃 2019-08-08 �≪쁺�� 
function noOpenerReferrer(){
   $('[target*=_blank]').attr('rel','noopener noreferrer');
} 