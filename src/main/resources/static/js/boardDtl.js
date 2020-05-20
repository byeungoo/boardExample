function updateBoard(){
    var id = $("#boardId").val();
    var boardData = JSON.stringify(getBoardData());
    var url = "/board/" + id;

    $.ajax({
          url : url
        , type : 'put'
        , contentType: 'application/json; charset=utf-8'
        , data : boardData
        , dataType:'json'
        , cache : false
        , success : function(result){
            alert(result.resultMsg);
            if(result.resultCode == "success"){
                window.location.href = url;
            }
        }
        , error : function(jqXHR, textStatus, errorThrown){
            alert("게시글 수정에 실패하였습니다.");
        }
    });


}

function deleteBoard(){

    var id = $("#boardId").val();

    $.ajax({
          type : 'delete'
        , data : JSON.stringify(id)
        , contentType: "application/json; charset=utf-8"
        , dataType:'json'
        , cache : false
        , success : function(result){
            alert(result.resultMsg);
            if(result.resultCode == "success"){
                window.location.href = '/board/list';
            }
        }
        , error : function(jqXHR, textStatus, errorThrown){
            alert("게시글 삭제에 실패하였습니다.");
        }
    });

}

function getBoardData() {
    var boardData = {
                         "id"    : $("#boardId").val()
                       , "title" : $("#title").val()
                       , "content" : $("#content").val()
                    };
    return boardData;
}