import java.util.ArrayList;
import java.util.Random;

public class Swarm {
    private ArrayList<Particle> particles;
    private int[] bestPosition;
    private double bestFitness;

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
            if(particles.get(i).getFitness()<bestFitness){
                bestFitness= particles.get(i).getFitness();
                bestPosition= particles.get(i).getPosition();
            }
        }
        return bestFitness;
    }

    public Swarm(int numParticles,int maxWeight,int maxPrice) {
        bestFitness=0;
        particles = new ArrayList<Particle>();
        for (int i = 0; i < numParticles; i++) {

            //random pos within bound
            Random r = new Random();
            int[] initialParticlePosition = new int[2];
            int[] initialParticleSpeed = new int[2];

            initialParticlePosition[0]=r.nextInt((maxWeight - 1) + 1) + 1;
            initialParticlePosition[1]=r.nextInt((maxPrice - 1) + 1) + 1;

            initialParticleSpeed[0]=r.nextInt((maxWeight - 1) + 1) + 1;
            initialParticleSpeed[1]=r.nextInt((maxPrice - 1) + 1) + 1;

            particles.add(new Particle(
                    initialParticlePosition[0],initialParticlePosition[1], initialParticleSpeed[0], initialParticleSpeed[1]));
        }
        getBestFitness();
    }

    public void UpdateParticlePos(){
        for (int i = 0; i < (long) particles.size(); i++){
            if(particles.get(i).getFitness()<bestFitness){
                particles.get(i).setPosition(particles.get(i).getPosition()[0]+particles.get(i).getSpeed()[0],particles.get(i).getPosition()[1]+particles.get(i).getSpeed()[1]);
            }
        }
    }
}
