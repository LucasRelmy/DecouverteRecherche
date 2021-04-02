public class Particle {
    private int[] position;
    private int[] Speed;
    private int fitness;
    private int[] bestPosition;
    private double bestFitness;

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getSpeed() {
        return Speed;
    }

    public void setSpeed(int[] speed) {
        Speed = speed;
    }

    public int getFitness() {
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

    Particle(int pX, int pY, int xSpeed, int ySpeed){
        position[0] = pX;
        position[1] = pY;
        Speed[0] = xSpeed;
        Speed[1] = ySpeed;
    }
    public void CalculateFitness(){
        fitness=position[0]/position[1];
    }
}
