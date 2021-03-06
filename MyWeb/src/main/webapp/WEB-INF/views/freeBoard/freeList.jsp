﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="container-fluid">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <hr>
                    
                    <select class="amount" onchange="change(this)">
						<option value="10" ${pageVO.amount==10? 'selected':''}>10개 보기</option>
						<option value="15" ${pageVO.amount==15? 'selected':''}>15개 보기</option>
						<option value="20" ${pageVO.amount==20? 'selected':''}>20개 보기</option>
						<option value="50" ${pageVO.amount==50? 'selected':''}>50개 보기</option>
						<option value="100" ${pageVO.amount==100? 'selected':''}>100개 보기</option>					
					</select>
                  
 	         		<span>총 ${pageVO.total}</span>
                    
                    <!--form select를 가져온다 -->
                    <form action="freeList" name="searchForm" method="post">                    
			    		<div class="search-wrap">			    		   
			    			
	                       <button type="submit" class="btn btn-info search-btn">검색</button>
	                       <input type="text" class="form-control search-input" name="searchName" value="${cri.searchName}">
	                       <select class="form-control search-select" name="searchType">
	                            <option value="title" ${cri.searchType eq 'title' ? 'selected':''}>제목</option>
	                            <option value="content" ${cri.searchType eq 'content' ? 'selected':''}>내용</option>
	                            <option value="writer" ${cri.searchType eq 'writer' ? 'selected':''}>작성자</option>
	                            <option value="titcont" ${cri.searchType eq 'titcont' ? 'selected':''}>제목+내용</option>
	                       </select>
	                    </div>
	                    
	                    <input type="hidden" name="pageNum" value="1">
	                    <input type="hidden" name="amount" value="${cri.amount}">	                    
		   			 </form>
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="vo" items="${boardList}" >
	                            <tr>
	                                <td>${vo.bno }</td>
	                                <td><a href="freeDetail?bno=${vo.bno}">${vo.title}</a></td>
	                                <td>${vo.writer}</td>
	                                <td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
	                                <td><fmt:formatDate value="${vo.updatedate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>


                    <!--페이지 네이션을 가져옴-->
		    <form action="freeList" name="pageForm" method="post">
                    <div class="text-center">
                    <hr>
                    <ul class="pagination pagination-sm" id="page">
                        		<!-- 2. 이전버튼 활성화 여부 -->
								<c:if test="${pageVO.prev }">
									<li><a href="${pageVO.startPage-1}" data-pagenum="${pageVO.startPage-1}">이전</a></li>
								</c:if>	
                        		<!-- 1. 페이지 번호처리 -->
								<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
									<li class="${num == pageVO.pageNum ? 'active' : '' }"><a href="${num}" data-pagenum="${num}">${num }</a></li>
								</c:forEach>
                        		<!-- 3. 다음버튼 활성화 여부 -->
								<c:if test="${pageVO.next }">
									<li><a href="${pageVO.endPage+1}" data-pagenum="${pageVO.endPage+1}">다음</a></li>
								</c:if>
                    </ul>
                    
                    <!-- 페이징 클릭시 숨겨서 보낼 값 -->
                    <input type="hidden" name="pageNum" value="${cri.pageNum}">
                    <input type="hidden" name="amount" value="${cri.amount}">
                    <input type="hidden" name="searchType" value="${cri.searchType}">
                    <input type="hidden" name="searchName" value="${cri.searchName}">
                    
                    <button type="button" class="btn btn-info" onclick="location.href='freeRegist'">글쓰기</button>
                    </div>
		    </form>

                </div>
            </div>
        </div>
	</section>	
<%@ include file="../include/footer.jsp" %>

	
	<script>
		(function(){
			
			//console.log(history.state);
			
			/* '<c:out value="${msg}"></c:out>' */
			if(history.state ===''){
				return;
			}
			
			var msg = '${msg}';
			if(msg!=''){
				alert(msg);
				//(추가할 데이터, 페이지 제목, 변경할 주소) - 기존 기록을 삭제하고 새로운 기록을 추가
				//이렇게 추가된 데이터를 history.state로 확인이 가능
				history.replaceState('',null,null); 
			}
			
		})()
		
		/*
		1. 아래 페이지 버튼을 a태그에서 폼전송으로 변경
		2. Criteria에 검색 키워드를 추가
		3. 검색폼과, 페이지폼이 동일한 값을 가지고 넘어가도록 hidden값을 추가
		4. sql문을 동적쿼리로 변경, total sql도 동적 쿼리로 변경
		5. pageVO에 검색 키워드를 저장도록 처리
		6. 화면에서 select 박스 키워드 처리, input 태그 키워드 처리
		7. 페이지를 이동하거나 검색, 버튼을 클릭했을때 검색 조건이 유지되도록 처리함
		*/
		
		var amount = document.querySelector(".amount").value;
		function change(){			
			amount = event.target.value;
			 var searchType = document.searchForm.searchType.value;
			 var searchName = document.searchForm.searchName.value;
			 
			location.href='freeList?pageNum=1&amount='+amount+'&searchType='+searchType+'&searchName='+searchName; 
		}
		
		var page = document.getElementById("page");
		page.onclick = function(){
			 event.preventDefault();						 
			 
			 var pageNum = event.target.dataset.pagenum;			 
			 document.pageForm.pageNum.value = pageNum;			 
			 document.pageForm.submit();
		}		
	</script>
</body>
</html>

