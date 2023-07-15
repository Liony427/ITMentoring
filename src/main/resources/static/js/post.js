let postObject = {

 

    init: function() {

        $("#btn-save").on("click", () => {

            this.insertPost();

        });

        $("#btn-delete").on("click", () => {

            this.deletePost();

        });

        $("#btn-update").on("click", () => {

            this.updatePost();

        });

 

    },

 

    insertPost: function() {

        alert("포스트 등록 요청됨");

        let post = {

            title: $("#title").val(),

            content: $("#content").val()

        }

 

        $.ajax({

            type: "POST",

            url: "/post",

            data: JSON.stringify(post),

            contentType: "application/json; charset=utf-8"

        }).done(function(response) {

            let message = response["data"];

            alert(message);

            location = "/";

        }).fail(function(error) {

            let message = error["data"];

            alert("문제 발생 : " + message);

        });

    },

 

    deletePost: function() {

        alert("포스트 삭제 요청됨");

        let id = $("#id").text();

 

        $.ajax({

            type: "DELETE",

            url: "/post/" + id,

            contentType: "application/json; charset=utf-8"

        }).done(function(response) {

            let message = response["data"];

            alert(message);

            location = "/";

        }).fail(function(error) {

            let message = error["data"];

            alert("문제 발생 : " + message);

        });

    },

 

    updatePost: function() {

        alert("포스트 수정 요청됨");

        let post = {

            id: $("#id").val(),

            title: $("#title").val(),

            content: $("#content").val()

        }

 

        $.ajax({

            type: "PUT",

            url: "/post",

            data: JSON.stringify(post),

            contentType: "application/json; charset=utf-8"

        }).done(function(response) {

            let message = response["data"];

            alert(message);

            location = "/";

        }).fail(function(error) {

            let message = error["data"];

            alert("문제 발생 : " + message);

        });

    },

 

 

}

postObject.init();

 