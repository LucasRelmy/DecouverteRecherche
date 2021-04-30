import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        int nbIter = 50;
        //récupération des éléments
        String path = "Code/Data/data1.txt";
        InputReader fichierTxt = new InputReader();
        System.out.println(fichierTxt.getData(path));


        List<Element> elements = fichierTxt.getData(path);
        ArrayList<Particle> particles = new ArrayList<Particle>();

        //calcul prix et poid max
        int maxprice = 0 ;
        int maxweight = 0;
        for (int i = 0; i < elements.size(); i++){
            maxprice += elements.get(i).getPrice();
            maxweight += elements.get(i).getWeight();

        }
        System.out.println("poidsmax et prixmax : " + maxweight +" , " + maxprice);
        Swarm swarm = new Swarm(10,maxweight,maxprice,0.5,0.5);
        particles=swarm.getParticles();
        for (int i = 0; i < (long) particles.size(); i++){
            System.out.println("Particule "+i);
            System.out.println("Position :" + Arrays.toString(particles.get(i).getPosition()));
            System.out.println("Vitesse :" + Arrays.toString(particles.get(i).getSpeed()));
            System.out.println("Fitness :" + particles.get(i).getFitness());
        }
        System.out.println("Meilleur Fitness au départ : " + swarm.getBestFitness());

        //iteration cycle
        for (int i=0;i<nbIter;i++){
            swarm.UpdateParticlePos();
            //suivi d'une particule
            System.out.println("Particule "+1);
            System.out.println("Position :" + Arrays.toString(particles.get(1).getPosition()));
            System.out.println("Vitesse :" + Arrays.toString(particles.get(1).getSpeed()));
            System.out.println("Fitness :" + particles.get(1).getFitness());
            System.out.println("Meilleur Position :" + Arrays.toString(particles.get(1).getBestPosition()));
            System.out.println("Meilleur Fitness :" + particles.get(1).getBestFitness());


        }
        swarm.applicationEnsemble();
        swarm.getBestFitness();
        System.out.println("Meilleur solution :");
        System.out.println("Position (" + swarm.getBestPosition()[0] + ";" + swarm.getBestPosition()[1] +") , Fitness : " + swarm.getBestFitness());
        System.out.println("Ensemble d'objets correspondants : //TODO");
    }
}
