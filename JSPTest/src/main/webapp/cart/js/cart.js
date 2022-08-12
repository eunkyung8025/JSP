/*
cart.js
JSPTest/cart/cart.jsp
*/


//콜백함수 만들기
function cartList(result) {
	console.log(result) 
	 
	//cart.jsp파일의 <div id="template" style="display: none;"> → 이부분을 가져오겠다라는 뜻
	let cartTemplate = document.querySelector('#template');
	let basket = document.querySelector('#basket');
	
	for(let i=0; i<result.length; i++) {
		let rowDiv = cartTemplate.childNodes[1].cloneNode(true); //template div 태그의 첫번째 자식(div.row data)을 row Div라 부르고 가져오겠습니다.
		
		console.log(rowDiv);
		rowDiv.setAttribute('data-id', result[i].no);
		rowDiv.querySelector('div.pname span').textContent = result[i].productNm;
		rowDiv.querySelector('div.basketprice input[name="p_price"]').value = result[i].price;
		rowDiv.querySelector('div.basketprice').childNodes[2].textContent=result[i].price;
		rowDiv.querySelector('div.num input').value=result[i].qty;
		rowDiv.querySelector('div.sum').textContent=(result[i].price*result[i].qty);
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('id','p_num'+result[i].no);	
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('onkeyup','javascript:changePnum('+result[i].no+')');	
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(1)').setAttribute('onclick','javascript:changePnum('+result[i].no+')');	
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(2)').setAttribute('onclick','javascript:changePnum('+result[i].no+')');	
		
		basket.append(rowDiv);
	
	}
}



function makeList() {
	//ajax. XMLHttpRequest.
	
	//fatch안에 호출하고 싶은 URL을 넣어주면됨
	fetch('../cartList.do')
		
	.then(result=>result.json())
	.then(cartList)
	.catch(err=>console.log(err))
	
/*	↑ 위: 화살표 함수 사용
    ↓ 아래 : 일반 함수 사용 
    
	.then(function(result) {  //성공
		return result.json(); //가져온 제이슨 데이터를 리턴타입으로 가져와줘야함..
	})
	.then(function(result){ 
		console.log(result) 
	})
	.catch(function(err) { //실패
		console.log(err)		
	}) */
	
}

makeList();

function changePnum(no) {

	let currentItem = event.target; //이벤트를 받는 대상 가져옴

	let currentQty =  currentItem.closest('.updown').childNodes[1].value;
	let currentPrice= currentItem.closest('.subdiv').childNodes[1].childNodes[1].value;
	console.log(currentQty,currentPrice);
	
	if(currentItem.classList[2]=='down') {
		changeQty=parseInt(currentQty) -1;
		currentItem.closest('.updown').childNodes[1].value=changeQty;}
	else {
		changeQty = parseInt(currentQty) +1;
		currentItem.closest('.updown').childNodes[1].value=changeQty;	}
		
	fetch('../cartUpdate.do', {
		method:'post',
		headers: {'Content-type': 'application/x-www-form-urlencoded'},
		body:'no='+no+'&qty='+changeQty
	})	
	.then(result=>result.text())
	.then(result=>console.log(result))	
	.catch(err=>console.log(err))	
}