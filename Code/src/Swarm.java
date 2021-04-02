public class Swarm {
    private Particle[] particles;
    private long[] bestPosition;
    private double bestFitness;

    public Swarm(int numParticles) {
        particles = new Particle[numParticles];
        for (int i = 0; i < numParticles; i++) {
            //random pos within bound
            int[] initialParticlePosition=null;
            //random speed
            int[] initialParticleSpeed=null;
            particles[i] = new Particle(
                    initialParticlePosition[0],initialParticlePosition[1], initialParticleSpeed[0], initialParticleSpeed[1]);
        }
    }
}
