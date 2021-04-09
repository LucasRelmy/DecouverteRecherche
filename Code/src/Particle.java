public class Particle {
    private int[] position = new int[2];
    private int[] Speed = new int[2];
    private int fitness;
    private int[] bestPosition = new int[2];
    private double bestFitness;

    Particle(int pX, int pY, int xSpeed, int ySpeed){
        position[0] = pX;
        position[1] = pY;
        Speed[0] = xSpeed;
        Speed[1] = ySpeed;
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

    public void setSpeed(int[] speed) {
        Speed = speed;
    }

    public int getFitness() {
        CalculateFitness();
        return fitness;
    }

    public void setFitness(int fitness) {
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
        fitness=position[0]/position[1];
    }
}
