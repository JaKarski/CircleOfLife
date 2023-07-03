from Roslina import Roslina


class Jagody(Roslina):
    def __init__(self, x, y, moj):
        self.sila = 99
        self.inicjatywa = 0
        self.symbol = '*'
        self.nazwa = "wilcze jagody"
        self.wiek = 0
        self.x = x
        self.y = y
        self.moj = moj
        self.czyZyje = True

    def generator(self, x, y):
        return Jagody(x, y, self.moj)

    def obrona(self, atakujacy):
        self.czyZyje = False
        return False
