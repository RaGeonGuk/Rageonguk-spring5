$(document).ready(function(){
	$('.to_top a').smoothScroll();

	// 모바일용 메뉴 보이기/숨기기 (액션처리)
	$('.openMOgnb').click(function(){
		// alert('메뉴 보이기 버튼 클릭 액션');
		// $('.header_cont').css('display', 'block');
		$('.header_cont').slideDown("slow");
		$('#header').addClass('on');
	});
	$('.closePop').click(function(){
		//$('.header_cont').css('display','none');
		$('.header_cont').slideUp("fast");
		$('#header').removeClass('on')
	})
});

// PC용 대메뉴 마우스 아웃시 조건에 맞으면, 서브메뉴 사라지는 액션
var isOver1 = false; // 대메뉴 1이 false 일때 서브메뉴가 사라지는 조건
var isOverSub1 = false; //서브메뉴 1번이 false일때 서브메뉴가 사라지는 조건
//  서브메뉴 숨기는 함수(아래)
function goHide1() {
	if(!isOver1 && !isOverSub1) {// 2개 변수 값이 false일때 구현조건이 됩니다.
		$('.gnb_depth2_1').stop().fadeOut('fast'); // 영어처럼 주어, 동사, 목적어 순으로 정리됨
	}
}
var isOver2 = false; // 대메뉴 2가 false일때 서브메뉴가 사라지는  조건
var isOverSub2 = false; // 서브메뉴 2번이 false 일때 서브메뉴가 사라지는 조건
//  2번 서브메뉴 숨기는 함수 (아래)
function goHide2() {
	if(!isOver2 && !isOverSub2){
		$('.gnb_depth2_2').stop().fadeOut('fast');
	}
}

// PC용 대메뉴 마우스 롤오버 이벤트 = 서브메뉴가 나타나는 액션 만들기(아래)
$(document). ready(function(){
	// 대메뉴 1번에 대한 액션
	$('.openAll1').mouseover(function(){
		if( parseInt($("header").css('width'))>=1049){
			$('.gnb_depth2_1').stop().fadeIn('fast'); //서브메뉴 1번 나타나게 처리
		}
		isOver1 = true; // false 일때 숨기는 조건 <-> ture일때 나타나는 조건
	});
	$('.openAll1').mouseout(function(){
		isOver1 = false;
		setTimeout('goHide1()',200); // 기본은 goHide1() 이것만 하면 되는데, mouseout 이벤트를 놓치면 안되기 때문에setTimeout 사용
	});
	// 서브메뉴 1번 액션
	$('.gnb_depth2_1').mouseover(function(){
		isOverSub1 = true; //서브메뉴 1 계속 나타납니다.
	});
	$('.gnb_depth2_1').mouseout(function(){
		isOverSub1 = false; //서브메뉴 1번이 사라집니다.
		setTimeout('goHide1()'),200;
	});
	// 대메뉴 2번에 대한 액션
	$('.openAll2').mouseover(function(){
		if( parseInt($('header').css('width')) >=1049) {
			$('.gnb_depth2_2').stop().fadeIn('slow');//서브메뉴1번 나타나게 처리
		}
		isOver2 = true;// false일때 숨기는 조건 <-> true일때 나타나는 조건
	});
	$('.openAll2').mouseout(function(){
	isOver2 = false;
		setTimeout('goHide2()',200); // 기본은 goHide1() 이것만 하면 되는데, mouseout 이벤트를 놓치면 안되기 때문에setTimeout 사용
	});
	// 서브메뉴 2번 액션
	$('.gnb_depth2_2').mouseover(function(){
		isOverSub2 = true; //서브메뉴 2 계속 나타납니다.
	});
	$('.gnb_depth2_2').mouseout(function(){
		isOverSub2 = false; //서브메뉴 2번이 사라집니다.
		setTimeout('goHide2()'),200;
	});	
});
