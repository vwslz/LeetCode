public class RectanleArea_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        int I,J,K,L = 0;
        area += calArea(A,B,C,D);
        area += calArea(E,F,G,H);
        if((A>=G) || (C<=E) || (B>=H) || (D<=F))
            return area;
        else{
            if(A>=E)
                I = A;
            else
                I = E;
            if(C<=G)
                K = C;
            else
                K = G;
            if(B>=F)
                J = B;
            else
                J = F;
            if(D<=H)
                L = D;
            else
                L = H;
        }
        area -= calArea(I,J,K,L);
        return area;
    }

    public int calArea(int a, int b, int c, int d){
        return (c-a)*(d-b);
    }
}
