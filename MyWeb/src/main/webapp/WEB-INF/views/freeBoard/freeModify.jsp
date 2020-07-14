<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>인덱스를 만들어 보자</title>

    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
	

</head>
<body>
	<%@ include file="../include/header.jsp" %>
    <!--게시판-->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form action="updateForm" name="updateForm" method="post">
                            <div>
                                <label>DATE</label>
                                <p>2019-12-12</p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name="bno" value="${vo.bno}" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name="writer" value="${vo.writer}">
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name="title" value="${vo.title}">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name="content">${vo.content}</textarea>
                            </div>

                            <button type="button" class="btn btn-dark">목록</button>    
                            <button type="button" class="btn btn-primary" id="UpdateBtn">변경</button>
                            <button type="button" class="btn btn-info" id="DeleteBtn">삭제</button>
                    </form>
                                    
                </div>
            </div>
        </div>
        </section>
        
        <%@ include file="../include/footer.jsp" %>
        
        <script>
    	/*
		 1. 폼에 데이터가 공백인지 확인처리
		 2. 공백이 없으면 Controller에 freeUpdate 요청으로 데이터를 전송
		 3. 컨트롤러에서는 int update()메서드를 사용해서 정보를 수정
		 4. 컨트롤러에서는 업데이트 성공시 "게시글 수정이 정상 처리되었습니다"를 출력 해주세요
		 5. 실패시 실패처리 글 띄우고 전부 redirect로 list화면으로 넘기기
		 */
		 
        
        var UpdateBtn = document.getElementById("UpdateBtn");
        var DeleteBtn = document.getElementById("DeleteBtn");
        UpdateBtn.onclick = function(){
    		 if(document.updateForm.bno.value ===''){
				 alert("글번호가 공백입니다.");
				 return;
			 }else if(document.updateForm.writer.value === ''){
				 alert("작성자가 공백입니다.");
				 return;
			 }else if(document.updateForm.title.value === ''){
				 alert("제목이 공백입니다.");
				 return;
			 }else if(document.updateForm.content.value === ''){
				 alert("내용이 공백입니다.");
				 return;
			 }else {
				 document.updateForm.submit();
			 }
        }
        
        DeleteBtn.onclick=function(){
        	var bno = document.getElementsByName("bno")[0].value;        	
        	location.href="freeDelete?bno="+bno;
        }
        
        </script>
</body>
</html>