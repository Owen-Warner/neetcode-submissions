class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, ArrayList<Character>> col = new HashMap<>();
        HashMap<Integer, ArrayList<Character>> box = new HashMap<>();
        for(int r = 0; r < 9; r++){
            ArrayList<Character> row = new ArrayList<>();
            for(int pos = 0; pos < 9; pos++){
                char c = board[r][pos];
                if(c != '.'){
                    int boxIdx = (r / 3) * 3 + (pos / 3);
                    if(col.containsKey(pos)){
                        if(col.get(pos).contains(c)){
                            return false;
                        }
                        else{
                            ArrayList<Character> temp = col.get(pos);
                            temp.add(c);
                            col.put(pos, temp);
                        }
                    }
                    else{
                        ArrayList<Character> temp = new ArrayList<>();
                        temp.add(c);
                        col.put(pos, temp);
                    }
                    if(box.containsKey(boxIdx)){
                        if(box.get(boxIdx).contains(c)) return false;
                        box.get(boxIdx).add(c);
                    } else {
                        ArrayList<Character> temp = new ArrayList<>();
                        temp.add(c);
                        box.put(boxIdx, temp);
                    }
                    if(row.contains(c)){
                        return false;
                    }
                    else{
                        row.add(c);
                    }
                }

            }
        }
        return true;
    }
}