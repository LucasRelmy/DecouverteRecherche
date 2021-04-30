import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Swarm {
    private ArrayList<Particle> particles;
    private int[] bestPosition;
    private double bestFitness;
    private Particle bestParticle;
    private int maxprice;
    private int maxweight;
    private double inertia;
    private double acceleration;

    public ArrayList<Particle> getParticles() {
        return particles;
    }

    public void setParticles(ArrayList<Particle> particles) {
        this.particles = particles;
    }

    public int[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(int[] bestPosition) {
        this.bestPosition = bestPosition;
    }


    public double getBestFitness() {
        for (int i = 0; i < (long) particles.size(); i++){
            if(particles.get(i).getFitness()>bestFitness){
                bestFitness = particles.get(i).getFitness();
                bestPosition = particles.get(i).getPosition();
                bestParticle = particles.get(i);
            }
        }
        return bestFitness;
    }

    public Swarm(int numParticles,int maxWeight,int maxPrice,double inertia,double acceleration) {
        this.inertia = inertia;
        this.acceleration = acceleration;
        this.maxprice = maxPrice;
        this.maxweight = maxWeight;
        bestFitness = 0;
        particles = new ArrayList<Particle>();
        for (int i = 0; i < numParticles; i++) {

            //random pos within bound
            Random r = new Random();
            int[] initialParticlePosition = new int[2];
            int[] initialParticleSpeed = new int[2];

            initialParticlePosition[0]=r.nextInt((maxWeight - 1) + 1) + 1;
            initialParticlePosition[1]=r.nextInt((maxPrice - 1) + 1) + 1;

            initialParticleSpeed[0]=r.nextInt((15 - 1) + 1) + 1;
            initialParticleSpeed[1]=r.nextInt((15 - 1) + 1) + 1;

            particles.add(new Particle(
                    initialParticlePosition[0],initialParticlePosition[1], initialParticleSpeed[0], initialParticleSpeed[1], maxprice, maxweight));
        }
        getBestFitness();
    }

    public void UpdateParticlePos(){
        for (int i = 0; i < (long) particles.size(); i++){

            Random r = new Random();

            double randomMove = r.nextDouble();
            particles.get(i).setSpeedX((int) (particles.get(i).getSpeed()[0] + inertia * randomMove*(particles.get(i).getBestPosition()[0]-particles.get(i).getPosition()[0])+acceleration*(bestPosition[0]-particles.get(i).getPosition()[0])));
            particles.get(i).setSpeedY((int) (particles.get(i).getSpeed()[1] + inertia * randomMove*(particles.get(i).getBestPosition()[1]-particles.get(i).getPosition()[1])+acceleration*(bestPosition[0]-particles.get(i).getPosition()[0])));

            particles.get(i).setPosition(particles.get(i).getPosition()[0]+particles.get(i).getSpeed()[0],particles.get(i).getPosition()[1]+particles.get(i).getSpeed()[1]);
            vérifFaisabilité();
            getBestFitness();

        }
    }
    public void vérifFaisabilité(){

        for (int i = 0; i < (long) particles.size(); i++) {
            if ((particles.get(i).getPosition()[0] <= 0) || (particles.get(i).getPosition()[1] <= 0)) {
                Random r = new Random();
                // on replace la particule au meilleur local et on reset sa vitesse
                particles.get(i).setPosition(particles.get(i).getBestPosition()[0], particles.get(i).getBestPosition()[1]);
                particles.get(i).setSpeedX(r.nextInt((15 - 1) + 1) + 1);
                particles.get(i).setSpeedY(r.nextInt((15 - 1) + 1) + 1);
            }
            if ((particles.get(i).getPosition()[1] > maxprice) || (particles.get(i).getPosition()[0] > maxweight)) {

                Random r = new Random();
                // on replace la particule au meilleur local et on reset sa vitesse
                particles.get(i).setPosition(particles.get(i).getBestPosition()[0], particles.get(i).getBestPosition()[1]);
                particles.get(i).setSpeedX(r.nextInt((15 - 1) + 1) + 1);
                particles.get(i).setSpeedY(r.nextInt((15 - 1) + 1) + 1);
            }

        }
    }
    public void applicationEnsemble(){
        // vérifie si les coordonnées de la particule correspondent a un ensemble, déplace la particule à l'emplacement de l'ensemble le plus proche et avec la meilleur fitness sinon
    }
}
