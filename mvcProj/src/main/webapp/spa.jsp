<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원등록</h3>
	<form name="addFrm" action="addMemberAjax.do" method="post">
		아이디 : <input type ="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		이메일 : <input type="text" name="mail"><br>
		
		<input type="submit" value="저장">	
	</form>
	
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th><th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	
	<script>
	
	let i=0;	
	let xhtp=new XMLHttpRequest(); //비동기방식 처리
	xhtp.open('get','memberJson.do');
	xhtp.send(); //send가 호출되어야 작업을 시작함
	
 	xhtp.onreadystatechange=callBackThree;
	
	function callBackOne() {
	
		if(this.readyState==4 && this.status==200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			let name=document.createElement('p');
			name.innerText=data.name;
			let age=document.createElement('p');
			age.innerText=data.age;
			
			document.querySelector('body').append(name,age);
		}
	}
	
	function callBackTwo() {
		if(this.readyState==4 && this.status==200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let ul = document.createElement('ul'); //<ul></ul>
			for (let obj of data) {
				let li = document.createElement('li');
				li.innerHTML=obj.name+', '+obj.age; //<li>hong, 15</li>
				ul.append(li);
			}
			console.log(ul);			
			document.querySelector('body').append(ul);
		}
		
	}
	
	//출력할 필드를 배열에 지정	
	let fields=['id','name','mail','passwd'];
	
	function callBackThree() {
		
		if(this.readyState==4 && this.status==200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let tbody=document.getElementById('list');
			
			for(let obj of data) {
				tr = makeTr(obj);
				tbody.append(tr);				
			}
	}
	} //end of callBackThree
	
	//*** 데이터 한건 tr 생성
	function makeTr(obj) {
		
		//tr td,td,td,td
		let tr = document.createElement('tr');
		
		for(let field of fields) {
			let td1=document.createElement('td');
			td1.innerText=obj[field];
			tr.append(td1);
		}
		
		//삭제버튼
		let td1=document.createElement('td');
		let btn=document.createElement('button');
		btn.innerText='삭제';
		//클릭이벤트
		btn.addEventListener('click', deleteCallBack);//이벤트타입, 기능
		td1.append(btn);
		tr.append(td1);
		
		return tr;
	}
	
	function deleteCallBack(e) {
		console.log(this); //event의 call함수(이벤트를 받는 대상)
	
		let delId=this.parentElement.parentElement.firstElementChild.innerText;
		
		let delAjx=new XMLHttpRequest(); //send
		delAjx.open('post', 'removeMemberAjax.do');
		delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		delAjx.send('id='+delId);
		delAjx.onload=function() {
			let result = JSON.parse(delAjx.responseText)
			if (result.retCode =='Success')
			   	e.target.parentElement.parentElement.remove();				
		    else 
				alert('처리중 에러발생');
		}
		
		
		
		this.parentElement.parentElement.remove();
	}
	
	//form 전송이벤트가 실행이 되면 form 태그실행하지않고 ajax실행되도록
	document.forms.addFrm.onsubmit=function(e) {
		
		//기본기능 차단
		e.preventDefault();
		let url=document.forms.addFrm.getAttribute('action');
		let id= document.forms.addFrm.id.value;
		let name= document.forms.addFrm.name.value;
		let pass= document.forms.addFrm.passwd.value;
		let mail= document.forms.addFrm.mail.value;
		let param='id='+id+'&name='+name+'&passwd='+pass+'&mail='+mail;
		console.log(param);
	
		let addAjx=new XMLHttpRequest(); //send
		addAjx.open('post', url);
		addAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		addAjx.send(param); //id=user1&passwd=1234&name=Hong&mail=email@com
		addAjx.onload=function() {
			console.log(addAjx.reponseText);
			let data=JSON.parse(addAjx.responseText); //json->object
			//tbody태그의 id(list) 
			document.getElementById('list').append(makeTr(data));
			
		}
		document.forms.addFrm.id.value="";
		document.forms.addFrm.name.value="";
		document.forms.addFrm.passwd.value="";
		document.forms.addFrm.mail.value="";
		document.forms.addFrm.id.focus();
	}
	
	</script>
</body>
</html>