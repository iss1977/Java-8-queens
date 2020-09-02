public class Queens {

    Integer[] queensArray = {0,0,0,0,0,0,0,0};
    int foundBoards=0;

    // prints the passed array in the console.
    public void printArray(){
        System.out.println("Valid board nr."+(++foundBoards));
        for (int i=0 ; i <= queensArray.length-1; i++){
            System.out.println("○".repeat(queensArray[i])+"●"+"○".repeat(8-queensArray[i]-1));
        }
        System.out.println();
    }

    public boolean positionValidOrNot(int x, int y){ // the parameters are : x = the column of the new queen, that has to be checked. Y is the new row, where we gonna put the queen
        if (y==7){
        //    System.out.println();
        }
        boolean positionIsValid = true;
        if (y==0) return positionIsValid; // special case, first row, must be valid.
        for (int i= 0 ; i<y; i++){
            // we must check if the new queen is on an attacked position - on 3 axes
            // check vertically
            if (queensArray[y-i-1]== x) positionIsValid = false;
            // check vertically and to the left
            if (queensArray[y-i-1]== x-i-1) positionIsValid = false;
            // check vertically and to the right
            if (queensArray[y-i-1]== x+i+1) positionIsValid = false;
        }
        return positionIsValid;
    }

    public void recQueen(int currentRow){
        for(int i=0; i<=7;i++){
            if (positionValidOrNot(i,currentRow)){
                // if true, we must first check if it's the last line,
                if (currentRow==7) { // we found an array
                    queensArray[currentRow]= i;
                    printArray();
                }
                else {
                    queensArray[currentRow]= i;
                    recQueen(currentRow+1);

                }
            }

        }
    }
} // end of class Queens



