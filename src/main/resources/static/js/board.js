function saveBoard(){

    if(!validateSave())
        return false;

    var form = $('#dataForm')[0];
    var boardData = new FormData(form);
    var url = "/board"

    $("#submitBtn").prop("disabled", true);

    $.ajax({
            url         : url,
            type        : "POST",
            data        : boardData,
            processData : false,                 //데이터를 컨텐트 타입에 맞게 변환 여부
            contentType : false,
            cache       : false,
            timeout     : 600000,
            success     : function(result){
                alert(result.resultMsg);
                $("#submitBtn").prop("disabled", false);
                if(result.resultCode == "success"){
                    window.location.href = '/board/list/1';
                }
            },
            error      : function(jqXhr, status, error){
                alert("게시글을 저장하는데 실패하였습니다.");
                $("#submitBtn").prop("disabled", false);
            }
        }
    );

}

function validateSave(){

    if(!validateRequiredValue())
        return false;

    return true;
}

function validateRequiredValue(){

    if(!validateWriter()){
        alert("작성자를 입력해주세요");
        return false;
    }

    if(!validateContent()){
        alert("내용을 입력해주세요");
        return false;
    }

    return true;
}

function isNull(value){
    if(value == "" || value == undefined || value == null || value.length == 0)
        return true;

    return false;
}

function validateWriter(){
    var writer   = $("#writer").val();
    if(isNull(writer))
        return false;

    return true;
}

function validateContent(){
    var content = $("#content").val();
    if(isNull(content))
        return false;

    return true;
}