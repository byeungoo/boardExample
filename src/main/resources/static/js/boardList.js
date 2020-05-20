function goBoardWritePage(){
    window.location.href = '/board/newWrite';
}

function goBoardDtl(boardId){
    window.location.href = '/board/' + boardId;
}

function movePage(page){
    window.location.href = '/board/list/' + page;
}