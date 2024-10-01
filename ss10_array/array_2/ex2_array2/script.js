function transcript() {
    //orange
    let arr_eng = ["banana", "apple", "orange", "pen", "pencil", "book"];
    let arr_vie = ["chuối", "táo", "cam", "bút", "bút chì", "sách"];
    let string = document.getElementById("string").value;
    let index_eng = 0;
    let result = "";
    let count = 0;
    for (let i = 0; i < arr_eng.length; i++) {
        if (string == arr_eng[i]) {
            index_eng = i; //2
            for (let j = 0; j < arr_vie.length; j++) {
                if (index_eng == j) { //2 == 2
                    result = arr_vie[j]; // táo 
                }
            }
            count = 1;
        }
        
    }
    if (count == 0) {
        let add = confirm("Không tìm thấy từ cần tra ! Bạn có muốn thêm từ vào từ điển không?");
        if(add){
            let vn_word = prompt("Nhập nghĩa tiếng việt cho từ mới");
            arr_eng.push(string);
            arr_vie.push(vn_word);
            result = "Đã thêm từ vào từ điển en: " + string + "--- vi: " + vn_word;
        }
    }
    document.getElementById("result").innerHTML = result;
}