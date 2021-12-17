package enums;

public enum ScrollDirection {
    DOWN(0.75, 0.35),
    UP(0.3, 0.65);
    //LEFT("влево"),
    //RIGHT("вправо");

    double startPoint;
    double stopPoint;

    ScrollDirection(double startPoint, double stopPoint) {
        this.startPoint = startPoint;
        this.stopPoint = stopPoint;
    }


}
