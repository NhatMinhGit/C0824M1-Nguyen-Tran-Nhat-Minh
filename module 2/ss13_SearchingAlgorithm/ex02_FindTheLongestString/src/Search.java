public class Search {
    static String[] list = {"Xoài", "Dưa hấu", "Dâu", "Táo", "Nho", "Cam"};
    static String Search(String[] list) {
        int maxIndex=0;
        int maxLength=list[0].length();
        String temp="";
        for(int i = 0;i<list.length;i++){
            if(maxLength < list[i].length()){
                maxLength = list[i].length();
                maxIndex = i;
                temp = list[i];
            }
        }
        return "Vị trí string dài nhất là : "+ maxIndex + ", " + temp + " với độ dài : " + maxLength;
    }
    public static void main(String[] args) {
        System.out.println(Search(list));
    }
}
