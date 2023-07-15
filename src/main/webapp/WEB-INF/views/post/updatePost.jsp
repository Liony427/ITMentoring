<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 

<%@ include file="../layout/header.jsp"%>

 

<div class="container">

 

<form>

<input type="hidden" id="id" value="${post.id }">

    <div class="form-group">

        <label for="title">Title :</label>

        <input type="text" class="form-control" placeholder="Enter title" id="title" value="${post.title }">

    </div>

    <div class="form-group">

        <textarea class="form-control summernote" rows="5" id="content">${post.content }</textarea>

    </div>

</form>

 

<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>

<button id="btn-update" class="btn btn-primary">포스트 수정</button>

 

</div>

 

<script>

    $('.summernote').summernote({

        tabsize : 2,

        height : 300

    });

</script>

 

<script src="/js/post.js"></script>

 

<%@ include file="../layout/footer.jsp"%>

 