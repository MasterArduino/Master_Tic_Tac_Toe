package tic_;

public class Result {
    private int width, height, distance;
    private String[] array; // будет ссылаться на другие строчки кода, поэтому написали поле array

    public Result(int width, int height, int distance) {
        this.width = width;
        this.height = height;
        this.distance = distance;
    }

    public String process(String[] array) {
        this.array = array;

        int i =0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < height; x++) {
if(array[border(x,y)]!=null){i++;}

                for (int b = -1; b <= +1; b++) {
                    for (int a = -1; a <= +1; a++) {
                        if (!(a == 0 && b == 0)) {
                            if(check(x,y,a,b,"X")){return "X"; }
                            if(check(x,y,a,b,"0")){ return "0"; }
                            if(i==array.length){return "deadlock"; }
                        }
                    }
                }
            }
        }
        return "draw";
    }


    public boolean check(int x, int y, int a, int b, String symbol) {
        for (int i = 0; i < distance; i++) {
            int index = border(x + a * i, y + b * i);
            if(index == -1){ return false; }
            else{ if(array[index]!= symbol){
                return false;
            }
            }
        }
        return true;
    }

    //border переводит x y из одномерного в двумерный
    public int border(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return y * width + x; // переводит координаты в одномерную величину
        }
        return -1;
    }

}


