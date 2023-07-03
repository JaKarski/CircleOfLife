from random import randrange

from Zwierze import Zwierze


class Lis(Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 3
        self.inicjatywa = 7
        self.symbol = 'L'
        self.nazwa = "lis"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def czyKolizje(self, x, y):
        if self.moj.tab[y][x] == ' ':
            return False
        else:
            return True

    def czySilniejszy(self, x, y):
        for organizm in self.moj.organizmy:
            if organizm.x == x and organizm.y == y and organizm is not self and organizm.sila > self.sila:
                return True
        return False

    def wech(self, kierunek):
        if kierunek == 0:
            if 0 <= self.x < self.moj.x - 1:
                if self.czyKolizje(self.x + 1, self.y):
                    if self.czySilniejszy(self.x + 1, self.y):
                        self.moj.komentarz = self.moj.komentarz + "Lis spryciarz" + '\n'
                        return True
            else:
                return False
        elif kierunek == 1:
            if 0 < self.x <= self.moj.x - 1:
                if self.czyKolizje(self.x - 1, self.y):
                    if self.czySilniejszy(self.x - 1, self.y):
                        self.moj.komentarz = self.moj.komentarz + "Lis spryciarz" + '\n'
                        return True
            else:
                return False
        elif kierunek == 2:
            if 0 < self.y <= self.moj.y - 1:
                if self.czyKolizje(self.x, self.y - 1):
                    if self.czySilniejszy(self.x, self.y - 1):
                        self.moj.komentarz = self.moj.komentarz + "Lis spryciarz" + '\n'
                        return True
            else:
                return False
        elif kierunek == 3:
            if 0 <= self.y < self.moj.y - 1:
                if self.czyKolizje(self.x, self.y + 1):
                    if self.czySilniejszy(self.x, self.y + 1):
                        self.moj.komentarz = self.moj.komentarz + "Lis spryciarz" + '\n'
                        return True
            else:
                return False
        return True

    def akcja(self):
        kierunek = randrange(4)
        licznik = 1

        while (True):
            if licznik > 4:
                return
            elif self.wech(kierunek):
                kierunek = (kierunek + 1) % 4
                licznik += 1
            else:
                break

        if kierunek == 0:
            if 0 <= self.x < self.moj.x - 1:
                self.x += 1
                if self.czyKolizja():
                    self.kolizja(0)
        elif kierunek == 1:
            if 0 < self.x <= self.moj.x - 1:
                self.x -= 1
                if self.czyKolizja():
                    self.kolizja(1)
        elif kierunek == 2:
            if 0 < self.y <= self.moj.y - 1:
                self.y -= 1
                if self.czyKolizja():
                    self.kolizja(2)
        elif kierunek == 3:
            if 0 <= self.y < self.moj.y - 1:
                self.y += 1
                if self.czyKolizja():
                    self.kolizja(3)

    def generator(self, x, y):
        return Lis(x, y, self.moj)
