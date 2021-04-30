from pylab import *
import matplotlib.pyplot as plt

liste = []
abscisse = []
ordonne = []

# recupere le contenu de PointGrphique.txt et le met dans liste
# enleve les crochets et les retours à la ligne
with open("PointGraphique.txt", "r") as fichier:
    for points in fichier:
        liste.append(points.translate({ord(i): None for i in '[]\n'}))

# je sépare tous les éléments pour que dans la liste il ne reste plus que chaque point séparé
for element in range(len(liste)):
    x = liste.pop().split(",")
    for elemntx in x:
        liste.insert(0,int(elemntx))
# liste contient chaque point dans cete ordre : 
# ordonne et abscisse
print(liste)

plt.title("Evolution")

while liste:
    plt.plot(liste.pop(), liste.pop(), "g.")
    
plt.xlabel("On s'en fou")
plt.ylabel("on s'en fou 2")
# plt.axis([0, 100, 0, 100])
show()
