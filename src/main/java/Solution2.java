import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int N=4;
        String S="1B 2C,2D 4D";
        String T="2B 2D 3D 4D 4A";
        String res = new Solution2().solution(N, S, T);
        System.out.println("result " + res);

        N=3;
        S="1A 1B,2C 2C";
        T="1B";
        res = new Solution2().solution(N, S, T);
        System.out.println("result " + res);

        N=12;
        S="1A 2A,12A 12A";
        T="12A";
        res = new Solution2().solution(N, S, T);
        System.out.println("result " + res);

    }

    private String solution(int N, String S, String T) {

        List<String> hits = parseHits(T);
        List<Ship> ships = parseShips(S);
        for (Ship ship: ships) {
            for (String hit: hits) {
                processFight(ship, hit);
            }
        }
        long count_hit = calcHit(ships);
        long count_sunk = calcSunk(ships);

        return "" + count_sunk + "," + count_hit;
    }

    private void processFight(Ship ship, String hit){
        for (String cell: ship.getCells()) {
            if (cell.equals(hit)){
                ship.hitCell(cell);
            }
        }
    }

    private long calcHit(List<Ship> ships){
        return ships.stream().filter(Ship::isHit).count();
    }

    private long calcSunk(List<Ship> ships){
        return ships.stream().filter(Ship::isSunk).count();
    }

    private List<String> parseHits(String hits){
        return Arrays.asList(hits.split(" "));
    }

    private List<Ship> parseShips(String shipsStr){
        List<Ship> ships = new ArrayList<>();
        String [] shipsString = shipsStr.split(",");
        for (String shipStr: shipsString) {
            String [] corners = shipStr.split(" ");
            int minRow = Integer.parseInt(corners[0].substring(0, corners[0].length()-1));
            int maxRow = Integer.parseInt(corners[1].substring(0, corners[1].length()-1));
            char minCol = corners[0].charAt(corners[0].length()-1);
            char maxCol = corners[1].charAt(corners[0].length()-1);
            List<String> cells = new ArrayList<>();
            for (int row = minRow; row <= maxRow; row++) {
                for (char col = minCol; col <= maxCol; col++) {
                    cells.add(String.valueOf(row)+ col);
                }
            }
            ships.add(new Ship(cells));
        }
        return ships;
    }

    class Ship{
        private List<String> cells;
        private List<String> hitCells = new ArrayList<>();
        private boolean hit;
        private boolean sunk;

        Ship(List<String> cells) {
            this.cells = cells;
        }

        void hitCell(String cell){
            System.out.println("Ship " + this + " hit on " + cell);
            hitCells.add(cell);
            hit = true;
            if(cells.size() == hitCells.size()){
                sunk = true;
                hit = false;
                System.out.println("Ship " + this + " sunk ");
            }
        }

        boolean isHit(){
            return hit;
        }

        boolean isSunk(){
            return sunk;
        }

        List<String> getCells() {
            return cells;
        }
    }
}


