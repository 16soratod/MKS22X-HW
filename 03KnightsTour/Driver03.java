public class Driver03{    
    public static void main(String[] args){
        KnightBoard a = new KnightBoard(5);
        //System.out.println(a);
        a.solve();
        a.printSolution();
        KnightBoard b = new KnightBoard(6);
        b.solve();
        b.printSolution();
        KnightBoard c = new KnightBoard(7);
        c.solve();
        c.printSolution();
        KnightBoard d = new KnightBoard(3,5);
        d.solve();
        d.printSolution();
        KnightBoard e = new KnightBoard(3,7);
        e.solve();
        e.printSolution();
        KnightBoard f = new KnightBoard(5,6);
        f.solve();
        f.printSolution();
        }
}