package my.oop.text;

public class Minesweeper {
    private int width;
    private int height;
    private int mines;
    private int uncovered_positions=0;
    private boolean[][] board; // Shows true if uncovered, false if covered
    private int[][] positions; // Values of postions showing how many adjacent mines there are, -1 indicates a mine in the position
    private boolean GameEnd=false; // True if all mines are uncovered or player chose a position containing a mine

    // Initializing default values with a 5x5 board
    // Default constructor
    public Minesweeper(){
        this.width=5;
        this.height=5;
        this.mines=5;

        this.positions=new int[this.height][this.width];
        this.board=new boolean[this.height][this.width];

        setMines();
        setBoard();
    }

    // Constructor with user defined settings for the game
    public Minesweeper(int w, int h, int m){
        this.width=w;
        this.height=h;
        this.mines=m;

        this.positions=new int[this.height][this.width];
        this.board=new boolean[this.height][this.width];

        setMines();
        setBoard();
    }

    // Places x number of mines on the board in random positions
    public void setMines(){
        int num_ofSet_mines=0;
        int x=0;
        int y=0;

        while(num_ofSet_mines<this.mines){
            x=(int)(Math.random()*this.width);
            y=(int)(Math.random()*this.height);
            if(positions[x][y]!=-1){
                positions[x][y]=-1;
                num_ofSet_mines++;
            }
        }
    }

    // Sets the values on the board. -1 for mines and # for adjacent mines for non-mine positions or safezones
    public void setBoard(){
        for(int x=0;x<this.width;x++){
            for(int y=0;y<this.height;y++){
                if(positions[x][y]!=-1){
                    positions[x][y]=checkAdjacent(x,y);
                }
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<this.width;i++){
            for(int j=0;j<this.height;j++){
                // Shows uncovered value if true
                if(board[i][j]){
                    // using printf to format the output to a 2 digit integer
                    System.out.printf("%2d ",positions[i][j]);
                }
                else{
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int checkAdjacent(int x,int y){
        int sum=0;
        for(int i=-1;i<=1;i++){
            if((x+i)>=0 && (x+i)<=(this.width-1)){
                for(int j=-1;j<=1;j++){
                    if((y+j)>=0 && (y+j)<=(this.height-1) && (i!=0 || j!=0)){
                        if(positions[x+i][y+j]==-1){
                            sum+=1;
                        }
                    }
                }
            }
        }

        return sum;
    }

    public void uncoverPosition(int x, int y){
        // Checks if position contains a mine, if it does then the game ends
        if(positions[x][y]==-1){
            GameEnd=true;
            board[x][y]=true;
        }

        // If position has no adjacent mines, covers adjacent areas around the position
        else if(positions[x][y]==0){
            if(!board[x][y]){
                board[x][y]=true;
                this.uncovered_positions+=1;
            }

            // Iterates through the board to uncover covered positions on the board
            for(int i=-1;i<=1;i++){
                if((x+i)>=0 && (x+i)<=(this.width-1)){
                    for(int j=-1;j<=1;j++){
                        if((y+j)>=0 && (y+j)<=(this.height-1) && (i!=0 || j!=0)){
                            if(!board[x+i][y+j]){
                                // using recursion to invoke the function at another position to check for adjacent covered areas
                                uncoverPosition(x+i,y+j);
                            }
                        }
                    }
                }
            }
        }

        else{
            if(!board[x][y]){
                board[x][y]=true;
                uncovered_positions+=1;
            }
        }
    }

    public boolean getGameStatus(){
        // Win: All mines and non-mines are uncovered
        if(uncovered_positions>=(width*height-mines)) {
            GameEnd = true;
        }
        // Lose: Some non-mines were left uncovered. Mines are uncovered.
        // GameEnd status will not be changed.

        return this.GameEnd;
    }

    public void getGameResult(){
        // Win: All mines and non-mines are uncovered
        if(uncovered_positions>=(width*height-mines)) {
            System.out.println("YOU WIN! YOU HAVE UNCOVERED ALL THE MINES AND SAFEZONES!");
        }
        // Lose: Some non-mines were left uncovered. Mines are uncovered.
        // GameEnd status will not be changed.
        else{
            System.out.println("YOU LOSE! OMG WHAT A LOSER HAHA!");
        }
    }
}
