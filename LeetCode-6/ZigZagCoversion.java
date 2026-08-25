public class ZigZagCoversion {
    public static void main(String[] args) {
        System.out.println(convertSimulation("PAYPALISHIRING", 3));
    }


    //This solution will result in Memory Consumed Error because it will go in infinite low for every last row.
    public static String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) { // If numRows is 3
            result.append(s.charAt(i)); // than last iteration i will be 2, so in result character at index 2 will be appended
            boolean goingDown = true;
            int iterator = i + (((numRows - 1) - i) * 2); // the iterator should move to the next index cause we are adding the current i to it, but its not. because for i = 2, (((numRows - 1) - i) * 2) will result in 0 and when we add 2 to zero it will stay as 2 only.

            while(iterator < s.length()){
                result.append(s.charAt(iterator)); // so agian character at index 2 will get added to the result
                if(!goingDown || i == 0 || i == numRows - 1) { // now here i is 2 which is equals to numRows - 1 that is 2. so we go inside
                    iterator += ((numRows - 1) - i) * 2; // iterator is currently 2. And this ((numRows - 1) - i) * 2 will result in 0, so iterator will stay as 2.
                    goingDown = true; //no matter what goingDown is, we will always enter this condition because we are at the last row, and for last row, iterator can not move which will make this logic to fall in infinite loop.
                } else {
                    iterator += i * 2;
                    goingDown = false;
                }
            }
        }
        return result.toString();
    }  
    
    
    public static String convertSimulation(String s, int numRows) {
        if(s.length() == 1 || numRows > s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows]; //lets build a list of container, so there are three rows, so we have three string builder

        for(int i=0; i<numRows; i++) {
            rows[i] = new StringBuilder(); //at each row lets add empty stringBuilder otherwise it will be null.
        }

        boolean goingDown = false;
        int rowIndex = 0; // this will iterate over the rows because for numRows -> 3. the tracing for a string will go like this row wise. starts with 0 -> moves down to 1 -> than 2 which is last -> than it will move up diagonally in row that is 1 -> than up again to 0 and than the same process will repeate.
        for(int i = 0; i < s.length(); i++) {
            rows[rowIndex].append(s.charAt(i));

            if(rowIndex == 0 || rowIndex == numRows - 1) { // So once we hit the floor or cieling that is 0th row or bottom last row respectively, we'll switch the boolean flag
                goingDown = !goingDown; // at start we kept goingDown as false intentionally cause at start rowIndex is 0, so we enter this condition and goingDown will get toggled from false to true and than based on this value, if we are going down, we need to incerement the rowIndex that is 0->1->2 and when we hit the bottom we need to go upwards so we need to keep subtracting 1 so will go 2->1->0
            }

            rowIndex += goingDown ? 1 : -1; //so if going down is true, we need to incremenet rowIndex, so we'll add +1, and if goingDown is false, that means we need to go upward so we need to decrement the rowIndex so we add -1 in rowIndex.
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
