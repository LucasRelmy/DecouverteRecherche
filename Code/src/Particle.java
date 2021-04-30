import java.util.Arrays;

public class Particle {
    private int[] position = new int[2];
    private int[] Speed = new int[2];
    private double fitness;
    private int[] bestPosition = new int[2];
    private double bestFitness = 0;
    int maxprice;
    int maxweight;


    Particle(int pX, int pY, int xSpeed, int ySpeed, int maxprice,int maxweight){
        position[0] = pX;
        position[1] = pY;
        bestPosition[0] = pX;
        bestPosition[1] = pY;
        Speed[0] = xSpeed;
        Speed[1] = ySpeed;
        this.maxprice=maxprice;
        this.maxweight=maxweight;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public int[] getSpeed() {
        return Speed;
    }

    public void setSpeedX(int speed) {
        Speed[0] = speed;
    }
    public void setSpeedY(int speed) {
        Speed[1] = speed;
    }

    public double getFitness() {
        CalculateFitness();
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(int[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }


    public void CalculateFitness(){
        double fitnessActuel;
        if ((position[0]<=0)||(position[1]<=0)||(position[1]>maxprice)||(position[1]>maxweight)){
            fitnessActuel=-1;
        }
        else {
            fitnessActuel=(double)position[0]/(double)position[1];
        }

        if (fitnessActuel > fitness){
            setBestPosition(getPosition());
        }
        fitness=fitnessActuel;
    }
}
