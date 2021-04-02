import java.util.Random;

public class Swarm {
    private Particle[] particles;
    private long[] bestPosition;
    private double bestFitness;

    public Particle[] getParticles() {
        return particles;
    }

    public void setParticles(Particle[] particles) {
        this.particles = particles;
    }

    public long[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(long[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        for (int i = 0; i < particles.length; i++){
            if(particles[i].getFitness()<bestFitness){
                bestFitness=particles[i].getFitness();
            }
        }
        return bestFitness;
    }

    public Swarm(int numParticles,int maxWeight,int maxPrice) {
        bestFitness=0;
        particles = new Particle[numParticles];
        for (int i = 0; i < numParticles; i++) {

            //random pos within bound
            Random r = new Random();
            int[] initialParticlePosition = new int[1];
            int[] initialParticleSpeed = new int[1];

            initialParticlePosition[0]=r.nextInt((maxWeight - 0) + 1) + 0;
            initialParticlePosition[1]=r.nextInt((maxPrice - 0) + 1) + 0;

            initialParticleSpeed[0]=r.nextInt((maxWeight - 0) + 1) + 0;
            initialParticleSpeed[1]=r.nextInt((maxPrice - 0) + 1) + 0;

            particles[i] = new Particle(
                    initialParticlePosition[0],initialParticlePosition[1], initialParticleSpeed[0], initialParticleSpeed[1]);
        }
    }
}
