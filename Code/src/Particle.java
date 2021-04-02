public class Particle {
    private int[] position;
    private int[] Speed;
    private int fitness;
    private int[] bestPosition;
    private double bestFitness;
    Particle(int pX, int pY, int xSpeed, int ySpeed){
        position[0] = pX;
        position[1] = pY;
        Speed[0] = xSpeed;
        Speed[1] = ySpeed;
    }
    public void CalculateFitness(){

    }
}
