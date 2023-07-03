from Organizm import Organizm
from abc import ABC, abstractmethod
from random import randrange


class Zwierze(Organizm, ABC):
    def czyKolizja(self):
        if self.moj.tab[self.y][self.x] == ' ':
            return False
        else:
            return True

    def czyWalka(self):
        if self.moj.tab[self.y][self.x] == self.symbol:
            return False
        else:
            return True

    def cofanie(self, powrot):
        if powrot == 0:
            self.x -= 1
        elif powrot == 1:
            self.x += 1
        elif powrot == 2:
            self.y += 1
        elif powrot == 3:
            self.y -= 1

    def rozmnazanie(self):
        if self.x + 1 < self.moj.x - 1:
            if self.moj.tab[self.y][self.x + 1] == ' ':
                self.moj.organizmy.append(self.generator(self.x + 1, self.y))
                self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " rozmnozyl sie na x="+ str(self.x+1) + " y=" + str(self.y)+'\n'
                self.poRozmnozeniu = 0
                return
        if self.x - 1 > 0:
            if self.moj.tab[self.y][self.x - 1] == ' ':
                self.moj.organizmy.append(self.generator(self.x - 1, self.y))
                self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " rozmnozyl sie na x=" + str(
                    self.x - 1) + " y=" + str(self.y)+'\n'
                self.poRozmnozeniu = 0
                return
        if self.y + 1 < self.moj.y - 1:
            if self.moj.tab[self.y + 1][self.x] == ' ':
                self.moj.organizmy.append(self.generator(self.x, self.y + 1))
                self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " rozmnozyl sie na x=" + str(
                    self.x) + " y=" + str(self.y - 1)+'\n'
                self.poRozmnozeniu = 0
                return
        if self.y - 1 > 0:
            if self.moj.tab[self.y - 1][self.x] == ' ':
                self.moj.organizmy.append(self.generator(self.x, self.y - 1))
                self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " rozmnozyl sie na x=" + str(
                    self.x) + " y=" + str(self.y - 1)+'\n'
                self.poRozmnozeniu = 0
                return

    def kolizja(self, powrot):
        if self.czyWalka():
            for organizm in self.moj.organizmy:
                if organizm.czyZyje:
                    if organizm.x == self.x and organizm.y == self.y and organizm.symbol != self.symbol:
                        if organizm.obrona(self):
                            self.cofanie(powrot)
                        else:
                            if organizm.sila <= self.sila:
                                organizm.czyZyje = False
                                self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zaatakowal " + organizm.nazwa + " na x=" +str(
                    self.x) + " y=" + str(self.y)+ " i wygral"+'\n'
                            else:
                                self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zaatakowal " + organizm.nazwa + " na x=" + str(
                                    self.x) + " y=" + str(self.y) + " i przeral"+'\n'
                                self.czyZyje = False
        else:
            self.cofanie(powrot)
            if self.poRozmnozeniu > 3:
                self.rozmnazanie()

    def akcja(self):
        kierunek = randrange(4)

        if kierunek == 0:
            if 0 <= self.x < self.moj.x-1:
                self.x += 1
                if self.czyKolizja():
                    self.kolizja(0)
        elif kierunek == 1:
            if 0 < self.x <= self.moj.x-1:
                self.x -= 1
                if self.czyKolizja():
                    self.kolizja(1)
        elif kierunek == 2:
            if 0 < self.y <= self.moj.y-1:
                self.y -= 1
                if self.czyKolizja():
                    self.kolizja(2)
        elif kierunek == 3:
            if 0 <= self.y < self.moj.y-1:
                self.y += 1
                if self.czyKolizja():
                    self.kolizja(3)

    @property
    def poRozmnozeniu(self):
        return self.__poRozmnozeniu

    def wiek_wzrasta(self):
        super(Zwierze, self).wiek_wzrasta()
        self.poRozmnozeniu += 1

    @poRozmnozeniu.setter
    def poRozmnozeniu(self, poRozmnozeniu):
        self.__poRozmnozeniu = poRozmnozeniu
