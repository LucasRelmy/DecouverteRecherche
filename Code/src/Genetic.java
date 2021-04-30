import java.util.Random;

public class Genetic {
    public Particle tournament(Particle p1, Particle p2){
        if(p1.getFitness()> p2.getFitness()){
            return p1;
        }
        return p2;
    }
    public void mutation(Particle p){
        Random r = new Random();
        if((r.nextInt((100 - 0) + 1) + 0)>50){
        }
    }
}
