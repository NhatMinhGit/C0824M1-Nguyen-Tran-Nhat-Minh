
    function showChapter(chapterId) {
    // Ẩn tất cả các chương
    var chapters = document.getElementsByClassName("chapter");
    for (var i = 0; i < chapters.length; i++) {
    chapters[i].style.display = "none";
}
    // Hiển thị chương được chọn
    document.getElementById(chapterId).style.display = "block";
}
