from operator import attrgetter

from Rosliny.Barszcz import Barszcz
from Rosliny.Guarana import Guarana
from Rosliny.Jagody import Jagody
from Rosliny.Mlecz import Mlecz
from Rosliny.Trawa import Trawa
from Zwierzeta.Antylopa import Antylopa
from Zwierzeta.Cyber import CyberOwca
from Zwierzeta.Czlowiek import Czlowiek
from Zwierzeta.Lis import Lis
from Zwierzeta.Wilk import Wilk
from Zwierzeta.Owca import Owca
from Zwierzeta.Zolw import Zolw


class Swiat:
    def __init__(self, x, y):
        self.ruchy = None
        self.x = x
        self.y = y
        self.tab = [[" " for col in range(y)] for row in range(x)]
        self.organizmy = []
        self.komentarz = ""
        #self.organizmy.append(Zolw(1, 6, self))
        #self.organizmy.append(Zolw(8, 2, self))
        self.organizmy.append(Czlowiek(5, 5, self))
        #self.organizmy.append(Lis(2, 2, self))
        #self.organizmy.append(Antylopa(6, 6, self))
        #self.organizmy.append(Wilk(8, 8, self))
        #self.organizmy.append(Wilk(9, 9, self))
        #self.organizmy.append(Owca(0, 9, self))
        #self.organizmy.sort(key=attrgetter("inicjatywa", "wiek"))
        #self.organizmy.reverse()
        #self.uzupelnij_tablice()

    def uzupelnij_tablice(self):
        for j in range(self.y):
            for i in range(self.x):
                for organizm in self.organizmy:
                    if organizm.x == j and organizm.y == i and organizm.czyZyje:
                        self.tab[i][j] = organizm.symbol
                        break
                    else:
                        self.tab[i][j] = ' '

    def wykonaj_Ture(self, input):
        self.ruchy=input
        self.komentarz=''
        for organizm in self.organizmy:
            if organizm.czyZyje:
                organizm.akcja()
                self.uzupelnij_tablice()
        for organizm in self.organizmy:
            organizm.wiek_wzrasta()
        # sortowanie soon
        for i in range(len(self.organizmy) - 1, -1, -1):
            if not self.organizmy[i].czyZyje:
                self.organizmy.pop(i)
        self.organizmy.sort(key=attrgetter("inicjatywa", "wiek"))
        self.organizmy.reverse()

    def dodaj_organizm(self, jaki, x, y):
        if jaki == ["wilk"]:
            self.organizmy.append(Wilk(x, y, self))
        elif jaki == ["owca"]:
            self.organizmy.append(Owca(x, y, self))
        elif jaki == ["lis"]:
            self.organizmy.append(Lis(x, y, self))
        elif jaki == ["zolw"]:
            self.organizmy.append(Zolw(x, y, self))
        elif jaki == ["antylopa"]:
            self.organizmy.append(Antylopa(x, y, self))
        elif jaki == ["cyber-owca"]:
            self.organizmy.append(CyberOwca(x, y, self))
        elif jaki == ["trawa"]:
            self.organizmy.append(Trawa(x, y, self))
        elif jaki == ["mlecz"]:
            self.organizmy.append(Mlecz(x, y, self))
        elif jaki == ["guarana"]:
            self.organizmy.append(Guarana(x, y, self))
        elif jaki == ["wilcze jagody"]:
            self.organizmy.append(Jagody(x, y, self))
        elif jaki == ["barszcz sosnowskiego"]:
            self.organizmy.append(Barszcz(x, y, self))
        self.organizmy.sort(key=attrgetter("inicjatywa", "wiek"))
        self.organizmy.reverse()
        self.uzupelnij_tablice()