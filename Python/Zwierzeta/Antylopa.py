from random import randrange

from Zwierze import Zwierze


class Antylopa(Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 4
        self.inicjatywa = 4
        self.symbol = 'A'
        self.nazwa = "antylopa"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True


    def obrona(self, atakujacy):
        prawdopodobienstwo = randrange(2)
        if prawdopodobienstwo == 0:
            if 0 < self.x < self.moj.x and 0 < self.y < self.moj.y:
                if self.moj.tab[self.y + 1][self.x] == ' ':
                    self.y += 1
                    self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " uniknal walki i udaje sie na x=" + str(
                        self.x) + " y=" + str(self.y) + '\n'
                    return True
                elif self.moj.tab[self.y - 1][self.x] == ' ':
                    self.y -= 1
                    self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " uniknal walki i udaje sie na x=" + str(
                        self.x) + " y=" + str(self.y) + '\n'
                    return True
                elif self.moj.tab[self.y][self.x + 1] == ' ':
                    self.x += 1
                    self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " uniknal walki i udaje sie na x=" + str(
                        self.x) + " y=" + str(self.y) + '\n'
                    return True
                elif self.moj.tab[self.y][self.x - 1] == ' ':
                    self.x -= 1
                    self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " uniknal walki i udaje sie na x=" + str(
                        self.x) + " y=" + str(self.y) + '\n'
                    return True
                else:
                    return False
            else:
                return False

    def cofanie(self, powrot):
        if powrot == 0:
            self.x -= 2
        elif powrot == 1:
            self.x += 2
        elif powrot == 2:
            self.y += 2
        elif powrot == 3:
            self.y -= 2

    def akcja(self):
        kierunek = randrange(4)

        if kierunek == 0:
            if 1 <= self.x < self.moj.x - 2:
                self.x += 2
                if self.czyKolizja():
                    self.kolizja(0)
        elif kierunek == 1:
            if 1 < self.x <= self.moj.x - 1:
                self.x -= 2
                if self.czyKolizja():
                    self.kolizja(1)
        elif kierunek == 2:
            if 1 < self.y <= self.moj.y - 1:
                self.y -= 2
                if self.czyKolizja():
                    self.kolizja(2)
        elif kierunek == 3:
            if 1 <= self.y < self.moj.y - 2:
                self.y += 2
                if self.czyKolizja():
                    self.kolizja(3)

    def generator(self, x, y):
        return Antylopa(x, y, self.moj)
