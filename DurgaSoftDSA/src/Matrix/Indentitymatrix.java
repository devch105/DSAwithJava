package Matrix;

public class Indentitymatrix {
    static void print(int arr[][],int n,int m){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }
    }

    static boolean checkIndentityMatrix(int mt[][],int r,int c){
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                if(i!=j && mt[i][j]!=0) return false;

                if(i==j && mt[i][j]!=1) return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        int M1[][]={{1,0,0},{0,1,0},{0,0,1}};
        int M2[][]={{1,1,0},{0,1,0},{0,0,1}};
        print(M1 ,3,3);
        System.out.println("------------");
        print(M2,3,3);
        System.out.println("Answer : "+checkIndentityMatrix(M1,3,3));
        System.out.println("Answer : "+checkIndentityMatrix(M2,3,3));


    }
}
