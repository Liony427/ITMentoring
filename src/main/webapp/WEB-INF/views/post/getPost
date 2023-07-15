<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

 

<div class="container">

 

    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>

    <a href="/post/updatePost/${post.id }" class="btn btn-warning">수정하기</a>

    <button id="btn-delete" class="btn btn-danger">삭제하기</button>

    <br> <br>

 

    <div>

        포스트 번호 : <span id="id"><i>${post.id }</i></span> 작성자 : <span><i>${post.user.username }</i></span>

    </div>

    <br>



    <div>

        <h3>${post.title }</h3>

    </div>

 

    <hr>

    <div>

        <div>${post.content }</div>

    </div>

    <hr>

</div>

 

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>

 