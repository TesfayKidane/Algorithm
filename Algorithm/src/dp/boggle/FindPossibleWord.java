package dp.boggle;


public class FindPossibleWord {

    private static final int rowM = 3;
    private static final int colN = 3;
    private static final String[] dictionary =  {"GEEKS", "FOR", "QUIZ", "GO"};

    public static void main(String[] args) {
        char[][] boggle = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};

        findWords(boggle);
    }

    private static void findWords(char[][] boggle) {

        boolean[][] visited = {{false}};
        String str = "";

        for(int i = 0 ; i < rowM; i++)
            for(int j = 0 ; j < colN; j++)
                findWordsUtil(boggle,visited,i,j,str);

    }

    private static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {

        visited[i][j] = true;
        str += boggle[i][j];

        if(isWord(str)) {
            System.out.println(str);
        }

        for(int row = i-1; row <= i+1 && row < rowM; row++){
            for(int col = j - 1; col <= j+1 && col < colN; col++){
                if(row >= 0 && col >= 0 && !visited[row][col]){
                    findWordsUtil(boggle,visited,row,col,str);
                }
            }
        }

        str = str.substring(0,str.length()-2);
        visited[i][j] = false;
    }

    private static boolean isWord(String str) {
        for(int i = 0 ; i < dictionary.length ; i++) {
            if (dictionary[i].equals(str)) {
                return true;
            }
        }
        return false;
    }
}
