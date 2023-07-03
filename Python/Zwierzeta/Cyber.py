from math import sqrt

import Rosliny.Barszcz
from Zwierze import Zwierze


class CyberOwca(Zwierze):
    def __init__(self, x, y, moj):
        self.sila = 11
        self.inicjatywa = 4
        self.symbol = '#'
        self.nazwa = "cyber-owca"
        self.wiek = 0
        self.poRozmnozeniu = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True
        self.wybrany = None

    def akcja(self):
        if self.wybrany is None or not self.wybrany.czyZyje:
            barszcze = []
            dystans = self.moj.x + self.moj.y
            for organizm in self.moj.organizmy:
                if isinstance(organizm, Rosliny.Barszcz.Barszcz) and organizm.czyZyje:
                    barszcze.append(organizm)
            if len(barszcze) > 0:
                for barszcz in barszcze:
                    if (barszcz.x - self.x) ^ 2 + (barszcz.x - self.x) ^ 2 < dystans:
                        self.wybrany = barszcz
                        dystans = int((barszcz.x - self.x) ^ 2 + (barszcz.x - self.x) ^ 2)
            else:
                self.wybrany = None
        if self.wybrany == None:
            super(CyberOwca, self).akcja()
        elif self.wybrany.x - self.x > 0:
            self.x += 1
            self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zbliza sie do barszczu zostalo mu na x:" + str(
                abs(self.x-self.wybrany.x)) + " i na y:" + str(abs(self.y-self.wybrany.y)) + '\n'
            if self.czyKolizja():
                self.kolizja(0)
        elif self.wybrany.x - self.x < 0:
            self.x -= 1
            self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zbliza sie do barszczu zostalo mu na x:" + str(
                abs(self.x - self.wybrany.x)) + " i na y:" + str(abs(self.y-self.wybrany.y)) + '\n'
            if self.czyKolizja():
                self.kolizja(1)
        elif self.wybrany.y - self.y < 0:
            self.y -= 1
            self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zbliza sie do barszczu zostalo mu na x:" + str(
                abs(self.x - self.wybrany.x)) + " i na y:" + str(abs(self.y-self.wybrany.y)) + '\n'
            if self.czyKolizja():
                self.kolizja(2)
        elif self.wybrany.y - self.y > 0:
            self.y += 1
            self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zbliza sie do barszczu zostalo mu na x:" + str(
                abs(self.x - self.wybrany.x)) + " i na y:" + str(abs(self.y-self.wybrany.y)) + '\n'
            if self.czyKolizja():
                self.kolizja(3)

    def generator(self, x, y):
        return CyberOwca(x, y, self.moj)
