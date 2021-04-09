import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        String path = "Code/Data/data1.txt";
        InputReader fichierTxt = new InputReader();
        System.out.println(fichierTxt.getData(path));
        ArrayList<Particle> particles = new ArrayList<Particle>();
        Swarm swarm = new Swarm(10,100,30);
        particles=swarm.getParticles();
        for (int i = 0; i < (long) particles.size(); i++){
            System.out.println("Particule "+i);
            System.out.println("Position :" + Arrays.toString(particles.get(i).getPosition()));
            System.out.println("Vitesse :" + Arrays.toString(particles.get(i).getSpeed()));
            System.out.println("Fitness :" + particles.get(i).getFitness());
        }
        System.out.println("Meilleur Fitness au départ : " + swarm.getBestFitness());


    }
}
