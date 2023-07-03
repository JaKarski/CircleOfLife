import Zwierzeta.Cyber
from Roslina import Roslina
from Zwierze import Zwierze


class Barszcz(Roslina):
    def __init__(self, x, y, moj):
        self.sila = 10
        self.inicjatywa = 0
        self.symbol = 'b'
        self.nazwa = "barszcz sosnowskiego"
        self.wiek = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Barszcz(x, y, self.moj)

    def akcja(self):
        for organizm in self.moj.organizmy:
            if organizm.czyZyje:
                if not isinstance(organizm, Zwierzeta.Cyber.CyberOwca):
                    if self.x - 1 <= organizm.x <= self.x + 1 and self.y - 1 <= organizm.y <= self.y + 1:
                        if organizm is not self and isinstance(organizm, Zwierze):
                            self.moj.komentarz = self.moj.komentarz + "Organizm: " + self.nazwa + " zabil organizm "+ organizm.nazwa +" w poblizu na x=" + str(
                                organizm.x) + " y=" + str(organizm.y) + '\n'
                            organizm.czyZyje = False
        super(Barszcz, self).akcja()

    def obrona(self, atakujacy):
        if isinstance(atakujacy, Zwierzeta.Cyber.CyberOwca):
            self.czyZyje = False
        return True
