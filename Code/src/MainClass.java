import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String path = "Code/Data/data1.txt";
        InputReader fichierTxt = new InputReader();

        //Le fichier PointGraphique.txt se situera dans le repertoir DATA
        File fichierOut = new File("PointGraphique.txt");

        //On va ecrire dans fichierOut
        Writer writer = new FileWriter(fichierOut);

        System.out.println(fichierTxt.getData(path));
        ArrayList<Particle> particles = new ArrayList<Particle>();
        Swarm swarm = new Swarm(10,100,30);
        particles=swarm.getParticles();
        for (int i = 0; i < (long) particles.size(); i++){
            System.out.println("Particule "+i);
            System.out.println("Position :" + Arrays.toString(particles.get(i).getPosition()));

            //ecrit le resultat de la position dans le fichier PointGraphique
            writer.write(String.valueOf(Arrays.toString(particles.get(i).getPosition())));
            writer.write("\n");
            System.out.println("Vitesse :" + Arrays.toString(particles.get(i).getSpeed()));
            System.out.println("Fitness :" + particles.get(i).getFitness());
        }
        System.out.println("Meilleur Fitness au départ : " + swarm.getBestFitness());
        writer.close();





    }
}
