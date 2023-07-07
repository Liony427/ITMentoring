// userObject 객체 선언 
let userObject = {

	init: function() {
		// "#btn-save" 버튼에 "click" 이벤트가 발생되면 save() 함수가 동작한다. 
		$("#btn-save").on("click", () => {
			this.insertUser();
		});
	},

	insertUser: function() {
		alert("회원 가입 요청됨");
		// 사용자가 입력한 값들(username, password, email)을 추출한다.
		let user = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		// $.ajax().done().fail();
		// $.ajax()에는 Object가, done()에는 요청이 성공했을 때, 코드를 작성한다.
		$.ajax({
			// 회원가입 요청 method와 action 설정
			type: "POST",
			url: "/auth/insertUser",
			// 자바스크립트 Object인 user를 JSON로 변환한다.
			data: JSON.stringify(user),
			// JSON으로 변화된 user는 HTTP 바디에 설정된다.
			// 따라서 바디에 설정된 데이터의 마임타입을 지정해야 한다. 
			contentType: "application/json; charset=utf-8"

			// 응답으로 들어온 JSON 데이터를 response 변수로 받는다. 
		}).done(function(response) {
			// 응답 메시지를 콘솔에 출력하고 메인 페이지로 이동한다.
			let message = response["data"];
			alert(message);
			location = "/";
		}).fail(function(error) {
			let message = error["data"];
			alert("에러 발생 : " + message);
		});


	}
}

// userObject 객체의 init 함수 호출. 
userObject.init();
