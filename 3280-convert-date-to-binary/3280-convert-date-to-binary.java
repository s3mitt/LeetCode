class Solution {
    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(year))
          .append("-")
          .append(Integer.toBinaryString(month))
          .append("-")
          .append(Integer.toBinaryString(day));
          
        return sb.toString();
    }
}
